package me.student2026.model;

import java.util.Objects;

public class IpResponse {

    private String ip;

    public IpResponse() {
    }

    public IpResponse(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        IpResponse that = (IpResponse) o;
        return Objects.equals(ip, that.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ip);
    }

    @Override
    public String toString() {
        return "IpResponse{ip='" + ip + "'}";
    }
}
