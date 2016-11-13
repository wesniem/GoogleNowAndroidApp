package nyc.c4q.wesniemarcelin.googlenowandroidapp;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by wesniemarcelin on 11/4/16.
 */
//Adapts the data set to the activity; Looks at data and activity and populates the screen accordingly
public class MyAdapter extends RecyclerView.Adapter<CardViewHolder> {
    private ArrayList<CardData> cards;

    public final int TO_DO_LIST_POSITION = 1;
    public final int INSPIRE_CARD_POSITION = 2;
    public final int YOUTUBECARD_POSITION = 3;


    //List of "objects"
    public MyAdapter(ArrayList<CardData> cards) {
        this.cards = cards;
    }

    //Creates enough views to fill up the screen
    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == TO_DO_LIST_POSITION) {
            //Jonathan's viewholder code goes here (write your code above break statement)
        }
        if (viewType == INSPIRE_CARD_POSITION) {
            return new QuoteViewHolder(parent);
        }
        if (viewType == YOUTUBECARD_POSITION) {
            return new VineViewHolder(parent);
        }
        return null;
    }

    //Binds the data to the view
    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        final int viewType = getItemViewType(position);
        //noinspection unchecked
        //holder.bind(cards.get(position));
        if(viewType == YOUTUBECARD_POSITION) {
            ((VineViewHolder) holder).bind((VineCardData) cards.get(position));
        }
        if(viewType == INSPIRE_CARD_POSITION) {
            ((QuoteViewHolder) holder).bind((QuoteCardData) cards.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (cards.get(position) instanceof VineCardData) {
            return YOUTUBECARD_POSITION;
        }
// else if (cards.get(position) instanceof TODOList) {
//            return ITEM_TYPE_NORMAL;
//        }
        else if(cards.get(position) instanceof QuoteCardData){
            return INSPIRE_CARD_POSITION;
        }
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


}
