package freeversion.loadboard.com.loadkhoj;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import freeversion.loadboard.com.loadkhoj.constants.ApiConstants;
import freeversion.loadboard.com.loadkhoj.util.Util;


public class LoginActivity extends Activity {

    public final static String loginEmailIdMessage = "freeversion.loadboard.com.loadkhoj.loginEmailIdMessage";
    public final static String loginPasswordMessage = "freeversion.loadboard.com.loadkhoj.loginPasswordMessage";
    EditText loginEmailIdEditText;
    EditText loginPasswordEditText;
    TextView responseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        responseTextView = (TextView) findViewById(R.id.responseTextview);
        loginPasswordEditText = (EditText) findViewById(R.id.loginPassword);
        loginEmailIdEditText = (EditText) findViewById(R.id.loginEmailId);
    }

    public void startRegisteration(View view) {
        Intent registerNewUserIntent = new Intent(this, RegisterPartOne.class);
        //starting registration activity
        startActivity(registerNewUserIntent);
    }

    public void startLogin(View view) {
        //TODO remove comment for proper login
        //checkConnectionAndLogin();

        loadIntent();
    }

    public void checkConnectionAndLogin() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        LoginConnectionAsyncTask myRequest = null;
        if (netInfo != null && netInfo.isConnected()) {
            myRequest = new LoginConnectionAsyncTask();
            myRequest.execute(ApiConstants.loginAPI);
        } else {
            responseTextView.setText("Net connection or wifi is disabled");
        }
    }

    public void loadIntent() {
        Intent loadKhojMainActivityIntent = new Intent(this, LoadKhojMainActivity.class);

        //assigning value to variable
        String loginEmailId = loginEmailIdEditText.getText().toString();
        String loginPassword = loginPasswordEditText.getText().toString();
        //passing it to next activity
        loadKhojMainActivityIntent.putExtra(loginEmailIdMessage, loginEmailId);
        loadKhojMainActivityIntent.putExtra(loginPasswordMessage, loginPassword);
        //starting successful Login activity
        startActivity(loadKhojMainActivityIntent);
    }

    private class LoginConnectionAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                httpURLConnection.setRequestProperty("Accept", "application/json");
                httpURLConnection.setRequestMethod("POST");

                JSONObject auth = new JSONObject();
                try {
                    auth.put("username", loginEmailIdEditText.getText().toString());
                    auth.put("password", loginPasswordEditText.getText().toString());
                } catch (JSONException e) {
                    Log.wtf("Json Decode Error", e.getMessage());
                    return "Decode Error";
                }
                OutputStreamWriter wr = new OutputStreamWriter(httpURLConnection.getOutputStream());
                wr.write(auth.toString());
                wr.flush();
                wr.close();
                httpURLConnection.setConnectTimeout(5 * 1000);          // 5 s.
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) // 200 = "OK" code (http connection is fine).
                {
                    Log.wtf("Login Activity Connection", "Success !");
                    InputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
                    return Util.readStream(bis);
                } else {
                    Log.wtf("Login Activity Connection", "Fail");
                    return "Connection Error";
                }
            } catch (MalformedURLException e) {
                Log.wtf("Login Activity Error", e.getMessage());
                return "Connection Error";
            } catch (IOException ioe) {
                Log.wtf("Login Activity Error", ioe.getMessage());
                return "Connection Error";
            }
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
//            responseTextView.setText("got response: "+result);
            Log.wtf("response", result);
            if (result.equals("Connection Error")) {
                Log.wtf("Json Output", result);
                responseTextView.setText("Login Failed.Connection Error.");
            } else if (result.equals("Decode Error")) {
                Log.wtf("Json Output", result);
                responseTextView.setText("Login Failed.Decode Error.");
            } else {
                try {
                    JSONObject jObject = new JSONObject(result);
//                if(jObject.getString("status").equals("true"))
                    if (jObject.getBoolean("status"))
                        loadIntent();
                    else
                        responseTextView.setText("Login Failed.");
                } catch (JSONException e) {
                    Log.wtf("Json Decode Error", e.getMessage());
                    responseTextView.setText("Login Failed.Error.");
                }
            }
        }
    }
}
