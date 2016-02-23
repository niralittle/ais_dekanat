package com.kma.ais_dekanat.security;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public final class TokenManager {

    private static final long EXPIRATION_TIME = TimeUnit.MINUTES.toMillis(30);
    private static final long WATCHER_JOB_PERIOD = TimeUnit.MINUTES.toMillis(10);

    private static final Map<String, Long> tokenMap = new ConcurrentHashMap<>();
    private static final Thread tokenExpirationWatcher = new Thread() {
        @Override
        public void run() {
            while (true) {
                tokenMap.entrySet().stream()
                        .filter(entry -> entry.getValue() - System.currentTimeMillis() <= EXPIRATION_TIME)
                        .forEach(tokenEntry -> tokenMap.remove(tokenEntry.getKey()));
                try {
                    sleep(WATCHER_JOB_PERIOD);
                } catch (InterruptedException e) {
                    System.out.println("!!! tokenExpirationWatcher was interrupted:");
                    e.printStackTrace();
                }
            }
        }
    };

    static {
        tokenExpirationWatcher.start();
    }

    public static boolean isValid(String token) {
        Long lastUsed = tokenMap.get(token);
        if (lastUsed == null) {
            return false;
        }
        if (lastUsed - System.currentTimeMillis() <= EXPIRATION_TIME) {
            tokenMap.remove(token);
            return false;
        }
        tokenMap.put(token, System.currentTimeMillis());
        return true;
    }

    public static String generate() {
        String newToken = UUID.randomUUID().toString();
        tokenMap.put(newToken, System.currentTimeMillis());
        return newToken;
    }

    private TokenManager() {}
}
