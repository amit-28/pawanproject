package freeversion.loadboard.com.loadkhoj.constants;

import java.util.ArrayList;

/**
 * Created by amit on 29/7/15.
 */
public class NavigationDrawerConstants {

    public static final String DRAWER_MY_LOADS = "My Loads";
    public static final String DRAWER_MY_TRUCKS = "My trucks";
    public static final String DRAWER_HISTORY = "History";
    public static final String DRAWER_SIGN_OUT = "Sign Out";

    public static ArrayList<String> navigationDrawerItemList = new ArrayList<String>() {{
        add(DRAWER_MY_LOADS);
        add(DRAWER_MY_TRUCKS);
        add(DRAWER_HISTORY);
        add(DRAWER_SIGN_OUT);
    }};
}