package com.eprogrammerz.examples.mvc.framework;

import com.eprogrammerz.examples.mvc.framework.annotation.ProcessAnnotations;
import com.eprogrammerz.examples.mvc.framework.controller.Controller;
import com.eprogrammerz.examples.mvc.framework.factory.ControllerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;

public class ConfigureServlet {

    public void loadControllers(String configFile, Map<String, Controller> controllers, Map<String, Controller> dispatchers, Map<String, String> dispatcherMethods) {

        SequencedProperties prop = new SequencedProperties();
        InputStream input = null;
        try {

            // Use ClassLoader to search all of classpath
            input = getClass().getClassLoader().getResourceAsStream(configFile);
            if (input == null) {
                System.out.println("Unable to find " + configFile);
                return;
            }

            //load a properties file from class path
            prop.load(input);

            // Enumerate through Controllers, Then Dispatchers,  then DispatcherMethods...
            Controller controller = null;

            String type = null;
            Enumeration enumeration = prop.keys();
            while (enumeration.hasMoreElements()) {
                String key = (String) enumeration.nextElement();

                if (prop.get(key).equals("Start")) {
                    type = key;
                    continue;
                }

                if (type.equals("Controllers")) {
                    controller = ControllerFactory.getInstance((String) prop.get(key));
                    controllers.put(key, controller);
                }
/*		    		    else if (type.equals("Dispatchers")) {
		    		    	controller = controllers.get((String)prop.get(key));
		    		    	dispatchers.put(key, controller);
		    		    }
		    		    else if (type.equals("Methods")) {
	 	    		    	String temp = (String) prop.get(key);
		    		    	key = key.substring(1);
		    		    	dispatcherMethods.put(key, temp);
		    		    }
*/
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {

            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        // Process Annotations
        ProcessAnnotations.handleAnnotations(controllers, dispatchers, dispatcherMethods);

        return;
    }


}