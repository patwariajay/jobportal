package com.jobportal.service;

import com.jobportal.dto.LoginDto;
import com.jobportal.utility.SequenceGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobportal.dto.UserDto;
import com.jobportal.entity.User;
import com.jobportal.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SequenceGeneratorService sequenceGenerator;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDto registerUser(UserDto userDto) {
		Optional<User> existingUser = userRepository.findByEmail(userDto.getEmail());

		if (existingUser.isPresent()) {
			throw new RuntimeException("User already exists with email: " + userDto.getEmail());
		}

		userDto.setId(sequenceGenerator.generateSequence("user_sequence") + 999); // start from 1000
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		User user = userDto.toEntity();
		user = userRepository.save(user);
		return user.toDto();
	}

	@Override
	public UserDto loginUser(LoginDto loginDto) {
		User user = userRepository.findByEmail(loginDto.getEmail())
				.orElseThrow(() -> new RuntimeException("Invalid email or password"));

		if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
			throw new RuntimeException("Invalid email or password");
		}

		return user.toDto();
	}


}
