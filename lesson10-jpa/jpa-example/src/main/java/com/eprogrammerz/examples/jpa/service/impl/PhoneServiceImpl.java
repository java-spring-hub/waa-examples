package com.eprogrammerz.examples.jpa.service.impl;

import com.eprogrammerz.examples.jpa.domain.Phone;
import com.eprogrammerz.examples.jpa.repository.PhoneRepository;
import com.eprogrammerz.examples.jpa.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    PhoneRepository phoneRepository;

    public List<Phone> getAll() {
        return (List<Phone>) phoneRepository.findAll();
    }

    public Phone save(Phone phone) {
        return phoneRepository.save(phone);

    }


}
 
