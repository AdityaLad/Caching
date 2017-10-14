package com.webservice.dataaccess;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazelcast.core.HazelcastInstance;
import com.webservice.model.Data;

@Service
@SuppressWarnings("unchecked")
public class HazelCastDataAccessImpl implements DataAccess {
    
    @Autowired
    private HazelcastInstance hazelcastInstance;
    
    @Override
    public Data getHotelDataById(String id) {
        return  (Data) getHazelCachedDataMap()
                .get(id);
    }
    
    @SuppressWarnings("rawtypes")
    private Map getHazelCachedDataMap() {
        return hazelcastInstance.getMap("dbcache");
    }
    
}
