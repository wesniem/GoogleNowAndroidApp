package nyc.c4q.wesniemarcelin.googlenowandroidapp.TodoList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import nyc.c4q.wesniemarcelin.googlenowandroidapp.CardViewHolder;
import nyc.c4q.wesniemarcelin.googlenowandroidapp.MainActivity;
import nyc.c4q.wesniemarcelin.googlenowandroidapp.R;

/**
 * Created by jonathancolon on 11/13/16.
 */

public class TodoListViewHolder extends CardViewHolder<TodoListCarddata> {
    Context context;
    private EditText notepad;
    private Button saveButton;

    public TodoListViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        context = parent.getContext();
        notepad = (EditText) itemView.findViewById(R.id.edit_text_notepad);
        saveButton = (Button) itemView.findViewById(R.id.save_button);
    }



    public static View inflateView(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.notepad_item_view, parent, false);
    }

    @Override
    public void bind(TodoListCarddata cardData) {
        notepad.setText(MainActivity.sharedpreferences.getString(MainActivity.NOTE,"Enter notes here"));
    }
}