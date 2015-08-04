package freeversion.loadboard.com.loadkhoj.ui.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import freeversion.loadboard.com.loadkhoj.R;
import freeversion.loadboard.com.loadkhoj.constants.NavigationDrawerConstants;
import freeversion.loadboard.com.loadkhoj.ui.activities.HistoryActivity;
import freeversion.loadboard.com.loadkhoj.ui.activities.LoadKhojMainActivity;

/**
 * Created by root on 1/8/15.
 */
public class NavigationDrawerFragment extends Fragment implements AdapterView.OnItemClickListener {

    private Activity mActivityContext;
    private NavigationDrawerFragment mFragmentContext;

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private LinearLayout leftDrawerLinearLayout;
    private ListView navList;

    private int mCurrentSelectedPosition = 0;
    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";


    private static final String TAG = NavigationDrawerFragment.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityContext = getActivity();
        mFragmentContext = this;

        if (savedInstanceState != null) {
            mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
        }


        // Select either the default item (0) or the last selected item.
        loadSelection(mCurrentSelectedPosition);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Indicate that this fragment would like
        // to influence the set of actions in the action bar.
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation_drawer, null);
//        Uncomment below line to fix orientation to portrait.
//        mActivityContext.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mDrawerLayout = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        navList = (ListView) view.findViewById(R.id.left_drawer_list);
        leftDrawerLinearLayout = (LinearLayout) view.findViewById(R.id.left_drawer);
        init();

    }

    void init() {
        ArrayList<String> navArray = new ArrayList<>();
        navArray.addAll(NavigationDrawerConstants.navigationDrawerItemList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(mActivityContext, android.R.layout.simple_list_item_activated_1, navArray);
        navList.setAdapter(arrayAdapter);
        navList.setOnItemClickListener(this);
        loadSelection(0);
    }

    private void loadSelection(int position) {
        mCurrentSelectedPosition = position;
        if (navList != null) {
            navList.setItemChecked(position, true);
        }
    }

    public void setUp(DrawerLayout drawerLayout) {
        mDrawerLayout = drawerLayout;
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.END);
        //always use under score to separate names in xml files.
        //names in xml files always in small case.
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                Intent mainActivityIntent = new Intent(getActivity(), LoadKhojMainActivity.class);
                startActivity(mainActivityIntent);
                break;
            case 1:
//                Intent myTructsIntent = new Intent(MainActivity.this, HistoryActivity.class);
//                startActivity(myTructsIntent);
                break;
            case 2:
                Intent historyIntent = new Intent(getActivity(), HistoryActivity.class);
                startActivity(historyIntent);
                break;
            case 3:
                break;
        }
        mDrawerLayout.closeDrawer(leftDrawerLinearLayout);
    }
}