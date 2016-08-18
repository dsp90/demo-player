package com.example.msa.videoplayer.utils;

import android.app.ProgressDialog;
import android.content.Context;

import com.example.msa.videoplayer.R;

/**
 * Created by msa on 15/08/2016.
 */
public class DialogUtils {

    public static ProgressDialog getProgressDialog(Context context, String message){
        if(context != null) {
            ProgressDialog dialog = new ProgressDialog(context, android.R.style.Theme_DeviceDefault_Dialog);
            dialog.setMessage(message == null ? context.getString(R.string.progress_dialog) : message);
            dialog.setCancelable(false);
            return dialog;
        }
        return null;
    }

}
