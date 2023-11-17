package de.olivergeisel.experimenteundtests.user;

import org.salespointframework.core.DataInitializer;
import org.salespointframework.useraccount.Password;
import org.salespointframework.useraccount.Role;
import org.salespointframework.useraccount.UserAccountManagement;
import org.springframework.stereotype.Component;

@Component
public class UserInitializer implements DataInitializer {


	private final UserAccountManagement userAccountManagement;
	private final UserRepository        userRepository;

	public UserInitializer(UserAccountManagement userAccountManagement, UserRepository userRepository) {
		this.userAccountManagement = userAccountManagement;
		this.userRepository = userRepository;
	}

	/**
	 * Called on application startup to trigger data initialization. Will run inside a transaction.
	 */
	@Override
	public void initialize() {
		var password = Password.UnencryptedPassword.of("12345");
		var account = userAccountManagement.create("admin", password, Role.of("ADMIN"));
		var user = new User(account, "neu");
		userRepository.save(user);

		account = userAccountManagement.create("user", password, Role.of("USER"));
		user = new User(account, "neu");
		userRepository.save(user);

	}
}
