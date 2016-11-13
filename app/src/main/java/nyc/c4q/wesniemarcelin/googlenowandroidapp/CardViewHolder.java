package nyc.c4q.wesniemarcelin.googlenowandroidapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by josevila on 11/12/16.
 */

public abstract class CardViewHolder<T extends CardData> extends RecyclerView.ViewHolder {
    public CardViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(T cardData);
}
