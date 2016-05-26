package com.rangers.jdbctemplate;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.rangers.jdbctemplate.model.Employee;
import com.rangers.jdbctemplate.model.EmployeeSerializer;
import com.rangers.jdbctemplate.model.PagedListSerializer;

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
  

  @Bean
  public Jackson2ObjectMapperBuilder objectMapperBuilder() {
      Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
      builder.serializerByType(List.class, new PagedListSerializer());
      builder.serializerByType(Employee.class, new EmployeeSerializer());
      return builder;
  }
  
}
