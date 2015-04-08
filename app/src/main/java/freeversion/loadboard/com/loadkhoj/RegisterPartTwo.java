package freeversion.loadboard.com.loadkhoj;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class RegisterPartTwo extends ActionBarActivity {

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register_part_two, menu);
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
