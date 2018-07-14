/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionaryprac;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mangesh
 */
public class DictionaryPrac {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // English to Spanish Dictionary
        Map <String, String> engSpanDictionary = new HashMap<String, String>();
        engSpanDictionary.put("Monday","1");
        engSpanDictionary.put("Tuesday","2");
        engSpanDictionary.put("Wednesday","3");
        engSpanDictionary.put("Thursday","4");
        engSpanDictionary.put("Friday","5");
        engSpanDictionary.put("Saturday","6");
        engSpanDictionary.put("Sunday","7");
        System.out.println(engSpanDictionary.get("Monday"));
        System.out.println(engSpanDictionary.get("Friday"));
        System.out.println(engSpanDictionary.get("Sunday"));
    }
    
}
