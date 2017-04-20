package entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserInfo {

	@NotNull
	@Size(min = 5, max = 10, message = "{Size.error}")
	private String account;
	@NotNull
	@Size(min = 5, max = 10)
	private String password;

	public UserInfo() {

	}

	public UserInfo(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
