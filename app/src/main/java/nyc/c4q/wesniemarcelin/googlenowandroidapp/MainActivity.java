package nyc.c4q.wesniemarcelin.googlenowandroidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import nyc.c4q.wesniemarcelin.googlenowandroidapp.model.VineResponse;
import nyc.c4q.wesniemarcelin.googlenowandroidapp.model.Quotes;
import nyc.c4q.wesniemarcelin.googlenowandroidapp.network.QuoteService;
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
    public static final String QUOTE_URL = "http://quotes.stormconsultancy.co.uk/";
    private static final String TAG = "YOOOOO";

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    ArrayList<CardData> data;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new ArrayList<CardData>();
        data.add(new VineCardData(R.drawable.video_of_the_day_image));

        vineRetrofitCall();
        quoteretrofitCall();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);
    }

    public void quoteretrofitCall() {
        Retrofit quoteRetrofit = new Retrofit.Builder()
                .baseUrl(QUOTE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        QuoteService service = quoteRetrofit.create(QuoteService.class);

        Call<Quotes> call = service.listQuotes();
        Log.d(TAG, "Succ");
        call.enqueue(new Callback<Quotes>() {
            @Override
            public void onResponse(Call<Quotes> call, Response<Quotes> response) {
                    Log.d(TAG, "Success!" + response.body().toString());
                    Quotes quote = response.body();
                data.add(new QuoteCardData(quote));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Quotes> call, Throwable t) {
                Log.d(TAG, "Error!" + t.getMessage());
            }
        });
    }

    public void vineRetrofitCall() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        VineService service = retrofit.create(VineService.class);

        Call<VineResponse> call = service.listVines();
        Log.d(TAG, "Succ");
        call.enqueue(new Callback<VineResponse>() {
            @Override
            public void onResponse(Call<VineResponse> call, Response<VineResponse> response) {
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
            public void onFailure(Call<VineResponse> call, Throwable t) {
                //When something doesn't go right and it is unable to get a response ex:no internet
                Log.d("Error: ", t.getMessage());
            }
        });


    }
}
