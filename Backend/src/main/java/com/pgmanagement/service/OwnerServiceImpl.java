package com.pgmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgmanagement.dao.OwnerDao;
import com.pgmanagement.entity.Owner;

@Service
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	private OwnerDao ownerDao;

	@Override
	public Owner addOwner(Owner owner) {
		// TODO Auto-generated method stub
		return ownerDao.save(owner);
	}

	@Override
	public Owner updateOwner(Owner owner) {
		// TODO Auto-generated method stub
		return ownerDao.save(owner);
	}

}
