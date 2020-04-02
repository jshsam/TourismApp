package com.example.tourismappv20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;

public class TicketsActivity extends AppCompatActivity {

    private Button backButton;
    private TextView attractionNameTextView;
    private ImageView attractionImageView;
    private TextView feesTextView;
    private EditText quantityEditText;
    private Button buyButton;
    private TextView totalTextView;
    private double feeAmount;
    private String fees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);

        final NumberFormat formatter = NumberFormat.getCurrencyInstance();

        backButton = findViewById(R.id.back_button);
        attractionNameTextView = findViewById(R.id.name_textview);
        attractionImageView = findViewById(R.id.tickets_imageview);
        feesTextView = findViewById(R.id.fees_textview);
        quantityEditText = findViewById(R.id.quantity_edittext);
        buyButton = findViewById(R.id.buy_button);
        totalTextView = findViewById(R.id.total_textview);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(mainIntent);
            }
        });

        attractionNameTextView.setText(getIntent().getIntExtra("attractionName", 0));

        attractionImageView.setImageResource(getIntent().getIntExtra("picID", 0));

        feeAmount = getIntent().getDoubleExtra("fee", 0);

        fees = formatter.format(feeAmount);

        feesTextView.setText(fees);

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double total;
                int quantity;

                quantity = Integer.parseInt(quantityEditText.getText().toString().trim());

                total = quantity * feeAmount;

                totalTextView.setText(formatter.format(total));
            }
        });
    }
}
