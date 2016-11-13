package nyc.c4q.wesniemarcelin.googlenowandroidapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by josevila on 11/12/16.
 */

public class Quotes {
    @SerializedName("author")
    @Expose
    public String author;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("quote")
    @Expose
    public String quote;
    @SerializedName("permalink")
    @Expose
    public String permalink;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }
}
