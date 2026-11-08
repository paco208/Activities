package com.example.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    private int mCount;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);

        View root = findViewById(R.id.main);
        InsetsUtil.applySystemBarInsets(root);

        mCount = getIntent().getIntExtra(MainActivity.EXTRA_COUNT, 0);
        TextView showCount = findViewById(R.id.show_count);
        showCount.setText(String.valueOf(mCount));

        // Potezna navigacija: poteg v levo -> prva aktivnost, poteg v desno -> druga aktivnost.
        root.setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeLeft() {
                goToMain(null);
            }

            @Override
            public void onSwipeRight() {
                goToHello(null);
            }
        });
    }

    /** Gumb Go to activity 1 (ali poteg v levo). */
    public void goToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    /** Gumb Go to activity 2 (ali poteg v desno): števec posredujemo naprej. */
    public void goToHello(View view) {
        Intent intent = new Intent(this, HelloActivity.class);
        intent.putExtra(MainActivity.EXTRA_COUNT, mCount);
        startActivity(intent);
    }
}
