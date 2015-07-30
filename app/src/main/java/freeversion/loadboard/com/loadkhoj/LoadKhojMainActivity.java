package freeversion.loadboard.com.loadkhoj;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import freeversion.loadboard.com.loadkhoj.Listeners.SwipeTabListener;
import freeversion.loadboard.com.loadkhoj.constants.NavigationDrawerConstants;


public class LoadKhojMainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private ListView navList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_khoj_main);

        /**
         *  NAVIGATION DRAWER
         */
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navList = (ListView) findViewById(R.id.left_drawer);
        ArrayList<String> navArray = new ArrayList<>();
        navArray.addAll(NavigationDrawerConstants.navigationDrawerItemList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, navArray);
        navList.setAdapter(arrayAdapter);
        navList.setOnItemClickListener(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.openDrawer, R.string.closeDrawer);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
//        actionBar.setDefaultDisplayHomeAsUpEnabled(true);

        /**
         *  SWIPE AND TABS
         */


        loadSelection(0);

        //Testing purpose
        // Get the message from the intent
        Intent intent = getIntent();
        String loginEmailId = intent.getStringExtra(LoginActivity.loginEmailIdMessage);
        String loginPassword = intent.getStringExtra(LoginActivity.loginPasswordMessage);

        // Create the text view
//        TextView textView = (TextView) findViewById(R.id.loginUserData);
//        textView.setText("email: "+loginEmailId+" Password:"+loginPassword);
    }

    private void loadSelection(int position) {
        navList.setItemChecked(position, true);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
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
        } else if (id == android.R.id.home) {
            if (drawerLayout.isDrawerOpen(navList)) {
                drawerLayout.closeDrawer(navList);
            } else {
                drawerLayout.openDrawer(navList);
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
        drawerLayout.closeDrawer(navList);
    }
}
