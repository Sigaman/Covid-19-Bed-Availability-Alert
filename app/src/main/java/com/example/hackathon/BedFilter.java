package com.example.hackathon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hackathon.adapter.Adapter_Bed_Filter;
import com.example.hackathon.adapter.Adapter_success;
import com.example.hackathon.model.Obj_Bed_Filter;
import com.example.hackathon.model.Obj_success;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BedFilter extends AppCompatActivity {

    
    List<Obj_Bed_Filter> obj_bed_filters;

    Spinner spnr_dist, spnr_hospital_type, spnr_severity, spnr_bed_type;
    String S_spnr_dist, S_spnr_hospital_type, S_spnr_severity, S_spnr_bed_type;
    String SS_spnr_dist, SS_spnr_hospital_type, SS_spnr_severity, SS_spnr_bed_type;
    Button btn_search;
    String SS_spnr_Government;
    String SS_spnr_Private;
    RecyclerView recy_bed_filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bed_filter);

        spnr_dist = findViewById(R.id.spnr_dist);
        spnr_hospital_type = findViewById(R.id.spnr_hospital_type);
        spnr_severity = findViewById(R.id.spnr_severity);
        spnr_bed_type = findViewById(R.id.spnr_bed_type);

        obj_bed_filters = new ArrayList<>();

        recy_bed_filter = findViewById(R.id.recy_bed_filter);
        recy_bed_filter.setHasFixedSize(true);
        recy_bed_filter.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//        emptyView = (TextView) view.findViewById(R.id.empty_view_cm);

        btn_search = findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                S_spnr_dist = spnr_dist.getSelectedItem().toString().trim();
                S_spnr_hospital_type = spnr_hospital_type.getSelectedItem().toString().trim();
                S_spnr_severity = spnr_severity.getSelectedItem().toString().trim();
                S_spnr_bed_type = spnr_bed_type.getSelectedItem().toString().trim();

