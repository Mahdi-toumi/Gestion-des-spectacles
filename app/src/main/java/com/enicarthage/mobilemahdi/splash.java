package com.enicarthage.mobilemahdi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class splash extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 3000;
    private final Handler handler = new Handler();
    private boolean isSkipped = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        Log.d("Splash", "Splash screen started"); // Debug log

        // Edge-to-edge handling
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Auto-redirect after delay
        handler.postDelayed(() -> {
            if (!isSkipped) {
                goToSignIn();
            }
        }, SPLASH_TIME_OUT);

        // Click to skip
        findViewById(android.R.id.content).setOnClickListener(v -> {
            Log.d("Splash", "Splash screen clicked"); // Debug log
            isSkipped = true;
            goToSignIn();
        });
    }

    private void goToSignIn() {
        try {
            Log.d("Splash", "Attempting to launch signin"); // Debug log
            Intent intent = new Intent(splash.this, signin.class);
            startActivity(intent);
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        } catch (Exception e) {
            Log.e("Splash", "Error launching signin: " + e.getMessage()); // Error log
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null); // Prevent leaks
    }
}