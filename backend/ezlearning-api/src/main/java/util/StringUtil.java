/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author lap11916
 */
public class StringUtil {
    public static boolean isEmpty(String str){
        if ((str == null) || (str.isEmpty())) {
            return true;
        }
        return false;
    }
}
