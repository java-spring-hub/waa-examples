package com.eprogrammerz.examples.jpa.service;

import com.eprogrammerz.examples.jpa.domain.Phone;

import java.util.List;

public interface PhoneService {

    public List<Phone> getAll();

    public Phone save(Phone phone);


}
 
