package com.jwcjlu.demos.springboot.metric;

import java.util.concurrent.TimeUnit;

import metrics_influxdb.InfluxdbHttp;
import metrics_influxdb.InfluxdbReporter;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Counter;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.ScheduledReporter;
import com.codahale.metrics.Slf4jReporter;
import com.codahale.metrics.Timer;

/**
 * <pre>
 * 
 *  File: MetricConfig.java
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
@Configuration
public class MetricConfig {

    @Bean
    public MetricRegistry metrics() {
        return new MetricRegistry();
    }
    /**
     * Reporter 数据的展现位置
     *
     * @param metrics
     * @return
     */
    @Bean
    public ConsoleReporter consoleReporter(MetricRegistry metrics) {
        return ConsoleReporter.forRegistry(metrics)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
    }

    @Bean
    public Slf4jReporter slf4jReporter(MetricRegistry metrics) {
        return Slf4jReporter.forRegistry(metrics)
                .outputTo(LoggerFactory.getLogger("demo.metrics"))
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
    }

    @Bean
    public JmxReporter jmxReporter(MetricRegistry metrics) {
        return JmxReporter.forRegistry(metrics).build();
    }
    @Bean(name = "influxdbReporter")
    public ScheduledReporter influxdbReporter(MetricRegistry metrics) throws Exception {

        return InfluxdbReporter.forRegistry(metrics)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .filter(MetricFilter.ALL)
                .skipIdleMetrics(false)
                .build(new InfluxdbHttp("10.40.6.113", 8086, "metric", "root", "root"));
    }

    /**
     * 自定义单位
     *
     * @param metrics
     * @return
     */
  /*  @Bean
    public ListManager listManager(MetricRegistry metrics) {
        return new ListManager(metrics);
    }*/

    /**
     * TPS 计算器
     *
     * @param metrics
     * @return
     */
    @Bean
    public Meter requestMeter(MetricRegistry metrics) {
        return metrics.meter("request");
    }

    /**
     * 直方图
     *
     * @param metrics
     * @return
     */
    @Bean
    public Histogram responseSizes(MetricRegistry metrics) {
        return metrics.histogram("response-sizes");
    }

    /**
     * 计数器
     *
     * @param metrics
     * @return
     */
    @Bean
    public Counter pendingJobs(MetricRegistry metrics) {
        return metrics.counter("requestCount");
    }

    /**
     * 计时器
     *
     * @param metrics
     * @return
     */
    @Bean
    public Timer responses(MetricRegistry metrics) {
        return metrics.timer("executeTime");
    }

}



