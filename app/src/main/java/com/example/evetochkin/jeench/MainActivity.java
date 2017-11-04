package com.example.evetochkin.jeench;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.evetochkin.jeench.adapters.ItemAdapter;
import com.example.evetochkin.jeench.api.ApiFactory;
import com.example.evetochkin.jeench.model.content.Item;
import com.example.evetochkin.jeench.model.response.ItemResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.activity_main)
    RelativeLayout activity_main;
    public static final String LOAD_ITEMS = "loadItems";

    private CompositeDisposable mCompositeDisposable;

    private ItemAdapter mAdapter;

    private ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCompositeDisposable = new CompositeDisposable();
        ButterKnife.bind(this);
        loadUI();
        loadItems();
    }

    private void loadUI() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
    }

    private void loadItems() {
        mCompositeDisposable.add(ApiFactory.getService().searchItems()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError));
    }

    private void handleError(Throwable error) {
        Toast.makeText(this, "Load error: " + error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        Log.d(LOAD_ITEMS + "error", error.getLocalizedMessage());
    }

    private void handleResponse(ItemResponse response) {
        items = new ArrayList<>(response.getMessage().);
        mAdapter = new DataAdapter(mAndroidArrayList);
        mRecyclerView.setAdapter(mAdapter);
        Log.d(LOAD_ITEMS, response.toString());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }

}
