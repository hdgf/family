package com.universe.family.repository.impl;

import com.universe.family.model.RedisUser;
import com.universe.family.repository.RedisUserRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RedisUserRepositoryImpl implements RedisUserRepository {

    private RedisTemplate<String, RedisUser> redisTemplate;

    private HashOperations hashOperations;


    public RedisUserRepositoryImpl(RedisTemplate<String, RedisUser> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(RedisUser user) {
        hashOperations.put("USER", user.getId(), user);
    }

    @Override
    public Map<String, RedisUser> findAll() {
        return hashOperations.entries("USER");
    }

    @Override
    public RedisUser findById(String id) {
        return (RedisUser)hashOperations.get("USER", id);
    }

    @Override
    public void update(RedisUser user) {
        save(user);
    }

    @Override
    public void delete(String id) {

        hashOperations.delete("USER", id);
    }
}
