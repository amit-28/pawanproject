package freeversion.loadboard.com.loadkhoj.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import freeversion.loadboard.com.loadkhoj.R;


public class RegisterPartTwo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_part_two);
        // Get the message from the intent
        Intent registerPartOneIntent = getIntent();
        String registerPartOneUserData = registerPartOneIntent.getStringExtra(RegisterPartOne.registerUserDataMessage);

        //taking input from layout
        EditText typeOfCompanyEditText = (EditText) findViewById(R.id.registerTypeOfCompany);
        EditText companyNameEditText = (EditText) findViewById(R.id.registerCompanyName);
        EditText stdEditText = (EditText) findViewById(R.id.registerSTD);
        EditText landlineEditText = (EditText) findViewById(R.id.registerLandline);
        EditText countryCodeEditText = (EditText) findViewById(R.id.registerCountryCode);
        EditText mobileNumberEditText = (EditText) findViewById(R.id.registerMobileNumber);
        EditText addressEditText = (EditText) findViewById(R.id.registerAddress);
        EditText cityEditText = (EditText) findViewById(R.id.registerCity);

        //assigning value to variable
        String typeOfCompany = typeOfCompanyEditText.getText().toString();
        String companyName = companyNameEditText.getText().toString();
        String std = stdEditText.getText().toString();
        String landline = landlineEditText.getText().toString();
        String countryCode = countryCodeEditText.getText().toString();
        String mobileNumber = mobileNumberEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String city = cityEditText.getText().toString();

        JSONObject userData;
        try {
            userData = new JSONObject(registerPartOneUserData);
        } catch (JSONException e) {
            Log.wtf("JSONException while decoding register one object: ", e.getMessage());
            userData = new JSONObject();
        }

        try {
            userData.put("typeOfCompany", typeOfCompany);
            userData.put("companyName", companyName);
            userData.put("std", std);
            userData.put("landline", landline);
            userData.put("countryCode", countryCode);
            userData.put("mobileNumber", mobileNumber);
            userData.put("address", address);
            userData.put("city", city);
        } catch (JSONException e) {
            Log.wtf("JSONException while creating register two object: ", e.getMessage());
        }


        // Create the text view
//        TextView textView = (TextView) findViewById(R.id.Rp2);
//        textView.setText(registerPartOneUserData);

//        Intent registerPartThreeIntent = new Intent(this, RegisterPartThree.class);
//        //starting successful Login activity
//        startActivity(registerPartThreeIntent);

    }

}
