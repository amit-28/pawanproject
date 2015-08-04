package freeversion.loadboard.com.loadkhoj.ui.activities;

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
        Intent intent = getIntent();
        String registerFullName = intent.getStringExtra(RegisterPartOne.registerFullNameMessage);
        String registerMobileNumber = intent.getStringExtra(RegisterPartOne.registerMobileNumberMessage);
        String registerEmailId = intent.getStringExtra(RegisterPartOne.registerEmailIdMessage);
        String registerPassword = intent.getStringExtra(RegisterPartOne.registerPasswordMessage);

        // Create the text view
        TextView textView = (TextView) findViewById(R.id.Rp2);
        textView.setText("fullname: "+registerFullName+" no:"+registerMobileNumber+"email: "+registerEmailId+" Password:"+registerPassword);
    }

}
