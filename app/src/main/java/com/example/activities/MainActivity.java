package com.example.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /** Ključ, pod katerim se vrednost števca prenaša med aktivnostmi. */
    public static final String EXTRA_COUNT = "com.example.activities.extra.COUNT";

    private static final String STATE_COUNT = "state_count";

    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        InsetsUtil.setupToolbarAndInsets(this);

        mShowCount = findViewById(R.id.show_count);

        // Ob obratu zaslona se aktivnost ustvari na novo, zato vrednost obnovimo.
        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt(STATE_COUNT, 0);
        }
        updateCount();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_COUNT, mCount);
    }

    /** Gumb Count: poveča števec za 1. */
    public void countUp(View view) {
        mCount++;
        updateCount();
    }

    /** Gumb Go to activity 2: zažene HelloActivity in ji preda števec. */
    public void goToHello(View view) {
        Intent intent = new Intent(this, HelloActivity.class);
        intent.putExtra(EXTRA_COUNT, mCount);
        startActivity(intent);
    }

    /** Gumb Go to activity 3: zažene ThirdActivity in ji preda števec. */
    public void goToThird(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra(EXTRA_COUNT, mCount);
        startActivity(intent);
    }

    private void updateCount() {
        mShowCount.setText(String.valueOf(mCount));
    }
}
