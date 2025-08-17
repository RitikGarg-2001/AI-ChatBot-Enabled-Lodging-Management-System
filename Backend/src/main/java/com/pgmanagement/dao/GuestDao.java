package com.pgmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pgmanagement.entity.Guest;

@Repository
public interface GuestDao extends JpaRepository<Guest, Integer> {

}
