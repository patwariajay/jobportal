package com.jobportal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private String id;
	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Email is required")
	@Email(message = "Email is not valid")
	private String email;
	@NotBlank(message = "Password is required")
	@Pattern(
			regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$",
			message = "Password must be at least 8 characters long, include a digit, a lowercase letter, an uppercase letter, and a special character"
	)
	private String password;

	@NotNull(message = "Account type is required")
	private AccountType accountType;

}
