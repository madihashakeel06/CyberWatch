
package com.cyberwatch;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CyberwatchApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void loginEventCanBeCreated() {
        LoginEvent event = new LoginEvent(
                "admin", "192.168.1.10", "SUCCESS");

        assertEquals("admin", event.getUsername());
        assertEquals("192.168.1.10", event.getIpAddress());
        assertEquals("SUCCESS", event.getStatus());
    }

    @Test
    void failedLoginIsDetected() {
        LoginEvent event = new LoginEvent(
                "hacker", "10.0.0.99", "FAILED");

        assertEquals("FAILED", event.getStatus());
    }
}
