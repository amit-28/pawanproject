package freeversion.loadboard.com.loadkhoj.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import freeversion.loadboard.com.loadkhoj.R;

public class LoadKhojMainActivity extends ActionBarActivity implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {

    private static final String TAG = LoadKhojMainActivity.class.getSimpleName();

    private TabHost mTabHost;
    private ViewPager mViewPager;
    private Bundle savedInstanceState;
    private HashMap<String, TabInfo> mapTabInfo = new HashMap<String, LoadKhojMainActivity.TabInfo>();
    private PagerAdapter mPagerAdapter;

    private class TabInfo {
        private String tag;
        private Class<?> clss;
        private Bundle args;
        private Fragment fragment;

        TabInfo(String tag, Class<?> clazz, Bundle args) {
            this.tag = tag;
            this.clss = clazz;
            this.args = args;
        }

    }

    /**
     * A simple factory that returns dummy views to the Tabhost
     *
     * @author mwho
     */
    class TabFactory implements TabHost.TabContentFactory {

        private final Context mContext;

        /**
         * @param context
         */
        public TabFactory(Context context) {
            mContext = context;
        }

        /**
         * (non-Javadoc)
         *
         * @see android.widget.TabHost.TabContentFactory#createTabContent(java.lang.String)
         */
        public View createTabContent(String tag) {
            View v = new View(mContext);
            v.setMinimumWidth(0);
            v.setMinimumHeight(0);
            return v;
        }

    }

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_load_khoj_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
//        getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_TITLE | ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_USE_LOGO | ActionBar.DISPLAY_HOME_AS_UP);

        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mViewPager = (ViewPager) findViewById(R.id.vpgr_root);

        this.initialiseTabHost(savedInstanceState);
        if (savedInstanceState != null) {
            mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab")); //set the tab as per the saved state
        }
        // Initialise ViewPager
        this.initializeViewPager();

        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.navigation_drawer);
        drawerFragment.setUp((DrawerLayout) findViewById(R.id.drawer_layout));
    }

    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("tab", mTabHost.getCurrentTabTag()); //save the tab selected
        super.onSaveInstanceState(outState);
    }

    /**
     * Initialise ViewPager
     */
    private void initializeViewPager() {

        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(new PrivateFragment());

        this.mPagerAdapter = new PagerAdapter(super.getSupportFragmentManager(), fragments);
        this.mViewPager = (ViewPager) super.findViewById(R.id.vpgr_root);
        this.mViewPager.setAdapter(this.mPagerAdapter);
        this.mViewPager.setOnPageChangeListener(this);
    }

    /**
     * Initialise the Tab Host
     */
    private void initialiseTabHost(Bundle args) {
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup();
        TabInfo tabInfo = null;
        LoadKhojMainActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Public").setIndicator("Public"), (tabInfo = new TabInfo("Public", PublicFragment.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        LoadKhojMainActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Private").setIndicator("Private"), (tabInfo = new TabInfo("Private", PrivateFragment.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        LoadKhojMainActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Trucks").setIndicator("Trucks"), (tabInfo = new TabInfo("Trucks", TrucksFragment.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        LoadKhojMainActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Alerts").setIndicator("Alerts"), (tabInfo = new TabInfo("Alerts", NotificationsFragment.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);

        // Default to first tab
        //this.onTabChanged("Tab1");
        //
        mTabHost.setOnTabChangedListener(this);
    }

    /**
     * Add Tab content to the Tabhost
     *
     * @param activity
     * @param tabHost
     * @param tabSpec
     */
    private static void AddTab(LoadKhojMainActivity activity, TabHost tabHost, TabHost.TabSpec tabSpec, TabInfo tabInfo) {
        // Attach a Tab view factory to the spec
        View tabView = createTabView(tabHost.getContext(), tabInfo.tag);
        tabSpec.setIndicator(tabView);
        tabSpec.setContent(activity.new TabFactory(activity));
        tabHost.addTab(tabSpec);
    }

    private static View createTabView(final Context context, final String text) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_layout, null);
        TextView tv = (TextView) view.findViewById(R.id.tabsText);
        tv.setText(text);
        return view;
    }

    /**
     * (non-Javadoc)
     *
     * @see android.widget.TabHost.OnTabChangeListener#onTabChanged(java.lang.String)
     */
    public void onTabChanged(String tag) {
        //TabInfo newTab = this.mapTabInfo.get(tag);
        int pos = this.mTabHost.getCurrentTab();
        this.mViewPager.setCurrentItem(pos);

        initializeViewPager();
    }

    /* (non-Javadoc)
     * @see android.support.v4.view.ViewPager.OnPageChangeListener#onPageScrolled(int, float, int)
     */
    @Override
    public void onPageScrolled(int position, float positionOffset,
                               int positionOffsetPixels) {

    }

    /* (non-Javadoc)
     * @see android.support.v4.view.ViewPager.OnageChangeListener#onPageSelected(int)
     */
    @Override
    public void onPageSelected(int position) {
        this.mTabHost.setCurrentTab(position);
    }

    /* (non-Javadoc)
     * @see android.support.v4.view.ViewPager.OnPageChangeListener#onPageScrollStateChanged(int)
     */
    @Override
    public void onPageScrollStateChanged(int state) {
    }

    public class PagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments;

        /**
         * @param fm
         * @param fragments
         */
        public PagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        /* (non-Javadoc)
         * @see android.support.v4.app.FragmentPagerAdapter#getItem(int)
         */
        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        /* (non-Javadoc)
         * @see android.support.v4.view.PagerAdapter#getCount()
         */
        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_load_khoj_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}