/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Date;

/**
 *
 * @author Phong Nguyen
 */
public class GenerateIDUtil {
    public static String GenerateID(){
        String id=String.valueOf(new Date().getTime());
        return id.substring(0, 13);
    }
}
