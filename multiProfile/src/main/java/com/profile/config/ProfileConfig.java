package com.profile.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Getter
@Setter
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class ProfileConfig {
//
//    @Value("${spring.profiles.active}")
//    private String profileName;

    private String prof = "qa";

    // Add getters and setters for profileName
}

