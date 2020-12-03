package com.example.exam_application_sgalindo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FragmentSecond extends Fragment {
    private TextView textView;

    public FragmentSecond(){

    }

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_second, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        textView = view.findViewById(R.id.second_textView_1);
    }

    public void updateText(String text, int size){
        textView.setText(text);
        updateSize(size);
    }

    public void updateSize(int size){
        textView.setTextSize(size);
    }

    public void updateColorText (int color){
        textView.setTextColor(color);
    }


}
