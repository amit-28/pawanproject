package freeversion.loadboard.com.loadkhoj;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class RegisterPartOne extends ActionBarActivity {

    public final static String registerFullNameMessage = "freeversion.loadboard.com.loadkhoj.registerFullNameMessage";
    public final static String registerMobileNumberMessage = "freeversion.loadboard.com.loadkhoj.registerMobileNumberMessage";
    public final static String registerEmailIdMessage = "freeversion.loadboard.com.loadkhoj.registerEmailIdMessage";
    public final static String registerPasswordMessage = "freeversion.loadboard.com.loadkhoj.registerPasswordMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_part_one);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register_part_one, menu);
        return true;
    }

    public void registerPartTwo(View view){
        Intent registerPartTwoIntent = new Intent(this, RegisterPartTwo.class);
        //taking input from layout
        EditText registerFullNameEditText = (EditText) findViewById(R.id.registerFullName);
        EditText registerMobileNumberEditText = (EditText) findViewById(R.id.registerMobileNumber);
        EditText registerEmailIdEditText = (EditText) findViewById(R.id.registerEmailId);
        EditText registerPasswordEditText = (EditText) findViewById(R.id.registerPassword);
        //assigning value to variable
        String registerFullName = registerFullNameEditText.getText().toString();
        String registerMobileNumber = registerMobileNumberEditText.getText().toString();
        String registerEmailId = registerEmailIdEditText.getText().toString();
        String registerPassword = registerPasswordEditText.getText().toString();
        //passing it to next activity
        registerPartTwoIntent.putExtra(registerFullNameMessage,registerFullName);
        registerPartTwoIntent.putExtra(registerMobileNumberMessage,registerMobileNumber);
        registerPartTwoIntent.putExtra(registerEmailIdMessage,registerEmailId);
        registerPartTwoIntent.putExtra(registerPasswordMessage,registerPassword);
        //starting successful Login activity
        startActivity(registerPartTwoIntent);
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
