package com.example.evetochkin.jeench.api;

import com.example.evetochkin.jeench.model.response.ItemResponse;
import retrofit2.http.GET;
import io.reactivex.Observable;


public interface JeenchService {
    @GET("search-items")
    Observable<ItemResponse> searchItems();
}
