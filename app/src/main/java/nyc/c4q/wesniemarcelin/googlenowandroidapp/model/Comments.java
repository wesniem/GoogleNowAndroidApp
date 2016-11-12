package nyc.c4q.wesniemarcelin.googlenowandroidapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wesniemarcelin on 11/8/16.
 */

public class Comments {
    public int count;
    public List<Object> records = new ArrayList<Object>();
    public Object nextPage;
    public Object previousPage;
    public int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Object> getRecords() {
        return records;
    }

    public void setRecords(List<Object> records) {
        this.records = records;
    }

    public Object getNextPage() {
        return nextPage;
    }

    public void setNextPage(Object nextPage) {
        this.nextPage = nextPage;
    }

    public Object getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(Object previousPage) {
        this.previousPage = previousPage;
    }
}
