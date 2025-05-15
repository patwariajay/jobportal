package com.jobportal.entity;

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
	private String id;
	private String name;
	@Indexed(unique = true)
	private String email;
	private String password;
	private AccountType accountType;
}
