package nyc.c4q.wesniemarcelin.googlenowandroidapp;

/**
 * Created by wesniemarcelin on 11/6/16.
 */

public class GenericCardTypes<T> {
    private T t;

    public void set(T t){
        this.t = t;
    }
    public T get(){
        return t;
    }

}
