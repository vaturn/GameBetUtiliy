package com.example.gamebet.Activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.gamebet.R;

public class WinActivity extends AppCompatActivity {

    Button btn_confirm;
    EditText et_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_win);

        btn_confirm = findViewById(R.id.confirmButton);

        btn_confirm.setOnClickListener(view -> {

        });
    }
}