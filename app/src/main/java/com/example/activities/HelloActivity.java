package com.example.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hello);
        InsetsUtil.applySystemBarInsets(findViewById(R.id.main));

        // Vrednost števca preberemo iz namena, s katerim je bila aktivnost zagnana.
        int count = getIntent().getIntExtra(MainActivity.EXTRA_COUNT, 0);
        TextView showCount = findViewById(R.id.show_count);
        showCount.setText(String.valueOf(count));
    }

    /** Gumb Go to activity 1: vrnitev na obstoječo MainActivity. */
    public void goToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        // CLEAR_TOP zapre aktivnosti nad MainActivity, SINGLE_TOP pa ponovno uporabi
        // obstoječi primerek, zato se števec ne ponastavi na 0.
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}
