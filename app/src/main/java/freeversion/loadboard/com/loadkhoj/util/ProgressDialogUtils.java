package freeversion.loadboard.com.loadkhoj.util;

/**
 * Created by root on 30/8/15.
 */

import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;

/**
     * Utility class used to show progress dialog with message
     * while communicating with server
     * @author LoadKhoj
     */
    public class ProgressDialogUtils
    {
        private static final String TAG = ProgressDialogUtils.class.getSimpleName();
        private ProgressDialog progressDialog;
        /**
         * Set the progress dialog for activity passed
         * @param activity : activity for which progress dialog is shown
         */
        public ProgressDialogUtils(Activity activity) {
            progressDialog = new ProgressDialog(activity);
            progressDialog.setCancelable(false);
            progressDialog.setInverseBackgroundForced(false);
        }
        /**
         * close currently showing progress dialog
         */
        public void close()
        {
            if(progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
        /**
         * set the message to be shown in progress dialog
         */
        public void setMessage(String message)
        {
            progressDialog.setMessage(message);
        }
        /**
         * display the progress dialog
         */
        public void show()
        {

            try {
                if(!progressDialog.isShowing()) {
                    progressDialog.show();
                }
            }
            catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
        }
    }