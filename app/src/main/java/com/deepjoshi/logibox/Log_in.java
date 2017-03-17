package com.deepjoshi.logibox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.deepjoshi.logibox.AsyncTasks.AsyncResponse;
import com.deepjoshi.logibox.AsyncTasks.WebserviceCall;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
                    Toast.makeText(Log_in.this, "Unauthorized user", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Log_in.this,Home.class);
                            startActivity(intent);
//                    JSONObject object = new JSONObject();
//                    try {
////                        object.put("mode","loginUser");
//                        object.put("emailId", stremail);
//                        object.put("password", strpwd);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//                    String jsonRequest = String.valueOf(object);
////                    String URL = "http://development.ifuturz.com/core/FLAT_TEST/stone_galary/admin/webservice.php";
//                    String URL = "http://development.ifuturz.com/core/FLAT_TEST/ecart_new/admin/webservice.php";
//                    new WebserviceCall(Log_in.this, URL, jsonRequest, "Loading...", true, new AsyncResponse() {
//                        @Override
//                        public void onSuccess(final String message, JSONArray jsonData) {
//                            Toast.makeText(Log_in.this, message, Toast.LENGTH_SHORT).show();
//                            try {
//                                getSharedPreferences("testpref",MODE_PRIVATE).edit().putString("id",jsonData.getJSONObject(0).getString("id")).apply();
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                            Intent intent = new Intent(Log_in.this,MainActivity.class);
//                            startActivity(intent);
//                        }
//
//                        @Override
//                        public void onFailure(String message) {
//                            Toast.makeText(Log_in.this, message, Toast.LENGTH_SHORT).show();
//                        }
//                    }).execute();
//
              }
//
            }
//
        });
                }



    }