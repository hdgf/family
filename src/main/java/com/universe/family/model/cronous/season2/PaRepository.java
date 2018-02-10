package com.universe.family.model.cronous.season2;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface PaRepository extends JpaRepository<PersonalAccount,Integer> {
    List<PersonalAccount> findAll();
    PersonalAccount findByUserid(String user);

    @Transactional
    void deleteByUserid(String user);
}