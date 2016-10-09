package com.saluyot.masinop.Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by jerome on 10/7/2016.
 */
public class DateUtil {

    public static String currentDateTime(){

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Date today = Calendar.getInstance().getTime();

        return df.format(today);
    }
}
