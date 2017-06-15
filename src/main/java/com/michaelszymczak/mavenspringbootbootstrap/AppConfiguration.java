package com.michaelszymczak.mavenspringbootbootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class AppConfiguration {


  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> System.out.println("Arguments passed: " + Stream.of(args).collect(Collectors.joining(", ")));
  }
}
