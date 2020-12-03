package com.example.exam_application_sgalindo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.fragment.app.Fragment;

public class FragmentThird extends Fragment {
    private Button button;
    private ButtonClicked listener;
    private SeekBar red, blue, green;

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View root = inflater.inflate(R.layout.fragment_third, parent, false);
        // Get
        red = root.findViewById(R.id.third_seekBar_red);
        green = root.findViewById(R.id.third_seekBar_green);
        blue = root.findViewById(R.id.third_seekBar_blue);
        button = root.findViewById(R.id.third_button_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    listener.sendColor(getColor());
                }
            }
        });
        return root;
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }

    private int getColor(){
        int myColor = Color.rgb(red.getProgress(), blue.getProgress(), green.getProgress());
        return myColor;
    }

    public void setButtonListener(ButtonClicked listener) {
        this.listener = listener;
    }

    public interface ButtonClicked{
        public void sendColor(int color);
    }
}
