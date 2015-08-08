package freeversion.loadboard.com.loadkhoj.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import freeversion.loadboard.com.loadkhoj.R;


public class RegisterPartOne extends Activity {

//    public final static String registerFullNameMessage = "freeversion.loadboard.com.loadkhoj.registerFullNameMessage";
//    public final static String registerMobileNumberMessage = "freeversion.loadboard.com.loadkhoj.registerMobileNumberMessage";
//    public final static String registerEmailIdMessage = "freeversion.loadboard.com.loadkhoj.registerEmailIdMessage";
//    public final static String registerPasswordMessage = "freeversion.loadboard.com.loadkhoj.registerPasswordMessage";

    public final static String registerUserDataMessage = "registerPartOneUserData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_part_one);
    }

    public void registerPartTwo(View view){
        Intent registerPartTwoIntent = new Intent(this, RegisterPartTwo.class);
        //taking input from layout
        EditText fullNameEditText = (EditText) findViewById(R.id.registerFullName);
        EditText emailIdEditText = (EditText) findViewById(R.id.registerEmailId);
        EditText passwordEditText = (EditText) findViewById(R.id.registerPassword);

        //assigning value to variable
        String fullName = fullNameEditText.getText().toString();
        String emailId = emailIdEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        //Creating Json Object of data
        JSONObject userData = new JSONObject();
        try {
            userData.put("FullName", fullName);
            userData.put("EmailId", emailId);
            userData.put("Password", password);
        } catch (JSONException e) {
            Log.wtf("JSONException while creating register one object: ", e.getMessage());
        }

        //passing it to next a//ctivity
//        registerPartTwoIntent.putExtra(registerFullNameMessage,registerFul//lName);
//        registerPartTwoIntent.putExtra(registerMobileNumberMessage,registerMobileN//umber);
//        registerPartTwoIntent.putExtra(registerEmailIdMessage,registerEm//ailId);
//        registerPartTwoIntent.putExtra(registerPasswordMessage,registerPa

        registerPartTwoIntent.putExtra(registerUserDataMessage, userData.toString());

        //starting successful Login activity
        startActivity(registerPartTwoIntent);
    }
}