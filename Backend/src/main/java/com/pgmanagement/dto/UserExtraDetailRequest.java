package com.pgmanagement.dto;

import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import com.pgmanagement.entity.Guest;
import com.pgmanagement.entity.Owner;

import lombok.Data;

@Data
public class UserExtraDetailRequest {

	private int id;

	private String fullName;

	private String age;

	private String profession;

	private MultipartFile govermentIdImageProof;

	private String permanentAddress;

	private Integer userId;

	public static Guest toGuestEntity(UserExtraDetailRequest request) {
		Guest guest = new Guest();
		BeanUtils.copyProperties(request, guest, "govermentIdImageProof", "userId");
		return guest;
	}

	public static Owner toOwnerEntity(UserExtraDetailRequest request) {
		Owner owner = new Owner();
		BeanUtils.copyProperties(request, owner, "govermentIdImageProof", "userId");
		return owner;
	}

}
