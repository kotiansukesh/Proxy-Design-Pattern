/*
Properties
	• Structural design pattern
	• Used when you want to control access. i.e. in Databases, you would want to delete query available only for certain users like admin.

Implementation
	• In general, we have class which is executing interface executor method, which is executing all commands.
	• To control this, we add a proxy class which implement the same interface and write the conditions for admin user before proceeding to actual executor
*/
class Main {
  public static void main(String[] args) {
	  try {
		DatabaseExecutor dbExecutor = new DatabaseExecutorProxy("NonAdmin", "Admin@123");
		dbExecutor.executeDatabase("DELETE");

		dbExecutor = new DatabaseExecutorProxy("Admin", "Admin@123");
		dbExecutor.executeDatabase("DELETE");
	  } catch(Exception e) {
		  e.printStackTrace();
	  }
  }
}