package com.saluyot.masinop.Util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by jerome on 9/21/2016.
 */
public class Toaster {

    public static void showToast(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
