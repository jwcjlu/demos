package com.jwcjlu.demos.jetty.restful;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * <pre>
 *  restful请求的所有异常都由该类来处理
 *  File: CustomExceptionMapper.java
 * 
 *  Copyright (c) 2017, globalegrow.com All Rights Reserved.
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,					Who,					What;
 *  2017年11月22日				jinwei				Initial.
 *
 * </pre>
 */
@Provider
public class HandlerExceptionMapper implements ExceptionMapper<Throwable>
{
    @Override
    public Response toResponse(Throwable exception)
    {
        // TODO Auto-generated method stub
        Result result=new Result(false);
        result.setMsg(exception.getMessage());
        Response.ResponseBuilder  ResponseBuilder = Response.ok(result, MediaType.APPLICATION_JSON);
        return ResponseBuilder.build();
    }

}

