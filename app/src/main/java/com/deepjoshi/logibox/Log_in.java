package com.deepjoshi.logibox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.deepjoshi.logibox.AsyncTasks.AsyncResponse;
import com.deepjoshi.logibox.AsyncTasks.WebserviceCall;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.deepjoshi.logibox.Helper.Utils;
import  com.deepjoshi.logibox.Model.LogInModel;
import com.deepjoshi.logibox.Model.Log_InModel;
import com.google.gson.Gson;

public class Log_in extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        final EditText emailId=(EditText)findViewById(R.id.login_edittext_eid);
        final EditText passWord=(EditText)findViewById(R.id.login_edittext_password);
        Button btFg=(Button)findViewById(R.id.login_button_frgtPasswrd);
        Button bt=(Button)findViewById(R.id.login_button_signup);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Log_in.this,Sign_up.class);
                startActivity(i);
            }


        });
        btFg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i =new Intent(Log_in.this,ForgotPasswordActivity.class);
                startActivity(i);
            }
        });
        Button bt2=(Button)findViewById(R.id.login_button_login);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stremail = emailId.getText().toString();
                String strpwd = passWord.getText().toString();


                if (stremail.isEmpty())

                {
                    Toast.makeText(Log_in.this, "Email cannot be empty!", Toast.LENGTH_SHORT).show();

                } else if (strpwd.isEmpty())

                {
                    Toast.makeText(Log_in.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();

                } else

                {



                    String[]keys=new String[]{"mode","username","psw"};
                    String[]values=new String[]{"login",stremail,strpwd};
                    String jsonRequest= Utils.createJsonRequest(keys,values);

                    String URL = "http://vnurture.in/logistic/webservice.php";
                    new WebserviceCall(Log_in.this, URL, jsonRequest, "Logging in", true, new AsyncResponse() {
                        @Override
                        public void onCallback(String response) {
                            Log.d("myapp",response);
                            Log_InModel model = new Gson().fromJson(response,Log_InModel.class);
                            Toast.makeText(Log_in.this,model.getMessage() , Toast.LENGTH_SHORT).show();
                            if (model.getStatus()==1)
                            {
                                Intent intent=new Intent(Log_in.this,Home.class);

                                startActivity(intent);
                            }

                        }
                    }).execute();


                }
//
            }
//
        });
    }



}