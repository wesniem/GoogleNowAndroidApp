package nyc.c4q.wesniemarcelin.googlenowandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import nyc.c4q.wesniemarcelin.googlenowandroidapp.model.Example;
import nyc.c4q.wesniemarcelin.googlenowandroidapp.network.VineService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String DEVELOPER_KEY = "AIzaSyColbHiXyjGN_fNauWnA__fVi92jaYYjg0";
    private static final String VIDEO_ID = "srH-2pQdKhg";
    private static final int RECOVERY_DIALOG_REQUEST = 1;
    public static final String BASE_URL = "https://api.vineapp.com/";
    private static final String TAG ="YOOOOO" ;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    ArrayList<Object> data;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new ArrayList<Object>();
        data.add(new VineCardData(R.drawable.video_of_the_day_image));
        data.add(new VineCardData(R.drawable.video_of_the_day_image));
        data.add(new VineCardData(R.drawable.video_of_the_day_image));
        retrofitCall();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);

    }


    public void retrofitCall(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        VineService service = retrofit.create(VineService.class);

        Call<Example> call = service.listRepos();
        Log.d(TAG, "Succ");
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "Success: " + response.body().toString());
                    VineCardData obj = (VineCardData) data.get(0);
                    VineCardData vineAvatar = (VineCardData) data.get(0);
                    VineCardData vineUsername = (VineCardData) data.get(0);
                    obj.setUrl(response.body().getData().getRecords().get(0).videoUrl);
                    vineAvatar.setAvatarUrl(response.body().getData().getRecords().get(0).avatarUrl);
                    vineUsername.setUsername(response.body().getData().getRecords().get(0).username);
                    adapter.notifyDataSetChanged();

                } else {
                    Log.d(TAG, "Error: " + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                //When something doesn't go right and it is unable to get a response ex:no internet
                Log.d("Error: ", t.getMessage());
            }
        });


    }
}
