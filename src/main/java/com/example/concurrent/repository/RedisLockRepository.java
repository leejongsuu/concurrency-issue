package com.example.concurrent.repository;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class RedisLockRepository {

    private final RedisTemplate<String, String> redisTempalate;

    public RedisLockRepository(RedisTemplate<String, String> redisTempalate) {
        this.redisTempalate = redisTempalate;
    }

    public Boolean lock(Long key) {
        return redisTempalate
                .opsForValue()
                .setIfAbsent(generateKey(key), "lock", Duration.ofMillis(3000));
    }

    public Boolean unlock(Long key) {
        return redisTempalate.delete(generateKey(key));
    }

    private String generateKey(Long key) {
        return key.toString();
    }
}
