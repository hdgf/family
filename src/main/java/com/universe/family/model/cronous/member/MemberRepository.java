package com.universe.family.model.cronous.member;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Integer> {
    List<Member> findAll();
    Member findByUserid(String user);

    @Transactional
    void deleteByUserid(String user);
}
