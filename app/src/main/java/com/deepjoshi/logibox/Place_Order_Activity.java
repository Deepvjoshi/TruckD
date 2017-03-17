package com.deepjoshi.logibox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Place_Order_Activity extends AppCompatActivity {
    private Spinner spinner_packaging;
    private Spinner spinner_wrap;
    private Spinner spinner_mattress;
    private Spinner spinner_sofa;
    private Spinner spinner_chair;
    private Spinner spinner_zip_ties;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place__order_);


        spinner_packaging=(Spinner)findViewById(R.id.data_packaging);
        ArrayAdapter<CharSequence> adapter7= ArrayAdapter.createFromResource(this,R.array.select_packaging, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_packaging.setAdapter(adapter7);

        spinner_wrap=(Spinner)findViewById(R.id.data_wrap);
        ArrayAdapter<CharSequence> adapter8= ArrayAdapter.createFromResource(this,R.array.select_wrap, android.R.layout.simple_spinner_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_wrap.setAdapter(adapter8);

        spinner_mattress=(Spinner)findViewById(R.id.data_mattress);
        ArrayAdapter<CharSequence> adapter9= ArrayAdapter.createFromResource(this,R.array.select_mattress, android.R.layout.simple_spinner_item);
        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_mattress.setAdapter(adapter9);

        spinner_sofa=(Spinner)findViewById(R.id.data_sofa);
        ArrayAdapter<CharSequence> adapter10= ArrayAdapter.createFromResource(this,R.array.select_sofa, android.R.layout.simple_spinner_item);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_sofa.setAdapter(adapter10);

        spinner_chair=(Spinner)findViewById(R.id.data_chair);
        ArrayAdapter<CharSequence> adapter11= ArrayAdapter.createFromResource(this,R.array.select_chair, android.R.layout.simple_spinner_item);
        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_chair.setAdapter(adapter11);

        spinner_zip_ties=(Spinner)findViewById(R.id.data_zip_ties);
        ArrayAdapter<CharSequence> adapter12= ArrayAdapter.createFromResource(this,R.array.select_zip_ties, android.R.layout.simple_spinner_item);
        adapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_zip_ties.setAdapter(adapter12);






    }
}
