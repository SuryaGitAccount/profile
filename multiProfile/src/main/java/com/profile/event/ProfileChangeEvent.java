package com.profile.event;

import org.springframework.context.ApplicationEvent;



public class ProfileChangeEvent extends ApplicationEvent {

    private final String newProfile;

    public ProfileChangeEvent(Object source, String newProfile) {
        super(source);
        this.newProfile = newProfile;
    }

    public String getNewProfile() {
        return newProfile;
    }
}

