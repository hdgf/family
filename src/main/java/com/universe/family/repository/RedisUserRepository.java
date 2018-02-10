package com.universe.family.repository;

import com.universe.family.model.RedisUser;

import java.util.Map;

public interface RedisUserRepository {

    void save(RedisUser user);
    Map<String, RedisUser> findAll();
    RedisUser findById(String id);
    void update(RedisUser user);
    void delete(String id);
}
