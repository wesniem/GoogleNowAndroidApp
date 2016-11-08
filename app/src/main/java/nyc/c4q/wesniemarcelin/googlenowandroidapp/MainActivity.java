package nyc.c4q.wesniemarcelin.googlenowandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.youtube.player.YouTubePlayerFragment;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity  {

    private static final String DEVELOPER_KEY = "AIzaSyColbHiXyjGN_fNauWnA__fVi92jaYYjg0";
    private static final String VIDEO_ID = "srH-2pQdKhg";
    private static final int RECOVERY_DIALOG_REQUEST = 1;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    YouTubePlayerFragment myYouTubePlayerFragment;
    android.app.FragmentManager fragmentManager;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Object> data=  new ArrayList<Object>();
        data.add(new YouTubeCardData(R.drawable.video_of_the_day_image));
        data.add(new YouTubeCardData(R.drawable.video_of_the_day_image));
        data.add(new YouTubeCardData(R.drawable.video_of_the_day_image));


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);


//        try {
//            Glide.with(this).load(R.drawable.cover).into((ImageView) findViewById(R.id.backdrop_image));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        fragmentManager = getFragmentManager();
//        myYouTubePlayerFragment = new YouTubePlayerFragment();
//
//
//        myYouTubePlayerFragment.initialize(DEVELOPER_KEY, this);
//        fragmentManager.beginTransaction().replace(R.id.youtubeplayerfragment,myYouTubePlayerFragment).commit();

    }


//    @Override
//    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
//if(!wasRestored){
//    player.cueVideo(VIDEO_ID);
//}
//    }
//
//    @Override
//    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
//if(errorReason.isUserRecoverableError()){
//    errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
//}
//        else{
//    String errorMessage = String.format(
//            "There was an error initializing the YouTubePlayer (%1$s)",
//            errorReason.toString());
//    Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
//        }
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if(requestCode == RECOVERY_DIALOG_REQUEST){
//            //Retry initialization if user performed a recovery action
//            getYouTubePlayerProvider().initialize(DEVELOPER_KEY,this);
//        }
//    }
//
//    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
//        return (YouTubePlayerView)findViewById(R.id.youtubeplayerfragment);
//    }
}
