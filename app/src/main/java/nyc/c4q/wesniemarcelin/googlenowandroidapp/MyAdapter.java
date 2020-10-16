package nyc.c4q.wesniemarcelin.googlenowandroidapp;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.wesniemarcelin.googlenowandroidapp.TodoList.TodoListCarddata;
import nyc.c4q.wesniemarcelin.googlenowandroidapp.TodoList.TodoListViewHolder;

/**
 * Created by wesniemarcelin on 11/4/16.
 */
//Adapts the data set to the activity; Looks at data and activity and populates the screen accordingly
public class MyAdapter extends RecyclerView.Adapter<CardViewHolder> {
    private ArrayList<CardData> cards;

    public final int TO_DO_LIST_POSITION = 1;
    public final int INSPIRE_CARD_POSITION = 2;
    public final int VINECARD_POSITION = 0;


    //List of "cards"
    public MyAdapter(ArrayList<CardData> cards) {
        this.cards = cards;
    }

    //Creates enough views to fill up the screen
    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == TO_DO_LIST_POSITION) {
            //Jonathan's viewholder code goes here (write your code above break statement)
            return new TodoListViewHolder(parent);
        }
        if (viewType == INSPIRE_CARD_POSITION) {
            return new QuoteViewHolder(parent);
        }
        if (viewType == VINECARD_POSITION) {
            return new VineViewHolder(parent);
        }
        return null;
    }

    //Binds the data to the view
    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        final int viewType = getItemViewType(position % cards.size());
        //noinspection unchecked
        //holder.bind(cards.get(position));

        if (viewType == TO_DO_LIST_POSITION){
            ((TodoListViewHolder) holder).bind((TodoListCarddata) cards.get(position % cards.size()));
        }
        if(viewType == VINECARD_POSITION) {
            ((VineViewHolder) holder).bind((VineCardData) cards.get(position % cards.size()));
        }
        if(viewType == INSPIRE_CARD_POSITION) {
            ((QuoteViewHolder) holder).bind((QuoteCardData) cards.get(position % cards.size()));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if ( (position % cards.size() == VINECARD_POSITION)) {
            return VINECARD_POSITION;
        }
        else if ((position % cards.size() == TO_DO_LIST_POSITION)) {
            return TO_DO_LIST_POSITION;
        }
        else if((position % cards.size() == INSPIRE_CARD_POSITION)){
            return INSPIRE_CARD_POSITION;
        }
        else{
            return 0;
        }
    }

    //Counts how many objects that will be in the recycler view
    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    // Clean all elements of the recycler
    public void clear() {
        cards.clear();
        notifyDataSetChanged();
    }
    // Add a list of items
    public void addAll(List<CardData> list) {
        cards.addAll(list);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        cards.remove(position);
        notifyItemRemoved(position);
    }


}
