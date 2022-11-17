package com.acem.payara.credentials.util;

import com.acem.payara.credentials.DbCredentials;
import io.github.cdimascio.dotenv.Dotenv;

public class DbCredentialsDotEnvImpl implements DbCredentials {

    private Dotenv dotenv;


    public DbCredentialsDotEnvImpl() {
        dotenv = Dotenv.load();
        System.out.println("dotenv: " + "ipaddress:" + dotenv.get("IPADDRESS") + " PORT:" + dotenv.get("PORT")+ " USERNAME:" + dotenv.get("USER_NAME") + " PASSWORD:" + dotenv.get("PASSWORD"));
    }

    @Override
    public String getIpAddress() {
        return dotenv.get("IPADDRESS");
    }

    @Override
    public String getPort() {
        return dotenv.get("PORT");
    }

    @Override
    public String getName() {
        return dotenv.get("NAME");
    }

    @Override
    public String getUserName() {
        return dotenv.get("USER_NAME");
    }

    @Override
    public String getPassword() {
        return dotenv.get("PASSWORD");
    }

}
