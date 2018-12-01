/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Phong Nguyen
 */
public class DateUtil {

    public static String format="MM/dd/yyyy";
    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat().parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
    public static String parseDate(Long timestamp) {
        Date date=new Date(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
