package com.example.tourismappv20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView nameTextView;
    private TextView detailsTextView;
    private ImageView attractionImageView;
    private Button descriptionButton;
    private Button feesButton;
    private Button hoursButton;
    private Button previousButton;
    private Button nextButton;
    private Button ticketsButton;
    private int index;
    private Attraction[] attractions;
    private double fees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = findViewById(R.id.name_textview);
        detailsTextView = findViewById(R.id.details_textview);
        attractionImageView = findViewById(R.id.attraction_imageview);
        descriptionButton = findViewById(R.id.description_button);
        feesButton = findViewById(R.id.fees_button);
        hoursButton = findViewById(R.id.hours_button);
        previousButton = findViewById(R.id.previous_button);
        nextButton = findViewById(R.id.next_button);
        ticketsButton = findViewById(R.id.tickets_button);

        attractions = new Attraction[3];
        attractions[0] = new Attraction(R.string.attraction_zoo, R.string.description_zoo,
                R.string.fees_zoo, R.string.hours_zoo,
                R.drawable.louisville_zoo);
        attractions[1] = new Attraction(R.string.attraction_pacsci, R.string.description_pacsci,
                R.string.fees_pacsci, R.string.hours_pacsci,
                R.drawable.pacific_sci_center);
        attractions[2] = new Attraction(R.string.attraction_cedarpoint,
                R.string.description_cedarpoint, R.string.fees_cedarpoint,
                R.string.hours_cedarpoint, R.drawable.cedar_point);


        index = 0;

        descriptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailsTextView.setText(attractions[index].getDescription());
            }
        });

        feesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailsTextView.setText(attractions[index].getFees());
            }
        });

        hoursButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailsTextView.setText(attractions[index].getHours());
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index--;
                index = (index + attractions.length) % attractions.length;
                nameTextView.setText(attractions[index].getAttractionName());
                detailsTextView.setText("");
                attractionImageView.setImageResource(attractions[index].getImage());
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                index %= attractions.length;
                nameTextView.setText(attractions[index].getAttractionName());
                detailsTextView.setText("");
                attractionImageView.setImageResource(attractions[index].getImage());
            }
        });

        ticketsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ticketsIntent = new Intent(MainActivity.this,
                                                    TicketsActivity.class);

                if (index == 0) {
                    fees = Attraction.ZOO_FEE;
                }
                else if (index == 1) {
                    fees = Attraction.PACSCI_FEE;
                }
                else if (index == 2) {
                    fees = Attraction.CEDAR_POINT_FEE;
                }

                ticketsIntent.putExtra("attractionName", attractions[index].getAttractionName());
                ticketsIntent.putExtra("picID", attractions[index].getImage());
                ticketsIntent.putExtra("fee", fees);

                startActivity(ticketsIntent);
            }
        });
    }
}

