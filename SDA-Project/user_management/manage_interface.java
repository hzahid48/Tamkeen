package user_management;

public interface manage_interface
{
	public void changepassword (String username, String old, String newp);
	public void updateinfo(String username, String address, int number);
}
