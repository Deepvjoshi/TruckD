package com.deepjoshi.logibox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Track extends AppCompatActivity {
ImageButton imgbtn;
    Button nextbtn;
    EditText EntrNom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track);
        nextbtn=(Button)findViewById(R.id.Track_btn);
        EntrNom=(EditText)findViewById(R.id.Track_edt_orderNum);

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String Edt=EntrNom.getText().toString();

                if (Edt.isEmpty()){
                    Toast.makeText(Track.this, "plz Enter youre Number", Toast.LENGTH_SHORT).show();
                }
else {
                    Intent i = new Intent(Track.this, Track_Activity.class);
                    startActivity(i);
                }
            }
        });
    }
}
