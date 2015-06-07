package freeversion.loadboard.com.loadkhoj;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import freeversion.loadboard.com.loadkhoj.util.Util;


public class LoginActivity extends ActionBarActivity {

    public final static String loginEmailIdMessage = "freeversion.loadboard.com.loadkhoj.loginEmailIdMessage";
    public final static String loginPasswordMessage = "freeversion.loadboard.com.loadkhoj.loginPasswordMessage";
    TextView responseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        responseTextView = (TextView) findViewById(R.id.apiResponse);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_load_khoj_main, menu);
        StrictMode.enableDefaults();
        return true;
    }

    public void startRegisteration(View view) {
        Intent registerNewUserIntent = new Intent(this, RegisterPartOne.class);
        //starting registration activity
        startActivity(registerNewUserIntent);
    }

    public void loginSuccessful(View view) {
        checkConnection();
        /*Intent loadKhojMainActivityIntent = new Intent(this, LoadKhojMainActivity.class);
        //taking input from layout
        EditText loginEmailIdEditText = (EditText) findViewById(R.id.loginEmailId);
        EditText loginPasswordEditText = (EditText) findViewById(R.id.loginPassword);
        //assigning value to variable
        String loginEmailId = loginEmailIdEditText.getText().toString();
        String loginPassword = loginPasswordEditText.getText().toString();
        //passing it to next activity
        loadKhojMainActivityIntent.putExtra(loginEmailIdMessage,loginEmailId);
        loadKhojMainActivityIntent.putExtra(loginPasswordMessage,loginPassword);
        //starting successful Login activity
        startActivity(loadKhojMainActivityIntent);*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void checkConnection() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        HttpAsyncTask myRequest = null;
        if (netInfo != null && netInfo.isConnected()) {
                myRequest = new HttpAsyncTask();
                myRequest.execute("http://192.168.0.104/login.php");
        } else {
            responseTextView.setText("Net connection or wifi is disabled");
        }
    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
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
                Log.wtf("Login Activity Error",e.getMessage());
            } catch (IOException ioe) {
                Log.wtf("Login Activity Error",ioe.getMessage());
            }
            return null;
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            responseTextView.setText("got response: "+result);
        }
    }
}
