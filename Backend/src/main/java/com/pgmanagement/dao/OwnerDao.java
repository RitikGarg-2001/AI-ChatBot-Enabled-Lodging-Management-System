package com.pgmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pgmanagement.entity.Owner;

@Repository
public interface OwnerDao extends JpaRepository<Owner, Integer> {

}
