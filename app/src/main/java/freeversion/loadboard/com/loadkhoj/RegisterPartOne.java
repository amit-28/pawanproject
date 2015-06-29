package freeversion.loadboard.com.loadkhoj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class RegisterPartOne extends Activity {

    public final static String registerFullNameMessage = "freeversion.loadboard.com.loadkhoj.registerFullNameMessage";
    public final static String registerMobileNumberMessage = "freeversion.loadboard.com.loadkhoj.registerMobileNumberMessage";
    public final static String registerEmailIdMessage = "freeversion.loadboard.com.loadkhoj.registerEmailIdMessage";
    public final static String registerPasswordMessage = "freeversion.loadboard.com.loadkhoj.registerPasswordMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_part_one);
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
}
