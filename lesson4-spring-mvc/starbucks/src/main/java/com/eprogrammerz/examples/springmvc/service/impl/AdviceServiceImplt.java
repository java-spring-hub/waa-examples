package com.eprogrammerz.examples.springmvc.service.impl;

import com.eprogrammerz.examples.springmvc.data.DataFacade;
import com.eprogrammerz.examples.springmvc.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdviceServiceImplt implements AdviceService {
    @Autowired
    DataFacade dataFacade;

    @Override
    public List<String> getAdvice(String roast) {
        return dataFacade.getAdvice(roast);
    }

}
