package com.example.exam_application_sgalindo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.fragment.app.Fragment;

public class FragmentFirst extends Fragment {
    private Context context;
    private EditText editText;
    private SeekBar seekBar;
    private Button button;
    private ButtonClicked listener;
    private SeekBarMoved listenerBar;

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View root = inflater.inflate(R.layout.fragment_first, parent, false);
        // Elements
        editText = root.findViewById(R.id.first_editText_1);
        seekBar = root.findViewById(R.id.third_seekBar_red);
        button = root.findViewById(R.id.first_button_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    listener.sendText(getText(), getTextSize());
                }
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                    listenerBar.sendSize(seekBar.getProgress());
            }
        });
        // Return the view
        return root;
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here

    }

    public String getText(){
        return editText. getText().toString();
    }

    public int getTextSize(){
        return seekBar.getProgress();
    }

    public void setButtonListener(ButtonClicked listener) {
        this.listener = listener;
    }

    public void setBarListener(SeekBarMoved listener) {
        this.listenerBar = listener;
    }

    public interface ButtonClicked{
        public void sendText(String text, int size);
    }

    public interface SeekBarMoved{
        public void sendSize(int size);
    }
}
