package freeversion.loadboard.com.loadkhoj;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class LoadKhojMainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_khoj_main);

        // Get the message from the intent
        Intent intent = getIntent();
        String loginEmailId = intent.getStringExtra(LoginActivity.loginEmailIdMessage);
        String loginPassword = intent.getStringExtra(LoginActivity.loginPasswordMessage);

        // Create the text view
        TextView textView = (TextView) findViewById(R.id.loginUserData);
        textView.setText("email: "+loginEmailId+" Password:"+loginPassword);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_load_khoj_main, menu);
        return true;
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
