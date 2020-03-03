package com.example.postresfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private ImageView image;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        image = findViewById(R.id.image);
        text = findViewById(R.id.text);
        Bundle bundle = getIntent().getExtras();
        image.setImageResource(bundle.getInt("imagen"));
        text.setText(bundle.getString("info"));
    }
}
