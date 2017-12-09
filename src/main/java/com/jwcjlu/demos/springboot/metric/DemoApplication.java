package com.jwcjlu.demos.springboot.metric;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.codahale.metrics.ScheduledReporter;

/**
 * <pre>
 * 
 *  File: DemoApplication.java
 * 
 *  Copyright (c) 2017, globalegrow.com All Rights Reserved.
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,					Who,					What;
 *  2017年12月8日				jinwei				Initial.
 *
 * </pre>
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
        // 启动Reporter
        ScheduledReporter reporter = (ScheduledReporter) ctx.getBean("influxdbReporter");
        reporter.start(1, TimeUnit.SECONDS);
        
    }

}

