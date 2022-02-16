package com.userinputvalidation.dto;

import lombok.Data;
import javax.validation.constraints.Pattern;

@Data
public class User {
//	@Pattern(regexp = "^(?=.[a-z])(?=.[A-Z])(?=\\S+$)$")
	private String data;
	
}
