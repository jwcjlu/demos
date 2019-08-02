package com.jwcjlu.demos.spi;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * <pre>
 * 
 *  File: TSVDecoder.java
 * 
 *  Copyright (c) 2017, globalegrow.com All Rights Reserved.
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,					Who,					What;
 *  2017年5月10日				Jinwei				Initial.
 *
 * </pre>
 */
public class TSVDecoder implements Decoder {  
    public  boolean isEncodingSupported(String encodingName)  {  
        
        if ( encodingName.equalsIgnoreCase("text/tsv") ) {  
               return true;  
             }  
        else  return false;  
     }  
     
    public  String[]  getContent(String input) {  
       List<String> values = new LinkedList<String> ();    
       StringTokenizer parser = new StringTokenizer(input, "\t");    
         
       while(parser.hasMoreTokens()) {    
         values.add(parser.nextToken());    
        }    
       return  (String[])values.toArray(new String[values.size()]);    
      }
}

