package com.example.mobileassignement1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText principalAmountEditText;
    private EditText interestRateEditText;
    private EditText loanTermEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principalAmountEditText = findViewById(R.id.principalAmountEditText);
        interestRateEditText = findViewById(R.id.interestRateEditText);
        loanTermEditText = findViewById(R.id.loanTermEditText);
        resultTextView = findViewById(R.id.resultTextView);
    }

    public void calculateMonthlyPayment(View view) {
        // Get user input values
        double principal = Double.parseDouble(principalAmountEditText.getText().toString());
        double interestRate = Double.parseDouble(interestRateEditText.getText().toString()) / 100.0;
        int loanTerm = Integer.parseInt(loanTermEditText.getText().toString());

        // Calculate monthly payment
        double monthlyInterestRate = interestRate / 12;
        int numberOfPayments = loanTerm * 12;
        double monthlyPayment = (principal * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

        // Display the result
        resultTextView.setText("Monthly Payment: $" + String.format("%.2f", monthlyPayment));
    }
}
