package com.webservice.boot.controller;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.contentprovider.Content;

import lombok.extern.slf4j.Slf4j;


@RestController
@EnableAsync
@Slf4j
public class WebServiceController {

    @Autowired
    private Content content;
    

     
    @RequestMapping(path = "/xml", method = RequestMethod.POST, consumes = "application/xml",
            produces = "application/xml")
    public String getMessage(@RequestBody String jsonRequest) throws IOException {
        log.info("Received request - ");
        return content.getMyString();
    }

    @RequestMapping(path = "/json", method = RequestMethod.POST, consumes = "application/json",
            produces = "application/json")
    public String sayHello(@RequestBody String jsonRequest) {
        log.info("Received request - " + jsonRequest);
        log.info("Received data from Cache - " + content.getDataById());
        log.info("Received data from DB - " + content.getData());
        return content.getDataById();
    }

}