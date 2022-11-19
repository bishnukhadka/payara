package com.acem.payaramicro.credentials.util;

import com.acem.payaramicro.credentials.DbCredentials;
import com.acem.payaramicro.exception.ExceptionHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class DbCredentialsFileImpl implements DbCredentials {

    private Map<String,String> configs = new HashMap<>();

    public DbCredentialsFileImpl() {
        ExceptionHandler.handle( () -> {
            File file = new File("resources\\db_credentials");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = bufferedReader.readLine()) != null){
                String[] configArray = line.split("=");

                String configKey = configArray[0];
                String configValue = configArray[1];

                configs.put(configKey,configValue);

            }
        });
        System.out.println(this);
    }

    @Override
    public String getIpAddress() {
        return configs.get("IPADDRESS");
    }

    @Override
    public String getPort() {
        return configs.get("PORT");
    }

    @Override
    public String getName() {
        return configs.get("NAME");
    }

    @Override
    public String getUserName() {
        return configs.get("USERNAME");
    }

    @Override
    public String getPassword() {
        return configs.get("PASSWORD");
    }

    @Override
    public String toString() {
        return configs.toString();
    }
}
