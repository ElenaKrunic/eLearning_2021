package ftn.tseo.eEducation.model;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

	public UserDetails toUserDetails(User user) {
		return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
				.password(user.getPassword())
				.roles(user.getUserAuthorities().toArray(String[] :: new))
				.build();
	}
}
