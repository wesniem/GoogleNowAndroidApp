package nyc.c4q.wesniemarcelin.googlenowandroidapp.network;

import nyc.c4q.wesniemarcelin.googlenowandroidapp.model.Quotes;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by josevila on 11/12/16.
 */

public interface QuoteService {
        @GET("random.json")
        Call<Quotes> listQuotes();
}
