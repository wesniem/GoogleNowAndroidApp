package nyc.c4q.wesniemarcelin.googlenowandroidapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import nyc.c4q.wesniemarcelin.googlenowandroidapp.TodoList.TodoListCarddata;
import nyc.c4q.wesniemarcelin.googlenowandroidapp.model.Quotes;
import nyc.c4q.wesniemarcelin.googlenowandroidapp.model.VineResponse;
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
    private SwipeRefreshLayout swipeContainer;
    private AlertDialog confirmDialogObject;
    private static final String MODIFIED_NOTE = "Modified Note";
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String NOTE = "noteKey";
    private EditText notepad;

    public static SharedPreferences sharedpreferences;


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    ArrayList<CardData> data;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new ArrayList<CardData>();
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        data.add(new VineCardData(R.drawable.video_of_the_day_image));
        data.add(new TodoListCarddata());


        vineRetrofitCall();
        quoteretrofitCall();
        sharedpreferences = getPreferences(MODE_PRIVATE);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);
        notepad = (EditText) findViewById(R.id.edit_text_notepad);
        buildConfirmDialog();

        //Setting for refresh
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //quoteRetrofitcall
                //vineRetroFitCall
                //Service call goes here
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.

                vineRetrofitCall();
                onRefreshQuoteRetrofitCall();
                swipeContainer.setRefreshing(false);
            }
        });
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
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

    public void onRefreshQuoteRetrofitCall() {
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
//                data.add(new QuoteCardData(quote));
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
                    VineCardData vineUserId = (VineCardData) data.get(0);
                    obj.setUrl(response.body().getData().getRecords().get(0).videoUrl);
                    vineAvatar.setAvatarUrl(response.body().getData().getRecords().get(0).avatarUrl);
                    vineUsername.setUsername(response.body().getData().getRecords().get(0).username);
                    vineUserId.setUserID(response.body().getData().getRecords().get(0).userId);
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


    public void buildConfirmDialog() {
        AlertDialog.Builder confirmBuilder = new AlertDialog.Builder(this);
        confirmBuilder.setTitle("Are you sure?");
        confirmBuilder.setMessage("Are you sure you want to save this note?");

        confirmBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                notepad = (EditText) findViewById(R.id.edit_text_notepad);
                Log.d("Save Note: ", "Contact Note: " + notepad.getText());

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(NOTE, notepad.getText().toString()).apply();
                Toast.makeText(MainActivity.this, sharedpreferences.getString(NOTE, "default"), Toast.LENGTH_SHORT).show();

            }
        });

        confirmBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //do nothing
            }
        });

        confirmDialogObject = confirmBuilder.create();
    }

    public void saveNote(View view) {
        confirmDialogObject.show();
    }
}
