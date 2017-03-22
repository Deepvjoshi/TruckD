package com.deepjoshi.logibox;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.deepjoshi.logibox.AsyncTasks.AsyncResponse;
import com.deepjoshi.logibox.AsyncTasks.WebserviceCall;
import com.deepjoshi.logibox.Helper.Utils;
import com.deepjoshi.logibox.Model.DjModel;
import com.deepjoshi.logibox.Model.RegisterModel;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sign_up extends AppCompatActivity {

    private Spinner spinner_state;
    private Spinner spinner_city;
    private Spinner spinner_area;
    private Spinner spinner_type;
    private Spinner spinner_sec;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final EditText nameET=(EditText)findViewById(R.id.edittext_name_edittext );
        final EditText lastnameET=(EditText)findViewById(R.id.edittext_lastname_edittext );
        final EditText emailET=(EditText)  findViewById(R.id.editext_email_edittext );

        final EditText passwordET=(EditText)findViewById(R.id.edittext_pass_edittext );
        final EditText confirmpasswordET=(EditText)  findViewById(R.id.edittext_conpassword_edittext );
       // final TextView genderTV=(TextView)findViewById(R.id.textview_gender_textview );
//        final RadioButton maleRB=(RadioButton)findViewById(R.id.RBmale );
//        final RadioButton femaleRB=(RadioButton)findViewById(R.id.RBfemale );
        final EditText conET=(EditText )findViewById(R.id.editText_contact_edittext );
        final EditText address=(EditText)findViewById(R.id.edittext_address_edittext);

//        spinner_state=(Spinner)findViewById(R.id.data_spinner_state);
//        final ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.select_state, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner_state.setAdapter(adapter);
//
//        spinner_city=(Spinner)findViewById(R.id.data_spinner_city);
//        String dx[]=getResources().getStringArray(R.array.select_city);
//        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,dx);
//        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner_city.setAdapter(adapter1);
//        String dj = spinner_city.getSelectedItem().toString();
//
//        spinner_area=(Spinner)findViewById(R.id.data_spinner_area);
//        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this,R.array.select_area, android.R.layout.simple_spinner_item);
//        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner_area.setAdapter(adapter2);
//        spinner_type=(Spinner)findViewById(R.id.data_spinner_type);
//        ArrayAdapter<CharSequence> adapter3=ArrayAdapter.createFromResource(this,R.array.select_type, android.R.layout.simple_spinner_item);
//        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner_type.setAdapter(adapter3);
//        spinner_sec=(Spinner)findViewById(R.id.data_spinner_sec_id);
//        ArrayAdapter<CharSequence> adapter4=ArrayAdapter.createFromResource(this,R.array.select_sec, android.R.layout.simple_spinner_item);
//        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner_sec.setAdapter(adapter4);

  final EditText username=(EditText)findViewById(R.id.edittext_username_edittext) ;

        Button btnsignup;
        btnsignup=(Button )findViewById(R.id.signup_btn_signup );
        btnsignup .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strname = nameET.getText().toString();
                String strlastname = lastnameET.getText().toString();
                String strlAddrs = address.getText().toString();
                String stremail = emailET.getText().toString();
                String strpassword = passwordET.getText().toString();
              String strconfirmpassword = confirmpasswordET.getText().toString();
                String usernamestr = username.getText().toString();

//               username String strgender = genderTV.getText().toString();
//                {
//                    if (maleRB.isChecked()) {
//                        maleRB.getText().toString();
//                    } else {
//                        femaleRB.getText().toString();
//                    }
//                }
                String strcontactno = conET.getText().toString();
                if (strname.isEmpty()) {
                    Toast.makeText(Sign_up.this, "please enter name", Toast.LENGTH_SHORT).show();
                } else if (strlastname.isEmpty()) {
                    Toast.makeText(Sign_up.this, "please enter lastname", Toast.LENGTH_SHORT).show();
                } else if (stremail.isEmpty()) {
                    Toast.makeText(Sign_up.this, "please enter your email", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(stremail)) {
                    Toast.makeText(Sign_up.this, "enter valid email ", Toast.LENGTH_SHORT).show();
                } else if (strpassword.isEmpty()) {
                    Toast.makeText(Sign_up.this, "please enter password", Toast.LENGTH_SHORT).show();
                } else if (strconfirmpassword.isEmpty()) {
                    Toast.makeText(Sign_up.this, "please enter confirm password", Toast.LENGTH_SHORT).show();
                } else if (strcontactno.isEmpty()) {
                    Toast.makeText(Sign_up.this, "please enter contact no", Toast.LENGTH_SHORT).show();
                }
                else if (!strconfirmpassword.equals(strpassword)) {
                    Toast.makeText(Sign_up.this, "password don't match", Toast.LENGTH_SHORT).show();
                } else {
                    JSONObject object = new JSONObject();
                    try {
//                        object.put("mode","register");
                        object.put("firstname", strname);
//                        object.put("user_profile_pic",
//                          object.put("email", stremail);
                        object.put("password", strpassword);
                        object.put("dob", "");
                        object.put("username", strname);
                        object.put("phone", strcontactno);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    String jsonRequest = String.valueOf(object);
                    String URL = "http://development.ifuturz.com/core/FLAT_TEST/stone_galary/admin/webservice.php";
                       /* String[] keys = new String[]{"mode","Firstname","Lastname","Emailid","ContactNumber","address","password","ConformPassword","Gender","BirthDate","Cityid","Stateid","Countryid"};
                        String[] values = new String[]{null,strname,strlastname,stremail,strcontactno,null,strpassword,strconfirmpassword,strgender,null,null,null,null};
                        String jsonRequest = Utils.createJsonRequest(keys,values);
                        String URL = "http://development.ifuturz.com/core/FLAT_TEST/jwellery/admin/webservice.php";*/
                }
                String[]keys=new String[]{"mode","fname","lname","address","phone","email","username","psw"};
                String[]values=new String[]{"Register",strname,strlastname,strlAddrs,strcontactno,stremail,usernamestr,strpassword};
                String jsonRequest= Utils.createJsonRequest(keys,values);

                String URL = "http://vnurture.in/logistic/webservice.php";
                new WebserviceCall(Sign_up.this, URL, jsonRequest, "Signing Up...!!", true, new AsyncResponse() {
                    @Override
                    public void onCallback(String response) {
                        Log.d("myapp",response);
                        DjModel model = new Gson().fromJson(response,DjModel.class);
                        Toast.makeText(Sign_up.this,model.getMessage() , Toast.LENGTH_SHORT).show();
                        if (model.getStatus()==1)
                        {
                            Intent intent = new Intent(Sign_up.this,Home.class);
                            startActivity(intent);
                        }

                    }
                }).execute();

            }


        });



    }

    public static boolean isValidEmail(CharSequence target)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern =Pattern .compile(EMAIL_PATTERN );
        matcher =pattern .matcher(target ) ;
        return matcher.matches() ;
    }

}