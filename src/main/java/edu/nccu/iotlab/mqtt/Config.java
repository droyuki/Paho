package edu.nccu.iotlab.mqtt;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by WeiChen on 2016/2/6.
 */
public class Config {
    private String broker;
    public Config(){
        //Read config.properties
        Properties prop = new Properties();
        try{
            String fileName = "config.properties";
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            prop.load(is);
            broker = prop.getProperty("broker");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public String getBroker(){
        return broker;
    }
}
