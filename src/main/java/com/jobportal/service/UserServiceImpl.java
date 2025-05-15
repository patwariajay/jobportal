package com.jobportal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.dto.UserDto;
import com.jobportal.entity.User;
import com.jobportal.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto registerUser(UserDto userDto) {
		if (userRepository.existsByEmail(userDto.getEmail())) {
			throw new RuntimeException("Email already registered");
		}

		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		user = userRepository.save(user);

		UserDto savedDto = new UserDto();
		BeanUtils.copyProperties(user, savedDto);
		return savedDto;
	}

	
}
