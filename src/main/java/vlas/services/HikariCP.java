package vlas.services;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public  class HikariCP {
    static ConfigParser cp = new ConfigParser("C:/Users/kabakou-u/Desktop/JAVA_PROJECTS/JDBC/src/main/resources/config.properties");

    private static String user = cp.getProperty("db.user");
    private static String url =cp.getProperty("db.url");
    private static String password = cp.getProperty("db.password");


    private static  HikariDataSource dataSource = null;
     static   {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);
        config.addDataSourceProperty("minimumIdle", "5");
        config.addDataSourceProperty("maximumPoolSize", "25");
         dataSource = new HikariDataSource(config);
    }
    public static HikariDataSource getDataSource(){
        return dataSource;
    }
}