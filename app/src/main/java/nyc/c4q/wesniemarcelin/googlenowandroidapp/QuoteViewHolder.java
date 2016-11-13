package nyc.c4q.wesniemarcelin.googlenowandroidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by wesniemarcelin on 11/6/16.
 */

public class QuoteViewHolder extends CardViewHolder<QuoteCardData> {
    Context context;
    ImageView quoteImage;
    TextView quoteTextView;
    TextView authorTextView;
    String quoteText;
    String authorText;

    public QuoteViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        context = parent.getContext();
        quoteImage = (ImageView) itemView.findViewById(R.id.quotes_image);
        quoteTextView = (TextView)itemView.findViewById(R.id.quote_view);
        authorTextView = (TextView)itemView.findViewById(R.id.author_view);
    }

    public static View inflateView(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.quote_item_view, parent, false);
    }

    //Binds the specific Youtube card data with the view
    public void bind(QuoteCardData quoteCardData) {
        authorText = quoteCardData.getAuthorView();
        authorTextView.setText(authorText);
        quoteText = quoteCardData.getQuoteView();
        quoteTextView.setText(quoteText);
        quoteImage.setImageResource(R.drawable.quotation_marks);

    }
}



