package nyc.c4q.wesniemarcelin.googlenowandroidapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * Created by wesniemarcelin on 11/6/16.
 */

public class YouTubeViewHolder extends RecyclerView.ViewHolder {
    TextView text;
    ImageView image;
    VideoView video;
    public YouTubeViewHolder(View itemView) {

        super(itemView);

        image = (ImageView) itemView.findViewById(R.id.image_view_vid_of_the_day);
        video = (VideoView) itemView.findViewById(R.id.video_view);
    }

    //Binds the specific Youtube card data with the view
    public void bind(YouTubeCardData youTubeCardData) {
        image.setImageResource(R.drawable.video_of_the_day_image);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Instantiate Retrofit
            }
        });

    }

//    TextView text;
//    ImageView image;
//    VideoView video;
//
//    public YouTubeCardViewHolder(View itemView) {
//        super(itemView);
//
//        image = (ImageView) itemView.findViewById(R.id.image_view_vid_of_the_day);
//        video = (VideoView) itemView.findViewById(R.id.video_view);
//    }
//    //Binds the specific Youtube card data with the view
//    public void bind(YouTubeCardData youTubeCardData) {
//        image.setImageResource(R.drawable.video_of_the_day_image);
//        video.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Instantiate Retrofit
//            }
//        });
//
//    }
}


