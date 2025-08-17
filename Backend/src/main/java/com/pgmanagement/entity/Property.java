package com.pgmanagement.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String description;

	private String address;

	private String image;

	@OneToMany(mappedBy = "property", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<FacilityDetail> facilities = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private User owner;

	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;

	@OneToMany(mappedBy = "property", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<PropertyRoomDetail> rooms = new ArrayList<>();

	private String status;

}
