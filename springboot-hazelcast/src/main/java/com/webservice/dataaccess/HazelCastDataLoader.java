package com.webservice.dataaccess;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.TransactionalMap;
import com.hazelcast.transaction.TransactionContext;
import com.hazelcast.transaction.TransactionOptions;
import com.hazelcast.transaction.TransactionOptions.TransactionType;
import com.webservice.model.Data;
import com.webservice.repository.DataRepository;

@Service
public class HazelCastDataLoader {
    
    @Autowired
    private DataRepository hotelDataRepository;
    
    @Autowired
    private HazelcastInstance hazelcastInstance;
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void loadCache() {
        
    	
        TransactionOptions options = new TransactionOptions().setTransactionType(TransactionType.TWO_PHASE);
        
        TransactionContext context = hazelcastInstance.newTransactionContext(options);
        
        context.beginTransaction();
        
        TransactionalMap databaseCache = context.getMap("dbcache");
        
        databaseCache.destroy();
           
        try {
        	Iterable<Data> list = hotelDataRepository.findAll();
        	Iterator<Data> i = list.iterator();
        	while(i.hasNext()){
        		Data tmp = i.next();
        		databaseCache.put(tmp.getHotelid(),tmp);
        	}
            
            context.commitTransaction();
        } catch (Throwable t) {
            context.rollbackTransaction();
        }
        
    }
}
