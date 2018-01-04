package id.mzennis.epoxyexample.data.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import id.mzennis.epoxyexample.data.network.converter.StringResponseConverter;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by meyta on 11/12/17.
 */

public class RetrofitFactory {

    public static Retrofit.Builder createRetrofit(String url) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(okhttpBuilder().build())
                .addConverterFactory(new StringResponseConverter())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson));
    }

    public final static String API_BASE_URL_LIVE = "https://raw.githubusercontent.com/mzennis/epoxy-example/master/api/";

    public static OkHttpClient.Builder okhttpBuilder() {

        // Define the interceptor, add authentication headers
        Interceptor interceptors = chain -> {
            Request newRequest = chain.request().newBuilder()
                    .build();
            return chain.proceed(newRequest);
        };

        OkHttpClient.Builder okhttpBuilder = new OkHttpClient().newBuilder();
        okhttpBuilder.connectTimeout(60, TimeUnit.SECONDS);
        okhttpBuilder.writeTimeout(60, TimeUnit.SECONDS);
        okhttpBuilder.readTimeout(60, TimeUnit.SECONDS);

//        int cacheSize = 10 * 1024 * 1024; // 10 MiB
//        Cache cache = new Cache(context.getCacheDir(), cacheSize);
//        okhttpBuilder.cache(cache);

//        if (BuildConfig.DEBUG) {
//            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//            okhttpBuilder.addInterceptor(interceptor);
//        }

        // Add the interceptor to OkHttpClient
        okhttpBuilder.interceptors().add(interceptors);

        return okhttpBuilder;
    }
}
