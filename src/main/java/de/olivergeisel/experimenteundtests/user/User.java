package de.olivergeisel.experimenteundtests.user;


import jakarta.persistence.*;
import org.salespointframework.useraccount.UserAccount;

import java.util.UUID;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", nullable = false)
	private UUID id;

	@OneToOne(optional = false, cascade = CascadeType.ALL, orphanRemoval = true)
	private UserAccount userAccount;
	private String      status;

	public User(UserAccount userAccount, String status) {
		this.userAccount = userAccount;
		this.status = status;
	}

	protected User() {

	}

	//region setter/getter
	public UserAccount getUserAccount() {
		return userAccount;
	}

	public UUID getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
//endregion

}
