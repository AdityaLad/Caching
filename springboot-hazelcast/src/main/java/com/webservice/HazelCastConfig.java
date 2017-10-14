package com.webservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.NetworkConfig;

@Configuration
public class HazelCastConfig {
    
    @Bean
    public Config config() {
        // return new Config().addMapConfig(new
        // MapConfig().setName("accepted-messages")
        // .setEvictionPolicy(EvictionPolicy.LRU).setTimeToLiveSeconds(2400))
        // .setProperty("hazelcast.logging.type", "slf4j");
        
        Config cfg = new Config();
        NetworkConfig network = cfg.getNetworkConfig();
        JoinConfig join = network.getJoin();
        
        join.getMulticastConfig().setEnabled(false);
        cfg.addMapConfig(
                new MapConfig().setName("db-config").setEvictionPolicy(EvictionPolicy.NONE).setTimeToLiveSeconds(0))
                .setProperty("hazelcast.logging.type", "slf4j");
        return cfg;
        
        // return new Config().addMapConfig(
        // new
        // MapConfig().setName("db-config").setEvictionPolicy(EvictionPolicy.LRU).setTimeToLiveSeconds(2400))
        // .setProperty("hazelcast.logging.type", "slf4j");
    }
}
