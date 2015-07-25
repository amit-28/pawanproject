package freeversion.loadboard.com.loadkhoj.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

import freeversion.loadboard.com.loadkhoj.R;
import freeversion.loadboard.com.loadkhoj.constants.KeyConstants;

public class MyTrucksActivity extends Activity {

    MyTrucksActivity activity;
    ListView listTractorTrailer;
    ListView listPayload;
    ListView listFixedContainer;
    ListView listOthers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_trucks);

        activity = this;

        listTractorTrailer = (ListView) findViewById(R.id.lnr_tractor_trailer);
        listPayload = (ListView) findViewById(R.id.lnr_payload);
        listFixedContainer = (ListView) findViewById(R.id.lnr_fixed_container);
        listOthers = (ListView) findViewById(R.id.lnr_others);

        listTractorTrailer.setAdapter(new MyTrucksAdapter(activity, KeyConstants.TRAILER));
        listPayload.setAdapter(new MyTrucksAdapter(activity, KeyConstants.PAYLOAD));
        listFixedContainer.setAdapter(new MyTrucksAdapter(activity, KeyConstants.FIXED_CONTAINER));
        listOthers.setAdapter(new MyTrucksAdapter(activity, KeyConstants.OTHERS));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_trucks, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private static class ViewHolder {
        CheckBox checkBox;
    }

    private static class MyTrucksAdapter extends BaseAdapter {

        MyTrucksActivity activity;
        String[] list;
        LayoutInflater inflater;

        public MyTrucksAdapter(MyTrucksActivity activity, String[] list) {
            super();
            this.activity = activity;
            this.list = list;
            inflater = activity.getLayoutInflater();
        }

        @Override
        public int getCount() {
            return list.length;
        }

        @Override
        public Object getItem(int position) {
            return list[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder viewHolder;

//			if(convertView == null) {
            viewHolder = new ViewHolder();
            View view = inflater.inflate(R.layout.element_my_trucks, null);

            viewHolder.checkBox = (CheckBox) view.findViewById(R.id.my_trucks_checkBox);
//			}
//			else {
//				viewHolder = (ViewHolder) convertView.getTag();
//			}

            Log.e("Position:  ", position + "");
            Log.e("Element:  ", list[position] + "");
            Log.e("Length:  ", list.length + "");


            viewHolder.checkBox.setText(list[position].toString());

            return view;
        }

    }
}
