
package com.cyberwatch;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class LoginEventStore {

    private final List<LoginEvent> events = new ArrayList<>();

    public LoginEventStore() {
        events.add(new LoginEvent("admin", "192.168.1.10", "SUCCESS"));
        events.add(new LoginEvent("user1", "192.168.1.20", "FAILED"));
        events.add(new LoginEvent("admin", "192.168.1.30", "FAILED"));
    }

    public List<LoginEvent> getEvents() {
        return events;
    }

    public void addEvent(LoginEvent event) {
        events.add(event);
    }
}

