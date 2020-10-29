class DatabaseExecutorImpl implements DatabaseExecutor {

	@Override
	public void executeDatabase (String query) throws Exception {
		System.out.println("Execute query: " + query);
	}
}