package com.jobportal.service;

import com.jobportal.dto.LoginDto;
import com.jobportal.dto.UserDto;

public interface UserService {

	public UserDto registerUser(UserDto userDto);

	public UserDto loginUser(LoginDto loginDto);
}
