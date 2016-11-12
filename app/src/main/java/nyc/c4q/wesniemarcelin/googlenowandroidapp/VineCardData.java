package nyc.c4q.wesniemarcelin.googlenowandroidapp;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by wesniemarcelin on 11/4/16.
 */

public class VineCardData {
    private int vidPic;
    private TextView text;
    private String url;
    private String avatarUrl;
    private String username;
    private int userID;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public VineCardData(int vidPic) {
        this.vidPic = vidPic;

    }

    public int getVidPic() {
        return vidPic;
    }


    public String getUrl() {
        return url;
    }
}
