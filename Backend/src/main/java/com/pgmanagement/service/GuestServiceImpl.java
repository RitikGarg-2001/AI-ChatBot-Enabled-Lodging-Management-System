package com.pgmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgmanagement.dao.GuestDao;
import com.pgmanagement.entity.Guest;

@Service
public class GuestServiceImpl implements GuestService {

	@Autowired
	private GuestDao guestDao;

	@Override
	public Guest addGuest(Guest guest) {
		// TODO Auto-generated method stub
		return guestDao.save(guest);
	}

	@Override
	public Guest updateGuest(Guest guest) {
		// TODO Auto-generated method stub
		return guestDao.save(guest);
	}

}
