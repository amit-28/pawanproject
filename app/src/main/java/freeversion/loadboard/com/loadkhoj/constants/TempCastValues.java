package freeversion.loadboard.com.loadkhoj.constants;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import freeversion.loadboard.com.loadkhoj.bean.LoadFragmentItem;

/**
 * Created by amit.ja.
 * Date: 9/8/15
 * Time: 7:08 PM
 */
public class TempCastValues {
    private static List<LoadFragmentItem> loadFragmentItemList = new ArrayList<LoadFragmentItem>() {{
        add(new LoadFragmentItem(1, "ODC", "Precicam", "mulund", "andheri", new Date(System.currentTimeMillis()), 10000, 7000, 1));
        add(new LoadFragmentItem(1, "RTF", "Enterprises", "USA", "ulhas", new Date(System.currentTimeMillis()), 20000, 9000, 3));
    }};

    public static List<LoadFragmentItem> getLoadFragmentItemList() {
        return loadFragmentItemList;
    }
}
