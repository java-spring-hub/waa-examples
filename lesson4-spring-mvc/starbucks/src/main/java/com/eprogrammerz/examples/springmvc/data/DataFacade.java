package com.eprogrammerz.examples.springmvc.data;

import java.util.List;

public interface DataFacade {
    String findPassword(String name);

    List<String> getAdvice(String roast);
}
