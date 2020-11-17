package com.example.ducksflyagain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MainActivityPresenter mainActivityPresenter = new MainActivityPresenter(this);

        Button quackButton = (Button) findViewById(R.id.quackDuckButton);

        quackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityPresenter.allowQuacking();
            }
        });
    }

    @Override
    public void quacking(boolean silent) {
        final TextView duckState = findViewById(R.id.duckStateTextView);

        duckState.setText("Duck is quacking: " + silent);
    }
}