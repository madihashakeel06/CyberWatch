
package com.cyberwatch;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final LoginEventStore eventStore;

    public LoginController(LoginEventStore eventStore) {
        this.eventStore = eventStore;
    }

    @GetMapping("/events")
    public List<LoginEvent> getEvents() {
        return eventStore.getEvents();
    }

    @PostMapping("/events")
    public LoginEvent addEvent(@RequestBody LoginEvent event) {
        eventStore.addEvent(event);
        return event;
    }

    @GetMapping("/alerts")
    public List<String> getAlerts() {
        List<String> alerts = new java.util.ArrayList<>();

        for (LoginEvent event : eventStore.getEvents()) {
            long failedCount = eventStore.getEvents().stream()
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
