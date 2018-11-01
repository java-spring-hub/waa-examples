package com.eprogrammerz.examples.session.service.impl;

import com.eprogrammerz.examples.session.data.Database;
import com.eprogrammerz.examples.session.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdviceServiceImpl implements AdviceService {

    @Autowired
    Database data;

    public List<String> getListByType(String type) {
        return data.advice.get(type);
    }

}
 
