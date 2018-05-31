package il.co.beeart.cerenresepies;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewTopicDialog extends DialogFragment {

    EditText txtTopicName;
    Button btnDone;
    RecipesTopics newTopic;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_new_topic, container);
        txtTopicName = view.findViewById(R.id.txtTopicName);
        btnDone = view.findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDone(v);
            }
        });
        txtTopicName.requestFocus();
        txtTopicName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    btnDone(null);
                    return true;
                }
                return false;
            }
        });
        return view;
    }
    public void btnDone(View view){

        String topicName = txtTopicName.getText().toString();
        newTopic = new RecipesTopics(topicName);
        dismiss();
    }

}
