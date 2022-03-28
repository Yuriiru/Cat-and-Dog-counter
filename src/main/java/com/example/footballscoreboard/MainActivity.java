package com.example.footballscoreboard;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

    public class MainActivity extends AppCompatActivity {
        Integer counterDog = 0;
        Integer counterCat = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        public void onClickBtnAddDog(View view) {
            counterDog++;
            TextView counterView = (TextView) findViewById(R.id.txtCounterDog);
            ViewGroup.LayoutParams params = counterView.getLayoutParams();
            counterView.setText(counterDog.toString());
        }
        public void onClickBtnAddCat(View view) {
            counterCat++;
            TextView counterView = (TextView) findViewById(R.id.txtCounterCat);
            ViewGroup.LayoutParams params = counterView.getLayoutParams();
            counterView.setText(counterCat.toString());
        }
        public void onRestoreInstanceState(Bundle savedInstanceState){
            super.onRestoreInstanceState(savedInstanceState);
            if (savedInstanceState != null && savedInstanceState.containsKey("CountDog")) {
                counterDog = savedInstanceState.getInt("CountDog");
            }
            if (savedInstanceState != null && savedInstanceState.containsKey("CountCat")) {
                counterCat = savedInstanceState.getInt("CountCat");
            }
        }
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            outState.putInt("CountDog", counterDog);
            outState.putInt("CountCat", counterCat);
        }
        public void resetUI() {
            ((TextView) findViewById(R.id.txtCounterDog)).setText(counterDog.toString());
            ((TextView) findViewById(R.id.txtCounterCat)).setText(counterCat.toString());
        }
        public void onResume() {
            super.onResume();
            resetUI();
        }
        public void onClickBtnObNull(View view) {
            counterDog = 0;
            counterCat = 0;
            TextView counterDogView = findViewById(R.id.txtCounterDog);
            TextView counterCatView = findViewById(R.id.txtCounterCat);
            counterDogView.setText(counterDog.toString());
            counterCatView.setText(counterCat.toString());
        }

    }