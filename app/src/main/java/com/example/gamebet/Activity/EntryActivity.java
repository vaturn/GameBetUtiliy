package com.example.gamebet.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.gamebet.Name;
import com.example.gamebet.R;

public class EntryActivity extends AppCompatActivity {
    EditText et_nickname;
    Button btn_chk_entry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_entry);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        et_nickname = findViewById(R.id.et_nickname);
        btn_chk_entry = findViewById(R.id.btn_chk_entry);

        btn_chk_entry.setOnClickListener(view -> {
            Intent intent = new Intent(EntryActivity.this, LobbyActivity.class);
            intent.putExtra("user_name", et_nickname.getText().toString());
            startActivity(intent);
        });
    }
}