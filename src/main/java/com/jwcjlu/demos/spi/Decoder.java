package com.jwcjlu.demos.spi;
/**
 * <pre>
 * 
 *  File: Decoder.java
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
public interface Decoder
{
    boolean isEncodingSupported(String encodingName);  
    String[]  getContent(String input);
}

