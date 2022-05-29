package com.thanh.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thanh.demo.model.Basic;

@Repository
public interface BasicRepository extends JpaRepository<Basic, Integer>
{

}
