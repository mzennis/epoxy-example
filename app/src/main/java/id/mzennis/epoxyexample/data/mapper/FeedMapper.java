package id.mzennis.epoxyexample.data.mapper;

import com.google.gson.GsonBuilder;

import id.mzennis.epoxyexample.domain.model.feed.FeedDomain;
import io.reactivex.functions.Function;
import retrofit2.Response;

/**
 * Created by meyta on 04/01/18.
 */

public class FeedMapper implements Function<Response<String>, FeedDomain> {

    public FeedMapper(){}

    @Override
    public FeedDomain apply(Response<String> stringResponse) throws Exception {
        return mappingResponse(stringResponse);
    }

    private FeedDomain mappingResponse(Response<String> response) {
        FeedDomain model;
        if (response.isSuccessful()) {
            String responseJson = String.valueOf(response.body());
            model = new GsonBuilder().create().fromJson(responseJson, FeedDomain.class);
        } else {
            throw new RuntimeException(String.valueOf(response.code()));
        }
        return model;
    }
}
