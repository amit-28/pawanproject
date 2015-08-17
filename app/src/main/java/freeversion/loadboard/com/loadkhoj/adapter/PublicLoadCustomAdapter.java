package freeversion.loadboard.com.loadkhoj.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import freeversion.loadboard.com.loadkhoj.R;
import freeversion.loadboard.com.loadkhoj.bean.LoadFragmentItem;

/**
 * Created by amit.ja.
 * Date: 9/8/15
 * Time: 6:11 PM
 */
public class PublicLoadCustomAdapter extends BaseAdapter {

    private Context context;
    List<LoadFragmentItem> listOfPublicLoads;

    public PublicLoadCustomAdapter(Context context, List<LoadFragmentItem> listOfPublicLoads) {
        this.context = context;
        this.listOfPublicLoads = listOfPublicLoads;
    }

    @Override
    public int getCount() {
        return listOfPublicLoads.size();
    }

    @Override
    public Object getItem(int position) {
        return listOfPublicLoads.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listOfPublicLoads.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.fragment_item_public_load, null);
        }

//        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView loadTypeTextView = (TextView) convertView.findViewById(R.id.loadType);
        TextView companyNameTextView = (TextView) convertView.findViewById(R.id.companyName);
        TextView sourceTextView = (TextView) convertView.findViewById(R.id.source);
        TextView destinationTextView = (TextView) convertView.findViewById(R.id.destination);
        TextView quoteTextView = (TextView) convertView.findViewById(R.id.loadQuote);
        TextView expiryDateTextView = (TextView) convertView.findViewById(R.id.expiryDate);

        LoadFragmentItem row_pos = listOfPublicLoads.get(position);
        // setting the image resource and title
//        imgIcon.setImageResource(row_pos.getIcon());
        loadTypeTextView.setText(row_pos.getLoadType());
        companyNameTextView.setText(row_pos.getCompanyName());
        sourceTextView.setText(row_pos.getSource());
        destinationTextView.setText(row_pos.getDestination());
        quoteTextView.setText(String.valueOf(row_pos.getQuote()));
        expiryDateTextView.setText(row_pos.getExpiryDate().toString());

        return convertView;
    }
}