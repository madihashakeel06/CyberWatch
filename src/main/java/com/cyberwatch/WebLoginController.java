
package com.cyberwatch;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebLoginController {

    private final LoginEventStore eventStore;

    public WebLoginController(LoginEventStore eventStore) {
        this.eventStore = eventStore;
    }

    @GetMapping("/")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(
            @RequestParam String username,
            @RequestParam String password,
            HttpServletRequest request,
            RedirectAttributes redirectAttributes) {

        String ipAddress = request.getRemoteAddr();

        boolean valid = username.equals("admin")
                && password.equals("admin123");

        String status = valid ? "SUCCESS" : "FAILED";

        eventStore.addEvent(new LoginEvent(username, ipAddress, status));

        if (valid) {
            return "redirect:/dashboard";
        }

        redirectAttributes.addFlashAttribute(
                "error", "Invalid username or password!");

        return "redirect:/";
    }
}

