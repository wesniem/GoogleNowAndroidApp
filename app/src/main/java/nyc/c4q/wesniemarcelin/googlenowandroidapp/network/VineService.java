package nyc.c4q.wesniemarcelin.googlenowandroidapp.network;

import nyc.c4q.wesniemarcelin.googlenowandroidapp.model.VineResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by wesniemarcelin on 11/6/16.
 */

public interface VineService {
    @GET("timelines/tags/funny")
    Call<VineResponse> listVines();

}
