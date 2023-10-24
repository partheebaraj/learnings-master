package com.learning;


import java.util.Optional;
import java.util.Properties;

public class LearningOptional {



    public static void main(String[] args) {

        System.out.println(readPropertyUsingOptional(getProperties(),"a"));
        System.out.println(readPropertyUsingOptional(getProperties(),"b"));

        System.out.println(readPropertyUsingOptional(getProperties(),"c"));

        System.out.println(readPropertyUsingOptional(getProperties(),"d"));

        System.out.println(readPropertyUsingOptional(getProperties(),"e"));


    }


    static Properties getProperties() {
        Properties properties =new Properties();
        properties.setProperty("a","5");
        properties.setProperty("b","true");
        properties.setProperty("c","-1");
        return properties;
    }

    static int readProperty(Properties properties,String property){

        String value = properties.getProperty(property);
        try {
            if (Integer.parseInt(value) > 0) {
                return Integer.parseInt(value);
            }
        }catch (NumberFormatException e){
            return 0;
        }
        return 0;
    }

    static int readPropertyUsingOptional(Properties properties,String property){

        return Optional.ofNullable(properties.getProperty(property))
                .flatMap(LearningOptional::stringToInteger)
                .filter(e->e>0)
                .orElse(0);



    }

    public static Optional<Integer> stringToInteger(String str) {
        try {
            return Optional.of(Integer.parseInt(str));
        } catch (NumberFormatException ex) {
            return Optional.empty();
        }
    }

}
