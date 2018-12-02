/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.HashMap;
import java.util.Map;

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
    
    public static Map<String, String> getParams(String query, String regex){
        Map<String, String> result = new HashMap<>();
        String[] arr = query.split(regex);
        for(String param : arr){
            String[] split = param.split("=");
            result.put(split[0], split[1]);
        }
        
        return result;
    }
}
