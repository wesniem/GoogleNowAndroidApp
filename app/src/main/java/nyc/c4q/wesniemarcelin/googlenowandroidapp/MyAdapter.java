package nyc.c4q.wesniemarcelin.googlenowandroidapp;


import android.support.v7.widget.RecyclerView;
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
//Adapts the data set to the activity; Looks at data and activity and populates the screen accordingly
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Object> cards;

    public final int TO_DO_LIST_POSITION = 1;
    public final int INSPIRE_CARD_POSITION = 2;
    public final int YOUTUBECARD_POSITION = 3;


    //List of "objects"
    public MyAdapter(ArrayList<Object> cards) {
        this.cards = cards;
    }

    //Creates enough views to fill up the screen
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == TO_DO_LIST_POSITION) {
            //Jonathan's viewholder code goes here (write your code above break statement)
        }
        if (viewType == INSPIRE_CARD_POSITION) {
            //Jose's code goes here (write your code above break statement)
        }
        if (viewType == YOUTUBECARD_POSITION) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.youtube_item_view, parent, false);
            YouTubeCardViewHolder vidCard = new YouTubeCardViewHolder(view);
            return vidCard;
        }
        return null;
    }

    //Binds the data to the view
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final int viewType = getItemViewType(position);
        if(viewType == YOUTUBECARD_POSITION) {
            ((YouTubeCardViewHolder) holder).bind((YouTubeCardData) cards.get(position));
        }
        //Write code for your cards similar to what I have above

    }

    @Override
    public int getItemViewType(int position) {
        if (cards.get(position) instanceof YouTubeCardData) {
            return YOUTUBECARD_POSITION;
        }
// else if (cards.get(position) instanceof TODOList) {
//            return ITEM_TYPE_NORMAL;
//        }
        else{
            return 0;
        }
    }

    //Counts how many objects that will be in the recycler view
    @Override
    public int getItemCount() {
        return cards.size();
    }

    //Describes how viewholder should look
    public class YouTubeCardViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        ImageView image;
        VideoView video;

        public YouTubeCardViewHolder(View itemView) {
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
    }

}
