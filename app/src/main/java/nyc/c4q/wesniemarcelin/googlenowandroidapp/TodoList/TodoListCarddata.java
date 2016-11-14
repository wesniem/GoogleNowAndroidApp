package nyc.c4q.wesniemarcelin.googlenowandroidapp.TodoList;

import android.app.AlertDialog;
import android.widget.Button;
import android.widget.EditText;

import nyc.c4q.wesniemarcelin.googlenowandroidapp.CardData;

/**
 * Created by jonathancolon on 11/13/16.
 */
public class TodoListCarddata implements CardData {
    private Button saveButton;

    public AlertDialog getConfirmDialogObject() {
        return confirmDialogObject;
    }

    public void setConfirmDialogObject(AlertDialog confirmDialogObject) {
        this.confirmDialogObject = confirmDialogObject;
    }

    public EditText getNotepad() {
        return notepad;
    }

    public void setNotepad(EditText notepad) {
        this.notepad = notepad;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(Button saveButton) {
        this.saveButton = saveButton;
    }

    private EditText notepad;
    private AlertDialog confirmDialogObject;

    public TodoListCarddata() {

    }


}
