package freeversion.loadboard.com.loadkhoj.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import freeversion.loadboard.com.loadkhoj.R;


public class RegisterPartTwo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_part_two);
        // Get the message from the intent
        Intent registerPartOneIntent = getIntent();
        String registerFullName = registerPartOneIntent.getStringExtra(RegisterPartOne.registerFullNameMessage);
        String registerMobileNumber = registerPartOneIntent.getStringExtra(RegisterPartOne.registerMobileNumberMessage);
        String registerEmailId = registerPartOneIntent.getStringExtra(RegisterPartOne.registerEmailIdMessage);
        String registerPassword = registerPartOneIntent.getStringExtra(RegisterPartOne.registerPasswordMessage);

        // Create the text view
        TextView textView = (TextView) findViewById(R.id.Rp2);
        textView.setText("fullname: " + registerFullName + " no:" + registerMobileNumber + "email: " + registerEmailId + " Password:" + registerPassword);

        Intent registerPartThreeIntent = new Intent(this, RegisterPartThree.class);
        //passing it to next activity
//        registerPartThreeIntent.putExtra(registerFullNameMessage,registerFullName);
//        registerPartThreeIntent.putExtra(registerMobileNumberMessage,registerMobileNumber);
//        registerPartThreeIntent.putExtra(registerEmailIdMessage,registerEmailId);
//        registerPartThreeIntent.putExtra(registerPasswordMessage,registerPassword);
        //starting successful Login activity
        startActivity(registerPartThreeIntent);
    }

}
