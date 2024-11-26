package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private TextView resultTextView;
    private Button showTextButton;
    private Random random = new Random();
    private String[] responses = {
            "Great choice!",
            "Interesting input!",
            "I see what you did there.",
            "That's a unique thought!",
            "Very creative!",
            "I love that perspective!",
            "You're onto something!",
            "Fascinating!",
            "Good point!",
            "That's quite insightful!"
    };
    private int colorIndex = 0;
    private int[] colors = {Color.BLACK, Color.RED, Color.BLUE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = findViewById(R.id.userInput);
        resultTextView = findViewById(R.id.resultTextView);
        showTextButton = findViewById(R.id.showTextButton);
        Button changeColorButton = findViewById(R.id.changeColorButton);

        showTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomIndex = random.nextInt(responses.length);
                String response = responses[randomIndex];
                String userText = userInput.getText().toString();
                resultTextView.setText(response + " " + userText);
            }
        });

        changeColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTextView.setTextColor(colors[colorIndex]);
                colorIndex = (colorIndex + 1) % colors.length;
            }
        });
    }
}
