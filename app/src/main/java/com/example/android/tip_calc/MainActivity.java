package com.example.android.tip_calc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tipTotalTextView;
    TextView totalTextView;
    EditText billTotalEditText;
    Button tenPercentButton;
    Button fifteenPercentButton;
    Button twentyPercentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tipTotalTextView = (TextView) findViewById(R.id.tipTotalTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        billTotalEditText = (EditText) findViewById(R.id.billTotalEditText);
        tenPercentButton = (Button) findViewById(R.id.tenButton);
        fifteenPercentButton = (Button) findViewById(R.id.fifteenPercentButton);
        twentyPercentButton = (Button) findViewById(R.id.twentyPercentButton);

        tenPercentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcTheTip(0.1);
            }
        });

        fifteenPercentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcTheTip(0.15);
            }
        });

        twentyPercentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcTheTip(0.2);
            }
        });
    }

    void calcTheTip(Double tipPercentage) {

        double billTotal = Double.parseDouble(billTotalEditText.getText().toString());

        // Determine the Tip
        double tipTotal = billTotal * tipPercentage;

        // Display the Tip
        tipTotalTextView.setText("Tip - €" + String.format("%.2f", tipTotal));

        // Determine the Total
        double total = billTotal + tipTotal;

        // Display the Total
        totalTextView.setText("Total - €" + String.format("%.2f", total));

    }
}