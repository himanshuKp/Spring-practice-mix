package com.himanshu.weatherapi.realtime;

import com.ip2location.IP2Location;
import com.ip2location.IPResult;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class IP2LocationTest {
    private String DBPath = "ip2locdb/IP2LOCATION-LITE-DB3.BIN";

    @Test
    public void testIP2InvalidLocation() throws IOException {
        IP2Location ip2Location = new IP2Location();
        ip2Location.Open(DBPath);

        String ipAddress = "abc";
        IPResult ipResult = ip2Location.IPQuery(ipAddress);

        assert (ipResult != null);
        assert ipResult.getStatus().equalsIgnoreCase("INVALID_IP_ADDRESS");
        System.out.println(ipResult);
    }

    @Test
    public void testIP2ValidLocation() throws  IOException {
        IP2Location ip2Location = new IP2Location();
        ip2Location.Open(DBPath);

        String ipAddress = "103.48.198.141";
        IPResult ipResult = ip2Location.IPQuery(ipAddress);
        assert (ipResult != null);
        assert ipResult.getStatus().equalsIgnoreCase("ok");
        assert ipResult.getCity().equalsIgnoreCase("delhi");
        System.out.println(ipResult);
    }
}
