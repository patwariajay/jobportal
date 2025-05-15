package com.jobportal.service;

import com.jobportal.utility.SequenceGeneratorService;
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

	@Autowired
	private SequenceGeneratorService sequenceGenerator;

	@Override
	public UserDto registerUser(UserDto userDto) {
		userDto.setId(sequenceGenerator.generateSequence("user_sequence") + 999); // start from 1000
		User user = userDto.toEntity();
		user = userRepository.save(user);
		return user.toDto();
	}

	
}
