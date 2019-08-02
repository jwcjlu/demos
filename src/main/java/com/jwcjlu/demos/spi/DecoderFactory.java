package com.jwcjlu.demos.spi;

import java.util.ServiceLoader;

/**
 * <pre>
 * 
 *  File: DecoderFactory.java
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
public class DecoderFactory
{
    public static Decoder getDecoder(String encodingName) throws Exception{  
        ServiceLoader<Decoder> sl = ServiceLoader.load(Decoder.class);  
                 for ( Decoder decode :sl ) {      
                     if ( decode.isEncodingSupported(encodingName) )  
                        return decode;                     
                     }  
           throw new Exception("Not supported encoding:"+encodingName);  
         }   
}

