package nyc.c4q.wesniemarcelin.googlenowandroidapp;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

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
        ArrayList<YouTubeCards> data=  new ArrayList<YouTubeCards>();
        data.add(new YouTubeCards(R.drawable.video_of_the_day_image));
        data.add(new YouTubeCards(R.drawable.video_of_the_day_image));
        data.add(new YouTubeCards(R.drawable.video_of_the_day_image));
//        data.add(new YouTubeCards(R.drawable.video_of_the_day_image));
//        data.add(new YouTubeCards(R.drawable.video_of_the_day_image));
//        data.add(new YouTubeCards(R.drawable.video_of_the_day_image));
//        data.add(new YouTubeCards(R.drawable.video_of_the_day_image));


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);


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
