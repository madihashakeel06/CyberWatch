
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
public List<String> getAlerts() {
    List<String> alerts = new ArrayList<>();

    for (LoginEvent event : events) {
        long failedCount = events.stream()
    .filter(e -> e.getIpAddress().equalsIgnoreCase(event.getIpAddress()))
    .filter(e -> e.getStatus().equalsIgnoreCase("FAILED"))
    .count();

        if (failedCount >= 3) {
            String alert = "BRUTE FORCE DETECTED: IP "
                + event.getIpAddress()
                + " has " + failedCount + " failed attempts";

            if (!alerts.contains(alert)) {
                alerts.add(alert);
            }
        }
    }

    return alerts;
}

}