//                s = gm_txt.getText().toString().trim();
                if (S_spnr_dist.equals("Ariyalur")) {
                    SS_spnr_dist = "5ea0abd3d43ec2250a483a4f";
                } else if (S_spnr_dist.equals("Chengalpattu")) {
                    SS_spnr_dist = "5ea0abd4d43ec2250a483a61";
                } else if (S_spnr_dist.equals("Chennai")) {
                    SS_spnr_dist = "5ea0abd2d43ec2250a483a40";
                } else if (S_spnr_dist.equals("Coimbatore")) {
                    SS_spnr_dist = "5ea0abd3d43ec2250a483a4a";
                } else if (S_spnr_dist.equals("Cuddalore")) {
                    SS_spnr_dist = "5ea0abd3d43ec2250a483a50";
                } else if (S_spnr_dist.equals("Dharmapuri")) {
                    SS_spnr_dist = "5ea0abd2d43ec2250a483a43";
                } else if (S_spnr_dist.equals("Dindigul")) {
                    SS_spnr_dist = "5ea0abd3d43ec2250a483a4b";
                } else if (S_spnr_dist.equals("Erode")) {
                    SS_spnr_dist = "5ea0abd2d43ec2250a483a48";
                } else if (S_spnr_dist.equals("Kallakurichi")) {
                    SS_spnr_dist = "5ea0abd4d43ec2250a483a5f";
                } else if (S_spnr_dist.equals("Kancheepuram")) {
                    SS_spnr_dist = "5ea0abd2d43ec2250a483a41";
                } else if (S_spnr_dist.equals("Kanniyakumari")) {
                    SS_spnr_dist = "5ea0abd3d43ec2250a483a5c";
                } else if (S_spnr_dist.equals("Karur")) {
                    SS_spnr_dist = "5ea0abd3d43ec2250a483a4c";
                } else if (S_spnr_dist.equals("Krishnagiri")) {
                    SS_spnr_dist = "5ea0abd3d43ec2250a483a5d";
                } else if (S_spnr_dist.equals("Madurai")) {
                    SS_spnr_dist = "5ea0abd3d43ec2250a483a56";
                } else if (S_spnr_dist.equals("Mayiladuthurai")) {
                    SS_spnr_dist = "60901c5f2481a4362891d572";
                } else if (S_spnr_dist.equals("Nagapattinam")) {
                    SS_spnr_dist = "5ea0abd3d43ec2250a483a51";
                } else if (S_spnr_dist.equals("Namakkal")) {
                    SS_spnr_dist = "5ea0abd2d43ec2250a483a47";
                } else if (S_spnr_dist.equals("Nilgiris")) {
                    SS_spnr_dist = "5ea0abd3d43ec2250a483a49";
                } else if (S_spnr_dist.equals("Perambalur")) {
                    SS_spnr_dist = "5ea0abd3d43ec2250a483a4e";
                } else if (S_spnr_dist.equals("Pudukkottai")) {
                    SS_spnr_dist = "5ea0abd3d43ec2250a483a54";
                } else if (S_spnr_dist.equals("Ramanathapuram")) {
                    SS_spnr_dist = "5ea0abd3d43ec2250a483a59";
                } else if (S_spnr_dist.equals("Ranipet")) {
                    SS_spnr_dist = "5ea0abd4d43ec2250a483a63";
                } else if (S_spnr_dist.equals("Salem")) {
                    SS_spnr_dist = "5ea0abd2d43ec2250a483a46";
                } else if (S_spnr_dist.equals("Sivagangai")) {
                    SS_spnr_dist = "5ea0abd3d43ec2250a483a55";
                } else if (S_spnr_dist.equals("Tenkasi")) {
                    SS_spnr_dist = "5ea0abd4d43ec2250a483a60";
                } else if (S_spnr_dist.equals("Thanjavur")) {
                    SS_spnr_dist = "5ea0abd3d43ec2250a483a53";
                } else if (S_spnr_dist.equals("Theni")) {
                    SS_spnr_dist = "5ea0abd3d43ec2250a483a57";
                } else if (S_spnr_dist.equals("Thiruchirappalli")) {
                    SS_spnr_dist = "5ea0abd3d43ec2250a483a4d";
                } else if (S_spnr_dist.equals("Thirupathur")) {
                    SS_spnr_dist = "5ea0abd4d43ec2250a483a62";
                } else if (S_spnr_dist.equals("Thiruvarur")) {
                    SS_spnr_dist = "5ea0abd3d43ec2250a483a52";
                } else if (S_spnr_dist.equals("Thoothukudi")) {
                    SS_spnr_dist = "5ea0abd3d43ec2250a483a5a";
                } else if (S_spnr_dist.equals("Tirunelveli")) {
                    SS_spnr_dist = "5ea0abd3d43ec2250a483a5b";
                } else if (S_spnr_dist.equals("Tiruppur")) {
                    SS_spnr_dist = "5ea0abd4d43ec2250a483a5e";
                } else if (S_spnr_dist.equals("Tiruvallur")) {
                    SS_spnr_dist = "5ea0abd1d43ec2250a483a3f";
                } else if (S_spnr_dist.equals("Tiruvannamalai")) {
                    SS_spnr_dist = "5ea0abd2d43ec2250a483a44";
                } else if (S_spnr_dist.equals("Vellore")) {
                    SS_spnr_dist = "5ea0abd2d43ec2250a483a42";
                } else if (S_spnr_dist.equals("Villupuram")) {
                    SS_spnr_dist = "5ea0abd2d43ec2250a483a45";
                } else if (S_spnr_dist.equals("Virudhunagar")) {
                    SS_spnr_dist = "5ea0abd3d43ec2250a483a58";
                } else {
                    Toast.makeText(getApplicationContext(), "Game is Invalid", Toast.LENGTH_SHORT).show();
                }

                if (S_spnr_severity.equals("CHO - Severe Cases")) {
                    SS_spnr_severity = "CHO";
                } else if (S_spnr_severity.equals("CHC - Moderate Cases")) {
                    SS_spnr_severity = "CHC";
                } else if (S_spnr_severity.equals("CCC - Mild Cases")) {
                    SS_spnr_severity = "CCC";
                } else {
                    Toast.makeText(getApplicationContext(), "Game is Invalid", Toast.LENGTH_SHORT).show();

                }

                if (S_spnr_bed_type.equals("Normal Bed")) {
                    SS_spnr_bed_type = "Normal";
                } else if (S_spnr_bed_type.equals("Oxygen Bed")) {
                    SS_spnr_bed_type = "O2";
                } else if (S_spnr_bed_type.equals("ICU Bed")) {
                    SS_spnr_bed_type = "ICU";
                } /*else if (S_spnr_bed_type.equals("ALL Bed")) {
                    SS_spnr_bed_type = "";
                } */else {
                    Toast.makeText(getApplicationContext(), "Game is Invalid", Toast.LENGTH_SHORT).show();

                }
                if (S_spnr_hospital_type.equals("Government")) {
                    SS_spnr_Government = "true";
                    SS_spnr_Private = "false";
                } else if (S_spnr_hospital_type.equals("Private")) {
                    SS_spnr_Government = "true";
                    SS_spnr_Private = "false";
                } else {
                    Toast.makeText(getApplicationContext(), "Game is Invalid", Toast.LENGTH_SHORT).show();

                }

                Log.d("_dist", S_spnr_dist + " - " + SS_spnr_dist);
                Log.d("_hospital_type", S_spnr_hospital_type + " = Government" + SS_spnr_Government + " - Private " + SS_spnr_Private);
                Log.d("_severity", SS_spnr_severity);
                Log.d("_bed_type", SS_spnr_bed_type);
                slider_image();
            }
        });


    }

    private void slider_image() {

        final JSONObject jsonObject = new JSONObject();
        try {
            JSONArray userJsonarray = new JSONArray();
            JSONArray userJsonarray_one = new JSONArray();
//    "pageLimit": 5000,
//    "ShowIfVacantOnly": "",
//    "IsGovernmentHospital": true,
//    "IsPrivateHospital": true

//            jsonObject.put("project", "-_id imageMobile");

//            "SortValue": "Alphabetically",
            jsonObject.put("pageLimit", 5000);
            jsonObject.put("ShowIfVacantOnly", "Alphabetically");
            jsonObject.put("SortValue", SS_spnr_bed_type);
            jsonObject.put("IsGovernmentHospital", SS_spnr_Government);
            jsonObject.put("IsPrivateHospital", SS_spnr_Private);
            userJsonarray.put(SS_spnr_severity);
            userJsonarray_one.put(SS_spnr_dist);
            jsonObject.put("FacilityTypes", userJsonarray);
            jsonObject.put("Districts", userJsonarray_one);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        /*final JSONObject jsonObject = new JSONObject();
        try {
            JSONObject userJson = new JSONObject();

            userJson.put("project", "-_id imageMobile");
//            userJson.put("password", Password);

            jsonObject.put("data", userJson);

        } catch (JSONException e) {
            e.printStackTrace();
        }*/

        //vp

        new ValidateAsyncTask(jsonObject).execute();


    }

    class ValidateAsyncTask extends AsyncTask<String, Void, String> {

        private InputStream in;
        private HttpURLConnection httpURLConnection;
        String stream = null;
        JSONObject jsonObject, fcmJsonObject;
        String product_exception;

        ValidateAsyncTask(JSONObject userObject) {
            this.jsonObject = userObject;

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {

            StringBuilder sb;

            try {
                URL Url = new URL(BED_FILTER_URL);
                httpURLConnection = (HttpURLConnection) Url.openConnection();
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
//                httpURLConnection.setRequestProperty("Authorization",JWT);
                //e.g. bearer token= eyJhbGciOiXXXzUxMiJ9.eyJzdWIiOiPyc2hhcm1hQHBsdW1zbGljZS5jb206OjE6OjkwIiwiZXhwIjoxNTM3MzQyNTIxLCJpYXQiOjE1MzY3Mzc3MjF9.O33zP2l_0eDNfcqSQz29jUGJC-_THYsXllrmkFnk85dNRbAw66dyEKBP5dVcFUuNTA8zhA83kk3Y41_qZYx43T


                OutputStreamWriter wr = new OutputStreamWriter(httpURLConnection.getOutputStream());
                Log.d("_AC", "ACB" + jsonObject.toString());
                wr.write(jsonObject.toString());
                wr.close();

                int repCode = httpURLConnection.getResponseCode();

                if (repCode == HttpURLConnection.HTTP_CREATED || repCode == HttpURLConnection.HTTP_OK) {

                    in = new BufferedInputStream(httpURLConnection.getInputStream());
                    product_exception = "true";
                } else if (repCode == HttpURLConnection.HTTP_UNAUTHORIZED) {

                    in = new BufferedInputStream(httpURLConnection.getErrorStream());
                    product_exception = "unAuthorized";
                } else if (repCode == HttpURLConnection.HTTP_FORBIDDEN) {

                    in = new BufferedInputStream(httpURLConnection.getErrorStream());
                    product_exception = "Forbidden";
                } else if (repCode == HttpURLConnection.HTTP_BAD_REQUEST) {

                    in = new BufferedInputStream(httpURLConnection.getErrorStream());
                    product_exception = "badRequest";
                } else {
                    in = new BufferedInputStream(httpURLConnection.getErrorStream());
                    product_exception = "false";
                }

                // Read the BufferedInputStream
                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                sb = new StringBuilder();

                String line;
                while ((line = r.readLine()) != null) {
                    sb.append(line);
                }

                stream = sb.toString();
                Log.d("_AC", "ACR : " + stream);

            } catch (Exception e) {
                e.printStackTrace();
                product_exception = String.valueOf(false);
            } finally {
                // Disconnect the HttpURLConnection & Close InputStream
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
            return stream;
        }

        @Override
        protected void onPostExecute(String stream) {

            if (product_exception.equals("true")) {


                // viewpager
                try {
//                    sliderItems = new ArrayList<>();
//                    JSONObject obj = new JSONObject(stream);
//                    Log.e("Y", obj.toString());
//                    Toast.makeText(BedFilter.this, obj.toString(), Toast.LENGTH_SHORT).show();
                    JSONObject jsonObject = new JSONObject(stream);
                    if (jsonObject.has("result")) {
                        Log.e("JSONAAA",jsonObject.getString("result"));

                        JSONArray jsonArray = jsonObject.getJSONArray("result");
                        obj_bed_filters = new ArrayList<>();
//                        JSONArray jsonArray = new JSONArray("result");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            Obj_Bed_Filter ooo = new Obj_Bed_Filter();
                            JSONObject jsonObjectd = jsonArray.getJSONObject(i);

                            Log.e("Hosp_id",jsonObjectd.getString("_id"));
                            Log.e("Hosp_Name",jsonObjectd.getString("Name"));
                            Log.e("FacilityType",jsonObjectd.getString("FacilityType"));
//                            Log.e("CovidBedDetails",jsonObjectd.getString("CovidBedDetails"));



                            if (jsonObjectd.has("CovidBedDetails")){
                                JSONObject o = jsonObjectd.getJSONObject("CovidBedDetails");
                                Log.e("O2",o.getString("VaccantO2Beds"));

                                ooo.setS_bed_fltr_hosp_name(jsonObjectd.getString("Name"));
                                ooo.setS_bed_fltr_FacilityType(jsonObjectd.getString("FacilityType"));

                                ooo.setS_bed_fltr_O2_Bed(o.getString("VaccantO2Beds"));

                            }


                            obj_bed_filters.add(ooo);


                        }
                    }




                    Adapter_Bed_Filter adapter = new Adapter_Bed_Filter(obj_bed_filters, BedFilter.this);
                    recy_bed_filter.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } else if (product_exception.equals("badRequest")) {
                try {
                    JSONObject jsonObject = new JSONObject(stream);
                    if (jsonObject.has("message")) {

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else if (product_exception.equals("unAuthorized")) {
                try {
                    JSONObject jsonObject = new JSONObject(stream);
                    if (jsonObject.has("message")) {

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
//this toast is appearing thr?
                try {
                    JSONObject jsonObject = new JSONObject(stream);
                    /*JSONArray jsonArray = jsonObject.getJSONArray("response");
                if(jsonArray.length()>0){
                    Toast.makeText(getApplicationContext(), jsonArray.getString(0), Toast.LENGTH_LONG).show();
                }*/
//                    Toast.makeText(getContext(), jsonObject.toString(), Toast.LENGTH_LONG).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                /*JSONArray jsonArray = jsonObject.getJSONArray("response");
                if(jsonArray.length()>0){
                    Toast.makeText(getApplicationContext(), jsonArray.getString(0), Toast.LENGTH_LONG).show();
                }*/
            }

        }

    }
}