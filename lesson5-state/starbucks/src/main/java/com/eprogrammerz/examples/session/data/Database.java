package com.eprogrammerz.examples.session.data;

import com.eprogrammerz.examples.session.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Database {
    public HashMap<String, User> users = new HashMap<String, User>();
    public HashMap<String, List<String>> advice = new HashMap<String, List<String>>();

    {
        users.put("Dave", new User("Dave", "111"));
        users.put("Steve", new User("Steve", "222"));
        users.put("Ralph", new User("Ralph", "333"));
        ArrayList<String> darkList = new ArrayList<String>();
        darkList.add("Sumatra");
        darkList.add("Verona");
        darkList.add("French Roast");
        advice.put("dark", darkList);
        ArrayList<String> medList = new ArrayList<String>();
        medList.add("Breakfast Blend");
        medList.add("Colombia");
        medList.add("Yukon");
        medList.add("Pike Place");
        medList.add("House Blend");
        advice.put("medium", medList);
        ArrayList<String> lightList = new ArrayList<String>();
        lightList.add("Willow");
        lightList.add("Aria");
        lightList.add("Bright Sky");
        lightList.add("Veranda");
        advice.put("light", lightList);
    }


}
