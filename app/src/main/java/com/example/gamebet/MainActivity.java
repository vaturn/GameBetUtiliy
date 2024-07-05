package com.example.gamebet;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.gamebet.object.Money;

public class MainActivity extends AppCompatActivity {
    TextView tv_money;
    Button btn_p, btn_m;
    Money user_account = new Money();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tv_money = findViewById(R.id.tv_money);
        btn_m = findViewById(R.id.btn_m);
        btn_p = findViewById(R.id.btn_p);

        btn_p.setOnClickListener(view -> {
            user_account.addMoney(10);

            refreshTv();
        });

        btn_m.setOnClickListener(view -> {
            user_account.withdrawMoney(10);

            refreshTv();
        });

        user_account.setMoney(0);

        refreshTv();
        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
    }

    public void refreshTv(){
        String s = Integer.toString(user_account.getMoney());
        tv_money.setText(s);
    }
}