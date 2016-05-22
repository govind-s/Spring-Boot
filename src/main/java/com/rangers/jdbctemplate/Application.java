package com.rangers.jdbctemplate;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }


  @Bean
  public DataSource dataSource() {
    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    EmbeddedDatabase db =
        builder.setType(EmbeddedDatabaseType.H2).setSeparator(";;")
        .addScript("database/create-db.sql")
        .addScript("database/insert-data.sql")
        .build();
    return db;
  }
  
/*
  @Bean
  public Jackson2ObjectMapperBuilder objectMapperBuilder() {
      Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
      builder.serializerByType(PagedList.class, new PagedListSerializer());
      builder.serializerByType(Employee.class, new EmployeeSerializer());
      return builder;
  }*/
  
}
