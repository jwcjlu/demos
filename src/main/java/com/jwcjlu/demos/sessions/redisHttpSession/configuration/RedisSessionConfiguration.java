package com.jwcjlu.demos.sessions.redisHttpSession.configuration;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import redis.clients.jedis.JedisPoolConfig;


/**
 * <pre>
 * 
 *  File: RedisSessionConfiguration.java
 * 
 *  Copyright (c) 2018, globalegrow.com All Rights Reserved.
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,					Who,					What;
 *  2018年1月6日				jinwei				Initial.
 *
 * </pre>
 */
@Configuration
@EnableRedisHttpSession(redisNamespace="ejob-console")
public class RedisSessionConfiguration
{
    @Value("${maxRedirections}")
    private int maxRedirects;
    @Value("${redis.host}")
    private String hostAndPorts;
    @Bean
    public JedisConnectionFactory connectionFactory(RedisClusterConfiguration redisClusterConfiguration,JedisPoolConfig jedisPoolConfig){    
        return new JedisConnectionFactory(redisClusterConfiguration,jedisPoolConfig);
    }
    
    @Bean
    @Scope()
    public RedisClusterConfiguration redisClusterConfiguration() throws Exception{
        RedisClusterConfiguration rcc= new RedisClusterConfiguration(parseHostAndPort());    
        if(maxRedirects>0){
             rcc.setMaxRedirects(maxRedirects);
        }
         return rcc;
    }
    
    @Bean
    @Scope()
    public JedisPoolConfig jedisPoolConfig(){
        return new JedisPoolConfig();
    }
    /**
     * 解析ip
     * 
     * @return
     * @throws Exception
     */
    private Set<String> parseHostAndPort() throws Exception
 
    {
        try
        {
            String[] ipPorts = hostAndPorts.split(",");
            Set<String> haps = new HashSet<String>();
            for (String key : ipPorts)
            {
                if (!"".equals(key))
                {
                  
                    haps.add(key);
                }
            }
            return haps;
        }
        catch (Exception e)
        {
          
            throw new Exception("redis.properties  config error", e);
        }
    }
}

