package com.himanshu.weatherapi.realtime;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtility {
    private static final Logger logger = LoggerFactory.getLogger(CommonUtility.class);

    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteHost();
        }
        logger.info("getIpAddress: {}", ip);
        return ip;
    }
}
