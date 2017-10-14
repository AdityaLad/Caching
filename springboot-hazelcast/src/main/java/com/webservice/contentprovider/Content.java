package com.webservice.contentprovider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.dataaccess.DataAccess;
import com.webservice.model.Data;
import com.webservice.repository.DataRepository;

@Service("content")
public class Content {
	
    @Autowired
    private DataRepository hotelDataRepository;
    
    @Autowired
    private DataAccess dataAccessLayer;

    public static String getMyString() throws IOException {
        String myString = null;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        Thread.currentThread().getContextClassLoader().getResourceAsStream("mystring.txt")))) {
            myString = br.lines().collect(Collectors.joining("\n"));
        }

        return myString;
    }
    
    public String getData(){
    	Iterable<Data> list = hotelDataRepository.findAll();
    	Data h = list.iterator().next();
    	return h.getHotelid();
    }
    
    public String getDataById(){
    	Data hData = dataAccessLayer.getHotelDataById(getData());
    	return hData.getHotelid();
    }
    	
}
