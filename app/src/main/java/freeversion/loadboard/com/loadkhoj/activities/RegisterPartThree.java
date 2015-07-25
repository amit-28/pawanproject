package freeversion.loadboard.com.loadkhoj.activities;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import freeversion.loadboard.com.loadkhoj.R;
import freeversion.loadboard.com.loadkhoj.bean.Interest;
import freeversion.loadboard.com.loadkhoj.constants.KeyConstants;

/**
 * Created by amit on 25/7/15.
 */
public class RegisterPartThree extends Activity {
    private ExpandableListView myExpandableListView;
    public RegisterPartThree mActivity;
    Interest interest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_part_three);

        mActivity = this;
        myExpandableListView = (ExpandableListView) findViewById(R.id.exp_list_interest);
        interest = new Interest();

        String[] myCalendarGroup = KeyConstants.GroupNames;
        String[][] myCalendarSubitems = KeyConstants.GroupItems;

        // Represent the expandable list adapter
        final ExpandableListAdapter expandableListAdapter = new ExpandableListAdapter(myCalendarGroup, myCalendarSubitems, true, mActivity);
        // set the adapter on expandable list view
        myExpandableListView.setAdapter(expandableListAdapter);

        // set the click listener on child and groups
        myExpandableListView
                .setOnChildClickListener(new OnChildClickListener() {

                    @Override
                    public boolean onChildClick(ExpandableListView parent,
                                                View v, int groupPosition, int childPosition,
                                                long id) {
                        Log.e("xyz", "Group Position: " + groupPosition
                                + " , child Position: " + childPosition);
                        if (groupPosition == 0) {
                            if (childPosition == 0) {
                                if (interest.isA()) {
                                    Log.e("xyz", "setting false");
                                    interest.setA(false);
                                } else {
                                    Log.e("xyz", "setting true");
                                    interest.setA(true);
                                }

                            } else if (childPosition == 1) {
                                if (interest.isB()) {
                                    interest.setB(false);
                                } else {
                                    interest.setB(true);
                                }
                            } else if (childPosition == 3) {
                                if (interest.isC()) {
                                    interest.setC(false);
                                } else {
                                    interest.setC(true);
                                }
                            }
                        }

                        if (groupPosition == 1) {
                            if (childPosition == 0) {
                                if (interest.isD()) {
                                    interest.setD(false);
                                } else {
                                    interest.setD(true);
                                }

                            } else if (childPosition == 1) {
                                if (interest.isE()) {
                                    interest.setE(false);
                                } else {
                                    interest.setE(true);
                                }
                            } else if (childPosition == 2) {
                                if (interest.isF()) {
                                    interest.setF(false);
                                } else {
                                    interest.setF(true);
                                }
                            } else if (childPosition == 3) {
                                if (interest.isG()) {
                                    interest.setG(false);
                                } else {
                                    interest.setG(true);
                                }
                            }/*
                             * else if (childPosition == 4) { if
							 * (interest.isH()) {
							 * myExpandableItemsViewHolder.checkBox
							 * .setChecked(false); interest.setH(false); } else
							 * {
							 * myExpandableItemsViewHolder.checkBox.setChecked(
							 * true); interest.setH(true); } } else if
							 * (childPosition == 5) { if (interest.isI()) {
							 * myExpandableItemsViewHolder
							 * .checkBox.setChecked(false);
							 * interest.setI(false); } else {
							 * myExpandableItemsViewHolder
							 * .checkBox.setChecked(true); interest.setI(true);
							 * } }
							 */
                        }
                        expandableListAdapter.notifyDataSetChanged();

                        return false;
                    }
                });
        myExpandableListView
                .setOnGroupClickListener(new OnGroupClickListener() {

                    @Override
                    public boolean onGroupClick(ExpandableListView parent,
                                                View v, int groupPosition, long id) {

//						Log.e("xyz", "Group Position: " + groupPosition);

                        if (groupPosition == 2) {

                            Intent intent = new Intent(mActivity,
                                    MyTrucksActivity.class);
                            startActivity(intent);

                        }
                        expandableListAdapter.notifyDataSetChanged();

                        return false;
                    }
                });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    class MyExpandableItemsViewHolder {
        private TextView text;
        private CheckBox checkBox;
        private TextView textDest;
        private TextView textSrc;
        private Button buttonAddSub;
        private ImageView img;
    }

    public class ExpandableListAdapter extends BaseExpandableListAdapter {

        private final LayoutInflater layoutInflator;
        private String[] groups;
        private String[][] children;

        /*
         * private int friendRequestCount; private int taskRequestCount; private
         * int tagRequestCount;
         */
        private Typeface helveticaLight;

        public ExpandableListAdapter(String[] groups, String[][] children,
                                     boolean isMyCalendar, RegisterPartThree activity) {
			/*
			 * helveticaLight = Typeface.createFromAsset(activity
			 * .getApplicationContext().getAssets(),
			 * "fonts/helvetica_light.otf");
			 */
            this.groups = groups;
            this.children = children;
            layoutInflator = activity.getLayoutInflater();
        }

        private ContextWrapper getActivity() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return children[groupPosition].length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groups[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return children[groupPosition][childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getChildView(final int groupPosition,
                                 final int childPosition, boolean isLastChild, View convertView,
                                 ViewGroup parent) {

            View view = null;

            // get the views from view holder
            MyExpandableItemsViewHolder myExpandableItemsViewHolder = new MyExpandableItemsViewHolder();

            if (groupPosition == 0 || groupPosition == 1) {

                Log.e("xyz", "groupPosition:  " + groupPosition);

                view = layoutInflator.inflate(R.layout.element_interest_child,
                        parent, false);

                myExpandableItemsViewHolder.checkBox = (CheckBox) view
                        .findViewById(R.id.interest_checkbox);
                myExpandableItemsViewHolder.text = (TextView) view
                        .findViewById(R.id.txt_interest_content);

                myExpandableItemsViewHolder.text.setTypeface(helveticaLight);

            }

            if (groupPosition == 3 || groupPosition == 4) {
                view = layoutInflator.inflate(R.layout.element_source_destination,
                        parent, false);
            }


            // get the string child view text and set it on text view
            String itemText = getChild(groupPosition, childPosition).toString();
            myExpandableItemsViewHolder.text.setText(itemText);

            if (groupPosition == 0) {
                if (childPosition == 0) {
                    Log.e("xyz", interest.isA() + "");
                    myExpandableItemsViewHolder.checkBox.setChecked(interest
                            .isA());
                } else if (childPosition == 1) {
                    myExpandableItemsViewHolder.checkBox.setChecked(interest
                            .isB());

                } else if (childPosition == 2) {
                    myExpandableItemsViewHolder.checkBox.setChecked(interest
                            .isC());
                }
            }

            if (groupPosition == 1) {
                if (childPosition == 0) {
                    myExpandableItemsViewHolder.checkBox.setChecked(interest
                            .isD());
                } else if (childPosition == 1) {
                    myExpandableItemsViewHolder.checkBox.setChecked(interest
                            .isE());
                } else if (childPosition == 2) {
                    myExpandableItemsViewHolder.checkBox.setChecked(interest
                            .isF());
                } else if (childPosition == 3) {
                    myExpandableItemsViewHolder.checkBox.setChecked(interest
                            .isG());
                } else if (childPosition == 4) {
                    myExpandableItemsViewHolder.checkBox.setChecked(interest
                            .isH());
                } else if (childPosition == 5) {
                    myExpandableItemsViewHolder.checkBox.setChecked(interest
                            .isI());
                }
            }

            if (groupPosition == 3) {

            }

            if (groupPosition == 4) {

            }
            myExpandableItemsViewHolder.checkBox
                    .setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            Log.e("xyz", "Group Position: " + groupPosition
                                    + " , child Position: " + childPosition);
                            if (groupPosition == 0) {
                                if (childPosition == 0) {
                                    if (interest.isA()) {
                                        Log.e("xyz", "setting false");
                                        interest.setA(false);
                                    } else {
                                        Log.e("xyz", "setting true");
                                        interest.setA(true);
                                    }

                                } else if (childPosition == 1) {
                                    if (interest.isB()) {
                                        interest.setB(false);
                                    } else {
                                        interest.setB(true);
                                    }
                                } else if (childPosition == 3) {
                                    if (interest.isC()) {
                                        interest.setC(false);
                                    } else {
                                        interest.setC(true);
                                    }
                                }
                            }

                            if (groupPosition == 1) {
                                if (childPosition == 0) {
                                    if (interest.isD()) {
                                        interest.setD(false);
                                    } else {
                                        interest.setD(true);
                                    }

                                } else if (childPosition == 1) {
                                    if (interest.isE()) {
                                        interest.setE(false);
                                    } else {
                                        interest.setE(true);
                                    }
                                } else if (childPosition == 2) {
                                    if (interest.isF()) {
                                        interest.setF(false);
                                    } else {
                                        interest.setF(true);
                                    }
                                } else if (childPosition == 3) {
                                    if (interest.isG()) {
                                        interest.setG(false);
                                    } else {
                                        interest.setG(true);
                                    }
                                } else if (childPosition == 4) {
                                    if (interest.isG()) {
                                        interest.setH(false);
                                    } else {
                                        interest.setH(true);
                                    }
                                } else if (childPosition == 5) {
                                    if (interest.isG()) {
                                        interest.setI(false);
                                    } else {
                                        interest.setI(true);
                                    }
                                }
                            }
                        }
                    });

            return view;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            // get the task request count from database

            convertView = layoutInflator.inflate(R.layout.element_interest,
                    parent, false);

            // get the views from view holder class
            MyExpandableItemsViewHolder myExpandableItemsViewHolder = new MyExpandableItemsViewHolder();
			/*
			 * myExpandableItemsViewHolder.expIcon = (ImageView) convertView
			 * .findViewById(R.id.img_expand);
			 */

            myExpandableItemsViewHolder.img = (ImageView) convertView.findViewById(R.id.img_expand);
            myExpandableItemsViewHolder.text = (TextView) convertView
                    .findViewById(R.id.txt_header);
            myExpandableItemsViewHolder.text.setTypeface(helveticaLight);
            // set the text from string passed to group view
            myExpandableItemsViewHolder.text.setText(getGroup(groupPosition)
                    .toString());


//		    View ind = convertView.findViewById(android.R.drawable.btn_dropdown);
            // set the respective icons for group names
            // else set the visibility to gone
            if (groupPosition == 0 || groupPosition == 1 || groupPosition == 3 || groupPosition == 4) {
//				myExpandableItemsViewHolder.img.setImageDrawable(getResources().getDrawable(R.drawable.arrow_exp_list));
            } else if (groupPosition == 2) {
                myExpandableItemsViewHolder.img.setImageDrawable(getResources().getDrawable(R.drawable.expander_ic_forward));

            }


            // set the visibility of divider to invisible if group view is first
            // or last
            if (groupPosition == 0) {
                ((View) convertView
                        .findViewById(R.id.group_devider_of_navigation_drawer_bottom))
                        .setVisibility(View.VISIBLE);
            }
            // else set visibilty to visible
            else {
                ((View) convertView
                        .findViewById(R.id.group_devider_of_navigation_drawer_bottom))
                        .setVisibility(View.INVISIBLE);
            }

            // if children count is 0 then set the drawable of expandable icon
            // to null
			/*
			 * else { // else set the open/close expandable icon if (isExpanded)
			 * {
			 *
			 * myExpandableItemsViewHolder.expIcon
			 * .setImageDrawable(getResources().getDrawable(
			 * R.drawable.ic_launcher));
			 *
			 * } else {
			 *
			 * myExpandableItemsViewHolder.expIcon
			 * .setImageDrawable(getResources().getDrawable(
			 * R.drawable.ic_launcher));
			 *
			 * } }
			 */
            // if group view is request's then set the badges of total number of
            // requests

            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub
            return true;
        }
    }

}
