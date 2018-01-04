package id.mzennis.epoxyexample.data.network;

import retrofit2.Retrofit;

/**
 * Created by meyta on 11/12/17.
 */

public class ApiService {

    private ApiInterface apiInterface;

    public ApiService(String url) {
        initApiService(RetrofitFactory.createRetrofit(url).build());
    }

    protected void initApiService(Retrofit retrofit) {
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public ApiInterface getApi() {
        return apiInterface;
    }
}