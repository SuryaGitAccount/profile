package com.profile;

import com.profile.config.ProfileConfig;
import com.profile.event.ProfileChangeEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootApplication
@ComponentScan("com.profile.listener")
public class MultiProfileMainApplication implements CommandLineRunner {

	public static void main(String[] args) {
		ProfileConfig profileConfig = new ProfileConfig();
		System.out.println(profileConfig.getProf());
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, profileConfig.getProf());
		SpringApplication.run(MultiProfileMainApplication.class, args);
	}

	@Bean
	public ProfileConfig profileConfig(){
		return new ProfileConfig();
	}

	@Value("${language}")
	private String lang;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(profileConfig().getProf());
		System.out.println(lang);
	}
}
