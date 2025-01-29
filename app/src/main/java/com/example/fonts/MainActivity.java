package com.example.fonts;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView sizeLabel;
    private TextView quoteText;
    private SeekBar fontSizeSeekBar;
    private Button changeTextButton;

    private final String[] quotes = {"Dzień dobry", "Good morning", "Buenos dias"};
    private int currentQuoteIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sizeLabel = findViewById(R.id.sizeLabel);
        quoteText = findViewById(R.id.quoteText);
        fontSizeSeekBar = findViewById(R.id.fontSizeSeekBar);
        changeTextButton = findViewById(R.id.changeTextButton);

        fontSizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sizeLabel.setText("Rozmiar: " + progress);
                quoteText.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        changeTextButton.setOnClickListener(v -> {
            currentQuoteIndex = (currentQuoteIndex + 1) % quotes.length;
            quoteText.setText(quotes[currentQuoteIndex]);
        });
    }
}
