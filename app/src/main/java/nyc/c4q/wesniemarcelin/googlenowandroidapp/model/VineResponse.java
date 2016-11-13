package nyc.c4q.wesniemarcelin.googlenowandroidapp.model;

/**
 * Created by wesniemarcelin on 11/8/16.
 */

public class VineResponse {

    public String code;
    public Data data;
    public boolean success;
    public String error;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
