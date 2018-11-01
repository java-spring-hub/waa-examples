package com.eprogrammerz.examples.session.repository.impl;

import com.eprogrammerz.examples.session.data.Database;
import com.eprogrammerz.examples.session.repository.AdviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AdviceRepositoryImpl implements AdviceRepository {

    @Autowired
    Database data;

    public List<String> getListByType(String type) {
        return data.advice.get(type);
    }

}
 
