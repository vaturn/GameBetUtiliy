package com.example.gamebet.Activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.gamebet.R;

public class LobbyActivity extends AppCompatActivity {
    TextView tv_nickname;
    Button btn_join, btn_create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lobby);

        btn_create = findViewById(R.id.btn_create);
        btn_join = findViewById(R.id.btn_join);
        tv_nickname = findViewById(R.id.tv_nickname);

        String getData = getIntent().getStringExtra("user_name");
        if(getData == null || getData.isEmpty()) getData = "USER";

        tv_nickname.setText(getData);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_join.setOnClickListener(view -> {
            //참가
        });
        btn_create.setOnClickListener(view -> {
            //생성
        });
    }
}