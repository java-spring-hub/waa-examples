package com.eprogrammerz.examples.springmvc.data;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestDataImpl implements DataFacade {

    private static final Database data = new Database();

    public String findPassword(String name) {
        String expectedPassword = data.getPassword(name);
        return expectedPassword;
    }

    public List<String> getAdvice(String roast) {
        return data.getAdvice(roast);
    }
}
