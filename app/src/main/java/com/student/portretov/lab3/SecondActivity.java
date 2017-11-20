package com.student.portretov.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by adminvp on 9/6/17.
 */

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button btnAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String login = intent.getStringExtra("login");
        String password = intent.getStringExtra("password");

        textView = (TextView) findViewById(R.id.textView);

        if(login.equals("admin") && password.equals("admin")){
            textView.setText("Привет администратор");
            btnAdmin = (Button) findViewById(R.id.btnAdmin);
            btnAdmin.setVisibility(View.VISIBLE);
            btnAdmin.setOnClickListener(this);
        } else {
            textView.setText("Привет юзер");
        }
        findViewById(R.id.btnUser).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button clickBtn = (Button) view;
        Intent intent = null;
        switch (clickBtn.getText().toString()){
            case "Для админа":
                intent = new Intent(this, AdminActivity.class);
                break;
            case "Для юзера":
                intent = new Intent(this, ThirdActivity.class);
                break;
        }
        startActivity(intent);
    }
}
