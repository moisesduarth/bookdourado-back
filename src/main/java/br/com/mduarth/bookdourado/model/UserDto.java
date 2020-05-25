package br.com.mduarth.bookdourado.model;

import lombok.Data;

@Data
public class UserDto {

	private String username;
    private String email;
    private String token;
    
    public UserDto(String email2, String username2, String token2) {
		this.username = username2;
		this.email = email2;
		this.token = token2;
	}
}
