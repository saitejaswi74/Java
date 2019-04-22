package in.msitprogram.jntu.paypal.accounts;

public class PPRestrictedAccount extends PPAccount {
	private String parentEmail;
	private float withdrawLimit;

	public PPRestrictedAccount(Profile profile, String parentEmail, float withdrawLimit) {
		super(profile);
		this.parentEmail = parentEmail;
		this.withdrawLimit = withdrawLimit;
	}

	public PPRestrictedAccount(Profile profile) {
		super(profile);
		// TODO Auto-generated constructor stub
	}
	public String getParentEmail() {
		return parentEmail;
	}

	public void setParentEmail(String parentEmail) {
		this.parentEmail = parentEmail;
	}

	public float getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(float withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	

}
