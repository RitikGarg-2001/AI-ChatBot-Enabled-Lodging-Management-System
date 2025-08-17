package com.pgmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pgmanagement.dto.CommonApiResponse;
import com.pgmanagement.dto.RegisterUserRequestDto;
import com.pgmanagement.dto.UserExtraDetailRequest;
import com.pgmanagement.dto.UserLoginRequest;
import com.pgmanagement.dto.UserLoginResponse;
import com.pgmanagement.dto.UserProfileDataUpdateRequest;
import com.pgmanagement.dto.UserResponseDto;
import com.pgmanagement.dto.UserWalletUpdateResponse;
import com.pgmanagement.entity.User;
import com.pgmanagement.pg.RazorPayPaymentResponse;
import com.pgmanagement.resource.UserResource;
import com.razorpay.RazorpayException;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private UserResource userResource;

	// RegisterUserRequestDto, we will set only email, password & role from UI
	@PostMapping("/admin/register")
	@Operation(summary = "Api to register Admin")
	public ResponseEntity<CommonApiResponse> registerAdmin(@RequestBody RegisterUserRequestDto request) {
		return userResource.registerAdmin(request);
	}

	// for guest and owner register
	@PostMapping("register")
	@Operation(summary = "Api to register owner or guest user")
	public ResponseEntity<CommonApiResponse> registerUser(@RequestBody RegisterUserRequestDto request) {
		return this.userResource.registerUser(request);
	}

	@PutMapping("profile/add")
	@Operation(summary = "Api to update the user profile")
	public ResponseEntity<CommonApiResponse> updateUserProfile(UserExtraDetailRequest request) {
		return this.userResource.updateUserProfile(request);
	}

	@PutMapping("profile/government-id/update")
	@Operation(summary = "Api to update the user profile")
	public ResponseEntity<CommonApiResponse> updateGovernmentIDProofImage(UserExtraDetailRequest request) {
		return this.userResource.updateGovernmentIdProof(request);
	}

	@PutMapping("profile/detail/update")
	@Operation(summary = "Api to update the user profile details")
	public ResponseEntity<CommonApiResponse> updateUserProfileDetail(
			@RequestBody UserProfileDataUpdateRequest request) {
		return this.userResource.updateUserProfileDetail(request);
	}

	@PostMapping("login")
	@Operation(summary = "Api to login any User")
	public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest userLoginRequest) {
		return userResource.login(userLoginRequest);
	}

	@GetMapping("/fetch/role-wise")
	@Operation(summary = "Api to get Users By Role")
	public ResponseEntity<UserResponseDto> fetchAllUsersByRole(@RequestParam("role") String role)
			throws JsonProcessingException {
		return userResource.getUsersByRole(role);
	}

	@DeleteMapping("owner/delete")
	@Operation(summary = "Api to delete the Owner and all it's properties")
	public ResponseEntity<CommonApiResponse> deleteGuide(@RequestParam("ownerId") Integer ownerId) {
		return userResource.deleteOwner(ownerId);
	}

	@GetMapping("/fetch/user-id")
	@Operation(summary = "Api to get User Detail By User Id")
	public ResponseEntity<UserResponseDto> fetchUserById(@RequestParam("userId") int userId) {
		return userResource.getUserById(userId);
	}

	@PutMapping("update/wallet")
	@Operation(summary = "Api to create the razor pay order")
	public ResponseEntity<UserWalletUpdateResponse> createRazorPayOrder(@RequestBody User user)
			throws RazorpayException {
		return userResource.createRazorPayOrder(user);
	}

	@PutMapping("razorpPay/response")
	@Operation(summary = "Api to update the user wallet based on razorpay response")
	public ResponseEntity<CommonApiResponse> updateUserWallet(@RequestBody RazorPayPaymentResponse razorPayResponse)
			throws RazorpayException {
		return userResource.handleRazorPayPaymentResponse(razorPayResponse);
	}

}
