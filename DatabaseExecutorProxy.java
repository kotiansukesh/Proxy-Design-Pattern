class DatabaseExecutorProxy implements DatabaseExecutor {
	Boolean isAdmin = Boolean.FALSE;
	DatabaseExecutorImpl dbExecutor;

	public DatabaseExecutorProxy(String name, String password) {
		if(name == "Admin" && password == "Admin@123") {
			isAdmin = Boolean.TRUE;		
		}
		dbExecutor = new DatabaseExecutorImpl();
	}

	@Override
	public void executeDatabase(String query) throws Exception {
		if(isAdmin) {
			dbExecutor.executeDatabase(query);
		} else {
			if(query.equals("DELETE")) {
				throw new Exception("Delete not allowed for non-admin user");
			} else {
				dbExecutor.executeDatabase(query);
			}
		}
	}
	
}