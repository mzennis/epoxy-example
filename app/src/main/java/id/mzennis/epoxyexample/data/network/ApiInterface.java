package id.mzennis.epoxyexample.data.network;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by meyta on 11/12/17.
 */

public interface ApiInterface {

    @GET("sample{id}.json")
    Observable<Response<String>> getFeed(
            @Path("id") String id
    );
}
