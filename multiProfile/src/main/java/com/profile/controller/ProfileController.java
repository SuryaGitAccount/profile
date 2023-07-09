package com.profile.controller;

import com.profile.event.ProfileChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Autowired
    private Environment environment;
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @PostMapping("/profile")
    public void updateProfile(@RequestBody String profile) {
        ConfigurableEnvironment configurableEnvironment = (ConfigurableEnvironment) environment;
        configurableEnvironment.setActiveProfiles(profile);

        eventPublisher.publishEvent(new ProfileChangeEvent(this, profile));
    }
}

