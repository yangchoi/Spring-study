package user.bean;


import org.springframework.context.annotation.ComponentScan;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ComponentScan("user.conf")
public class UserDTO {
	private String name;
	private String id;  
	private String pwd;
	
}
