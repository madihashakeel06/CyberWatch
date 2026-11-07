
package com.cyberwatch;

public class LoginEvent {
    private String username;
    private String ipAddress;
    private String status;

    public LoginEvent() {
    }

    public LoginEvent(String username, String ipAddress, String status) {
        this.username = username;
        this.ipAddress = ipAddress;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

