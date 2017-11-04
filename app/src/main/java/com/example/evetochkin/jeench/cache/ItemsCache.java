package com.example.evetochkin.jeench.cache;

import com.example.evetochkin.jeench.model.content.Item;
import rx.Observable;
import io.realm.Realm;
import io.realm.RealmResults;
import rx.functions.Func1;

import java.util.List;

public class ItemsCache implements Observable.Transformer<List<Item>, List<Item>> {

        private final Func1<List<Item>, Observable<List<Item>>> mSaveFunc = items -> {
            Realm.getDefaultInstance().executeTransaction(realm -> {
                realm.delete(Item.class);
                realm.insert(items);
            });
            return Observable.just(items);
        };

        private final Func1<Throwable, Observable<List<Item>>> mCacheErrorHandler = throwable -> {
            Realm realm = Realm.getDefaultInstance();
            RealmResults<Item> results = realm.where(Item.class).findAll();
            return Observable.just(realm.copyFromRealm(results));
        };

        @Override
        public Observable<List<Item>> call(Observable<List<Item>> itemsObservable) {
            return itemsObservable
                    .flatMap(mSaveFunc)
                    .onErrorResumeNext(mCacheErrorHandler);
        }

}
