package agent;

public class AgentDetails {
	private String agent_emailId;
	private String password;
	private String role="admin";
	private String ZID_Approval="false";
	public String getAgent_emailId() {
		return agent_emailId;
	}
	public void setAgent_emailId(String agent_emailId) {
		this.agent_emailId = agent_emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getZID_Approval() {
		return ZID_Approval;
	}
	public void setZID_Approval(String zID_Approval) {
		ZID_Approval = zID_Approval;
	}
	@Override
	public String toString() {
		return "AgentDetails [agent_emailId=" + agent_emailId + ", password=" + password + ", role=" + role
				+ ", ZID_Approval=" + ZID_Approval + "]";
	}
	
	
}
