package com.example.activities;

import android.view.View;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Doda odmik za sistemske vrstice (levo, desno, spodaj), da vsebina ni pod
 * navigacijsko vrstico. Zgornji del že pokrije action bar, zato zgoraj
 * odmika ne dodajamo. Prvotni padding iz XML se ohrani.
 */
public final class InsetsUtil {

    private InsetsUtil() {
    }

    public static void applySystemBarInsets(View root) {
        final int left = root.getPaddingLeft();
        final int top = root.getPaddingTop();
        final int right = root.getPaddingRight();
        final int bottom = root.getPaddingBottom();

        ViewCompat.setOnApplyWindowInsetsListener(root, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(
                    left + systemBars.left,
                    top,
                    right + systemBars.right,
                    bottom + systemBars.bottom);
            return insets;
        });
    }
}
