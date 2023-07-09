package com.profile.listener;

import com.profile.event.ProfileChangeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import org.springframework.core.env.ConfigurableEnvironment;


import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ProfileChangeListener {

    @Autowired
    private ConfigurableEnvironment environment;

    @EventListener
    public void handleProfileChange(ProfileChangeEvent event) {
        String newProfile = event.getNewProfile();
        environment.setActiveProfiles(newProfile);
        System.out.println("Profile changed to: " + newProfile);
        // Perform any additional actions based on the profile change
    }
}