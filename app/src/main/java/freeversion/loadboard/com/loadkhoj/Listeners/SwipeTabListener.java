package freeversion.loadboard.com.loadkhoj.Listeners;

import android.app.ActionBar;
import android.app.FragmentTransaction;

import freeversion.loadboard.com.loadkhoj.LoadKhojMainActivity;

/**
 * Created by amit.ja.
 * Date: 30/7/15
 * Time: 2:06 AM
 */
public class SwipeTabListener implements ActionBar.TabListener {

    LoadKhojMainActivity loadKhojMainActivity;

    public SwipeTabListener(LoadKhojMainActivity loadKhojMainActivity) {
        this.loadKhojMainActivity = loadKhojMainActivity;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
