package freeversion.loadboard.com.loadkhoj;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class LoginActivity extends ActionBarActivity {

    public final static String loginEmailIdMessage = "freeversion.loadboard.com.loadkhoj.loginEmailIdMessage";
    public final static String loginPasswordMessage = "freeversion.loadboard.com.loadkhoj.loginPasswordMessage";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_load_khoj_main, menu);
        return true;
    }

    public void startRegisteration(View view){
        Intent registerNewUserIntent = new Intent(this, RegisterPartOne.class);
        //starting registration activity
        startActivity(registerNewUserIntent);
    }

    public void loginSuccessful(View view){
        Intent loadKhojMainActivityIntent = new Intent(this, LoadKhojMainActivity.class);
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
        startActivity(loadKhojMainActivityIntent);
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
}
