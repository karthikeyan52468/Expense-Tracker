package Model;

public class Details {

	String  name;
	String  email;
	String  password;
	String role;
	private static Details obj=null;
    public static Details getInstance() {
		
    	if(obj==null)
    	{
    		obj=new Details();
    		return obj;
    	}
    	return obj;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
    
    
	
}
