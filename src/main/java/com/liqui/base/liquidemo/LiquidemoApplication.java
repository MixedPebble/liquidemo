package com.liqui.base.liquidemo;

import liquibase.Liquibase;
import liquibase.database.DatabaseFactory;
import liquibase.exception.LiquibaseException;
import liquibase.ext.mongodb.database.MongoLiquibaseDatabase;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LiquidemoApplication {

    public static void main(String[] args) throws LiquibaseException {

        SpringApplication.run(LiquidemoApplication.class, args);
    }

    @Bean
    public void foo() throws LiquibaseException {
        MongoLiquibaseDatabase database = (MongoLiquibaseDatabase) DatabaseFactory.getInstance().openDatabase("mongodb://localhost:27017/liqui?serverSelectionTimeoutMS=5000&connectTimeoutMS=10000", null, null, null, null);
        Liquibase liquibase = new Liquibase("dbchangelog.xml", new ClassLoaderResourceAccessor(), database);
        liquibase.update("");
    }

}
