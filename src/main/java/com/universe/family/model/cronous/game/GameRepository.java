package com.universe.family.model.cronous.game;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface GameRepository extends JpaRepository<PersonalAccount,Integer> {
    List<PersonalAccount> findAll();
    PersonalAccount findByUserid(String user);

    @Transactional
    void deleteByUserid(String user);
}