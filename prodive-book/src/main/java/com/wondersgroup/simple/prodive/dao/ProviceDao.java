package com.wondersgroup.simple.prodive.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wondersgroup.simple.prodive.entity.User;
@Repository
public interface ProviceDao extends JpaRepository<User, Long> {

}
