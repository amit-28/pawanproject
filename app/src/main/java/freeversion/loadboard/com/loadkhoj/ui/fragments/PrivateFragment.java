package freeversion.loadboard.com.loadkhoj.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.List;

import freeversion.loadboard.com.loadkhoj.R;
import freeversion.loadboard.com.loadkhoj.adapter.PrivateLoadCustomAdapter;
import freeversion.loadboard.com.loadkhoj.bean.LoadFragmentItem;
import freeversion.loadboard.com.loadkhoj.constants.TempCastValues;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrivateFragment extends ListFragment implements AdapterView.OnItemClickListener {

    private List<LoadFragmentItem> tempItemList = TempCastValues.getLoadFragmentItemList();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_private, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Inflate the layout for this fragment

        PrivateLoadCustomAdapter privateLoadCustomAdapter = new PrivateLoadCustomAdapter(getActivity(), tempItemList);
        setListAdapter(privateLoadCustomAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), tempItemList.get(position).getCompanyName(), Toast.LENGTH_SHORT)
                .show();
    }


}
