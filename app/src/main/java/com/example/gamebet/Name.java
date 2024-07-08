package com.example.gamebet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gamebet.Activity.MainActivity;

public class Name extends AppCompatActivity {
    Button btn;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_name);

        et = findViewById(R.id.et_name);
        btn = findViewById(R.id.btn_next);
        btn.setOnClickListener(view -> {
            Intent intent = new Intent(Name.this, MainActivity.class);
            intent.putExtra("user_name", et.getText().toString());
            startActivity(intent);
        });

    }
}