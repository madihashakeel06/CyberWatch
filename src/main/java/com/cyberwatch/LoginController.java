
package com.cyberwatch;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final List<LoginEvent> events = new ArrayList<>();

    public LoginController() {
        events.add(new LoginEvent("admin", "192.168.1.10", "SUCCESS"));
        events.add(new LoginEvent("user1", "192.168.1.20", "FAILED"));
        events.add(new LoginEvent("admin", "192.168.1.30", "FAILED"));
    }

    @GetMapping("/events")
    public List<LoginEvent> getEvents() {
        return events;
    }

    @PostMapping("/events")
    public LoginEvent addEvent(@RequestBody LoginEvent event) {
        events.add(event);
        return event;
    }

    @GetMapping("/alerts")
    public List<LoginEvent> getAlerts() {
        return events.stream()
                .filter(event -> event.getStatus().equalsIgnoreCase("FAILED"))
                .toList();
    }
}
