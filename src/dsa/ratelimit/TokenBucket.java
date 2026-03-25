package dsa.ratelimit;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class TokenBucket {
    private final int capacity;
    private final int refillRate; // tokens per second

    private double tokens;
    private long lastRefillTime;

    public TokenBucket(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = capacity;
        this.lastRefillTime = System.nanoTime();
    }

    // synchronized for thread safety
    public synchronized boolean allowRequest() {
        refill();

        if (tokens >= 1) {
            tokens -= 1;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.nanoTime();
        double tokensToAdd = (now - lastRefillTime) / 1e9 * refillRate;

        if (tokensToAdd > 0) {
            tokens = Math.min(capacity, tokens + tokensToAdd);
            lastRefillTime = now;
        }
    }
}

class RateLimiter {
    private final ConcurrentHashMap<String, TokenBucket> userBuckets = new ConcurrentHashMap<>();

    private final int capacity;
    private final int refillRate;

    public RateLimiter(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
    }

    public boolean allow(String userId) {
        userBuckets.putIfAbsent(userId, new TokenBucket(capacity, refillRate));
        return userBuckets.get(userId).allowRequest();
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {
        RateLimiter limiter = new RateLimiter(5, 2); // 5 tokens max, 2/sec refill

        String user = "user1";

        for (int i = 0; i < 10; i++) {
            boolean allowed = limiter.allow(user);
            System.out.println("Request " + i + ": " + allowed);
            Thread.sleep(300);
        }
    }
}