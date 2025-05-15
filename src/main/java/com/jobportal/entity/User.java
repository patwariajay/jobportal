package com.jobportal.entity;

import com.jobportal.dto.UserDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import com.jobportal.dto.AccountType;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="users")
public class User {

	@Id
	private Long id;
	private String name;
	@Indexed(unique = true)
	private String email;
	private String password;
	private AccountType accountType;

	public UserDto toDto() {
		return new UserDto(this.id,this.name,this.email,this.password,this.accountType);
	}
}
