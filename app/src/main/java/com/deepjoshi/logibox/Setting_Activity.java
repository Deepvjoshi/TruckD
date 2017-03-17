package com.deepjoshi.logibox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Setting_Activity extends AppCompatActivity {
    private Button btn_about;
    private Button btn_logout;
    private Button btn_feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_);
        btn_logout=(Button)findViewById(R.id.logout_btn);
        btn_feedback=(Button)findViewById(R.id.feedback_btn);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSharedPreferences("testpref",MODE_PRIVATE).edit().clear().apply();
                Intent intent = new Intent(Setting_Activity.this,Log_in.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });
        btn_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting_Activity.this,Review_Activity.class);
                startActivity(intent);

            }
        });
    }
}