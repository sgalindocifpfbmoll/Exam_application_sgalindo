package com.example.exam_application_sgalindo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity{
    FragmentFirst fragmentA;
    FragmentSecond fragmentB;
    FragmentThird fragmentC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        fragmentA = (FragmentFirst) manager.findFragmentById(R.id.fragment_first);
        fragmentB = (FragmentSecond) manager.findFragmentById(R.id.fragment_second);
        fragmentC = (FragmentThird) manager.findFragmentById(R.id.fragment_third);

        fragmentA.setButtonListener(new FragmentFirst.ButtonClicked() {
            @Override
            public void sendText(String text, int size) {
                fragmentB.updateText(text, size);
            }
        });

        fragmentA.setBarListener(new FragmentFirst.SeekBarMoved() {
            @Override
            public void sendSize(int size) {
                fragmentB.updateSize(size);
            }
        });

        fragmentC.setButtonListener(new FragmentThird.ButtonClicked() {
            @Override
            public void sendColor(int color) {
                fragmentB.updateColorText(color);
            }
        });
    }
}