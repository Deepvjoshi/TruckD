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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final EditText uName=(EditText)findViewById(R.id.signup_ev_usnm);
        final EditText uemailId=(EditText)findViewById(R.id.signup_ev_eid);
        final EditText addRess=(EditText)findViewById(R.id.signup_ev_add);
        final EditText passWrd=(EditText)findViewById(R.id.signup_ev_pw);
        final EditText cnum=(EditText)findViewById(R.id.signup_ev_cn);

        Button bt3=(Button) findViewById (R.id.signup_createanaccount);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String uname = uName.getText().toString();
                String emailid = uemailId.getText().toString();
                String stradd = addRess.getText().toString();
                String passw = passWrd.getText().toString();
                String cono = cnum.getText().toString();

                if (uname.isEmpty()) {
                    Toast.makeText(Sign_up.this, "User Name cannot be empty!", Toast.LENGTH_SHORT).show();

                } else if (emailid.isEmpty()) {
                    Toast.makeText(Sign_up.this, "Email Id cannot be empty", Toast.LENGTH_SHORT).show();

                } else if (stradd.isEmpty()) {
                    Toast.makeText(Sign_up.this, "Enter Address", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(emailid)) {
                    Toast.makeText(Sign_up.this, "Enter valid email", Toast.LENGTH_SHORT).show();
                } else if (passw.isEmpty()) {
                    Toast.makeText(Sign_up.this, "please enter password", Toast.LENGTH_SHORT).show();
                } else if (cono.isEmpty()) {
                    Toast.makeText(Sign_up.this, "please enter password", Toast.LENGTH_SHORT).show();
                } else {
                    JSONObject object = new JSONObject();
                    try {
//                        object.put("mode","register");
                        object.put("userName", uname);
                        object.put("emailId", emailid);
                        object.put("address", stradd);
                        object.put("password", passw);

                        object.put("contactNumber", cono);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    String jsonRequest = String.valueOf(object);

//                Intent i = new Intent(Sign_up.this,MainActivity.class);
//                startActivity(i);
                    String URL = "http://development.ifuturz.com/core/FLAT_TEST/ecart_new /admin/webservice.php";
                    new WebserviceCall(Sign_up.this, URL, jsonRequest, "Loading...", true, new AsyncResponse() {
                        @Override
                        public void onSuccess(final String message, JSONArray jsonData) {
                            Toast.makeText(Sign_up.this, message, Toast.LENGTH_SHORT).show();
                            try {
                                getSharedPreferences("testpref", MODE_PRIVATE).edit().putString("id", jsonData.getJSONObject(0).getString("id")).apply();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Intent intent = new Intent(Sign_up.this, MainActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(String message) {
                            Toast.makeText(Sign_up.this, message, Toast.LENGTH_SHORT).show();
                        }
                    }).execute();
                }

            }
        });
            }

    public static boolean isValidEmail(CharSequence target) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(target);
        return matcher.matches();
    }
}
