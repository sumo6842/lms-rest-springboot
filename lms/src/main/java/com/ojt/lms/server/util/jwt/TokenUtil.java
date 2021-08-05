package com.ojt.lms.server.util.jwt;

import java.util.Map;

public interface TokenUtil {
    String permanent(Map<String, String> attributes);

    String expiring(Map<String, String> attributes);

    Map<String, String> untrusted(String token);

    Map<String, String> verify(String token);

}
