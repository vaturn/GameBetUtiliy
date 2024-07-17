package com.example.gamebet.Activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.gamebet.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LobbyActivity extends AppCompatActivity {
    TextView tv_nickname;
    EditText et_roomcode;
    Button btn_join, btn_create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lobby);

        btn_create = findViewById(R.id.btn_create);
        btn_join = findViewById(R.id.btn_join);
        tv_nickname = findViewById(R.id.tv_nickname);
        et_roomcode = findViewById(R.id.et_roomcode);

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
            String roomcode = et_roomcode.getText().toString();
            joinRoom(roomcode);
        });
        btn_create.setOnClickListener(view -> {
            //생성
            String roomcode = createcode();


        });
    }

    private String createcode(){
        Date mDate;
        SimpleDateFormat mFormat = new SimpleDateFormat("yyyyMMddhhmm");

        mDate = new Date(System.currentTimeMillis());
        String date = mFormat.format(mDate);

        StringBuilder result = new StringBuilder();
        for (char c : date.toCharArray()) {
            // 각 문자에 대해 'A' + (c - '0') 로 변환
            char newChar = (char) ('A' + (c - '0'));
            result.append(newChar);
        }

        return result.toString();
    }

    private void joinRoom(String roomcode){

    }
}