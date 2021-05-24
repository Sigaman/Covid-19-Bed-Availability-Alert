package com.example.hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    EditText user_name_reg,email_reg,phno_reg,psw_reg,cnf_psw_reg;
    Button sign_up_reg;
    TextView tv_regpage_log;

    RequestQueue requestQueue;
    ProgressDialog pd;
    String spsw,scpsw;
    String Username, Emailid, Phoneno, Password;
    private static final String REGISTER_URL = "https://apix.playtonia.net/v1/auth/sign_up";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        user_name_reg = findViewById(R.id.user_name_reg);
        email_reg = findViewById(R.id.email_reg);
        phno_reg = findViewById(R.id.phno_reg);
        psw_reg = findViewById(R.id.psw_reg);
        cnf_psw_reg = findViewById(R.id.cnf_psw_reg);
        
        /*tv_regpage_log = findViewById(R.id.tv_regpage_log);
        tv_regpage_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Login.class);
                startActivity(i);
            }
        });*/

        sign_up_reg = findViewById(R.id.sign_up_reg);
        sign_up_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Username = user_name_reg.getText().toString().trim();
                Phoneno = phno_reg.getText().toString().trim();
                Emailid = email_reg.getText().toString().trim();
                spsw = psw_reg.getText().toString().trim();
                scpsw = cnf_psw_reg.getText().toString().trim();
                if (spsw.equals(scpsw)){
                    Password = spsw;
                    Toast.makeText(Register.this, Password, Toast.LENGTH_SHORT).show();
                }
//                user_reg();
            }
        });
    }

    private void user_reg() {

        pd = new ProgressDialog(Register.this);
        pd.setTitle("Loading...");
        pd.setIndeterminate(true);
        pd.setCancelable(false);
        pd.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pd.dismiss();

                        try {
                            //converting response to json object
                            JSONObject obj = new JSONObject(response);

                            //if no error in response

                            if (obj.has("email")){
                                Intent i = new Intent(Register.this, Login.class);
//                                String strName = null;
                                Toast.makeText(Register.this, "Succesfully Registered", Toast.LENGTH_SHORT).show();
                                i.putExtra("tr", obj.getString("email"));
                                startActivity(i);
                            }else {
                                Toast.makeText(getApplicationContext(), obj.getString("response"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.dismiss();
//                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                        if (error.networkResponse.statusCode == 400) {
                            try {
                                String response = new String(error.networkResponse.data, "utf-8");
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    if (jsonObject.has("email")) {
                                        JSONArray jsonArray = jsonObject.getJSONArray("email");
                                        if (jsonArray.length() > 0) {
//                                            edt3.setError(jsonArray.getString(0));
//                                            snackbar = Snackbar.make(linearLayout, jsonArray.getString(0), Snackbar.LENGTH_LONG);
                                            Toast.makeText(getApplicationContext(), jsonArray.getString(0), Toast.LENGTH_LONG).show();
//                                            Toast.makeText(Register.this, "Emai exists", Toast.LENGTH_SHORT).show();
//                                            snackbar.show();
                                        }
                                        // Toast.makeText(Login.this, jsonObject.getString("email"), Toast.LENGTH_SHORT).show();
                                    }
                                    // Toast.makeText(Login.this, jsonObject.getString("email"), Toast.LENGTH_SHORT).show();

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", Username);
                params.put("email", Emailid);
                params.put("email", Phoneno);
                params.put("password", Password);
                return params;
            }
        };

        requestQueue.add(stringRequest);
        // VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);



    }
}