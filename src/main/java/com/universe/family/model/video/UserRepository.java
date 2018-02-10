package com.universe.family.model.video;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * User类的CRUD操作
 * @see User
 * @author ScienJus
 * @date 2015/7/10.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    List<User> findAll();
    User save(User user);
}
