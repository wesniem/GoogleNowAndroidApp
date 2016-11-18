package nyc.c4q.wesniemarcelin.googlenowandroidapp;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

/**
 * Created by wesniemarcelin on 11/6/16.
 */

public class VineViewHolder extends CardViewHolder<VineCardData> {
    TextView text;
    ImageView avatarView;
    String avatarUrl;
    ImageView image;
    VideoView video;
    String url;
    Context context;
    TextView username;
    String user_name1;
    String userId;


    public VineViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        context = parent.getContext();
        image = (ImageView) itemView.findViewById(R.id.image_view_vid_of_the_day);
        video = (VideoView) itemView.findViewById(R.id.video_view);
        avatarView = (ImageView) itemView.findViewById(R.id.vine_avatar);
        username = (TextView) itemView.findViewById(R.id.username_imageview);
    }

    public static View inflateView(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.vine_item_view, parent, false);
    }

    //Binds the specific Youtube card data with the view
    public void bind(VineCardData vineCardData) {
                //gets and sets the user's profile picture
        avatarUrl = vineCardData.getAvatarUrl();
        Picasso.with(context).load(avatarUrl).into(avatarView);


        //gets and sets username to the viewholder
        user_name1 = vineCardData.getUsername();
        username.setText(user_name1);
        goToUserPage();
        url = vineCardData.getUrl();
        image.setImageResource(R.drawable.video_of_the_day_image);
        userId = vineCardData.getUserID();
        if (url != null) {
            video.setVideoURI(Uri.parse(url));
            video.setMediaController(new MediaController(context));
            video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    video.start();
                    mediaPlayer.setLooping(true);
                }
            });
        }
    }

    public void goToUserPage() {
        avatarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("http://vine.co/u/"+userId);

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }
        });
    }
}



