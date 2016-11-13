package nyc.c4q.wesniemarcelin.googlenowandroidapp;

import nyc.c4q.wesniemarcelin.googlenowandroidapp.model.Quotes;

/**
 * Created by josevila on 11/12/16.
 */

public class QuoteCardData implements CardData {
    private String quoteView;
    private String authorView;
    private int quoteImage = R.drawable.quotation_marks;

    public QuoteCardData(Quotes quote) {
        quoteView = quote.getQuote();
        authorView = quote.getAuthor();

    }

    public void setAuthorView(String authorView) {
        this.authorView = authorView;
    }

    public int getQuoteImage() {
        return quoteImage;
    }

    public void setQuoteImage(int quoteImage) {
        this.quoteImage = quoteImage;
    }

    public String getQuoteView() {
        return quoteView;
    }

    public String getAuthorView() {
        return authorView;
    }

    public void setQuoteView(String quoteView) {
        this.quoteView = quoteView;
    }
}
