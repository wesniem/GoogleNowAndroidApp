package nyc.c4q.wesniemarcelin.googlenowandroidapp;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;

/**
 * Created by wesniemarcelin on 11/4/16.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder>{
    private ArrayList<YouTubeCards> cards;

    public MyAdapter(ArrayList<YouTubeCards> cards) {
        this.cards = cards;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        myViewHolder vidCard = new myViewHolder(v);
        return vidCard;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
holder.image.setImageResource(R.drawable.video_of_the_day_image);
        holder.video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView text;
        ImageView image;
        VideoView video;

        public myViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.image_view_vid_of_the_day);
            video = (VideoView) itemView.findViewById(R.id.video_view);
        }
    }

}
