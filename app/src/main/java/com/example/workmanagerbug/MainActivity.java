package com.example.workmanagerbug;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "WORKMANAGER_BUG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            Log.i(TAG, "before schedule");
            Reporter.schedule();
            Log.i(TAG, "after schedule");

            System.exit(1);
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            throw new RuntimeException("App crashed");
        });

    }
}
