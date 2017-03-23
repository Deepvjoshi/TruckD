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
import com.deepjoshi.logibox.Helper.Utils;
import com.deepjoshi.logibox.Model.ForgetPasswordModel;
import com.deepjoshi.logibox.Model.Log_InModel;
import com.google.gson.Gson;

public class ForgotPasswordActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        final Button btn =(Button)findViewById(R.id.btn_);

        final EditText passwordET=(EditText)  findViewById(R.id.et_password);
    btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String strpwd = passwordET.getText().toString();


        if (strpwd.isEmpty())

        {
            Toast.makeText(ForgotPasswordActivity.this, "Email cannot be empty!", Toast.LENGTH_SHORT).show();

        }
        String[]keys=new String[]{"mode","email"};
        String[]values=new String[]{"forgotpassword",strpwd};
        String jsonRequest= Utils.createJsonRequest(keys,values);

        String URL = "http://vnurture.in/logistic/webservice.php";
        new WebserviceCall(ForgotPasswordActivity.this, URL, jsonRequest, "Logging in", true, new AsyncResponse() {
            @Override
            public void onCallback(String response) {
                Log.d("myapp",response);
                ForgetPasswordModel model = new Gson().fromJson(response,ForgetPasswordModel
                        .class);
                Toast.makeText(ForgotPasswordActivity.this,model.getMessage() , Toast.LENGTH_SHORT).show();
                if (model.getStatus()==1)
                {
                    Intent intent=new Intent(ForgotPasswordActivity.this,Log_in.class);

                    startActivity(intent);
                }

            }
        }).execute();
    }
});

    }
}
