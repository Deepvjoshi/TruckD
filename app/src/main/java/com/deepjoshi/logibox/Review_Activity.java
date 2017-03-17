package com.deepjoshi.logibox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Review_Activity extends AppCompatActivity {
Button btdj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_);
        btdj=(Button)findViewById(R.id.dj);
        btdj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Review_Activity.this, "Thanks For FeedBack", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Review_Activity.this,Setting_Activity.class);
                startActivity(intent);

            }
        });
    }
}
