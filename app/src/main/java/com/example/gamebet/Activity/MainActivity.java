package com.example.gamebet.Activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gamebet.R;
import com.example.gamebet.object.Money;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView tv_money;
    Button btn_p, btn_m;
    Money user_account;
    EditText et_mame;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        String getData = getIntent().getStringExtra("user_name");


        if(getData == null || getData.isEmpty()) getData = "USER";

        Log.e("Main", getData);

        mDatabase = FirebaseDatabase.getInstance().getReference("Money").child(getData);
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                user_account = snapshot.getValue(Money.class);
                if(user_account == null){ // 존재하지 않는 경우
                    user_account = new Money(0);
                    refreshDB();
                }

                refreshTv(Integer.toString(user_account.getMoney()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        tv_money = findViewById(R.id.tv_money);
        btn_m = findViewById(R.id.btn_m);
        btn_p = findViewById(R.id.btn_p);

        btn_p.setOnClickListener(view -> {
            user_account.addMoney(10);
            refreshDB();
        });

        btn_m.setOnClickListener(view -> {
            user_account.withdrawMoney(10);
            refreshDB();
        });


        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
    }

    public void refreshDB(){
        mDatabase.setValue(user_account);
    }
    public void refreshTv(String s){
        tv_money.setText(s);
    }
}