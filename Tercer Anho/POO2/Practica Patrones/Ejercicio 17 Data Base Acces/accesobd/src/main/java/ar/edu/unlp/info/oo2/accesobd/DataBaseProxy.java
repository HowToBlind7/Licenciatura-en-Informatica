package ar.edu.unlp.info.oo2.accesobd;

import java.util.Collection;
import java.util.List;

public class DataBaseProxy implements DatabaseAccess {
	DatabaseRealAccess realDatabase;
	String password;
	boolean loged;
	
	public DataBaseProxy(DatabaseRealAccess realDatabase, String password) {
		super();
		this.realDatabase = realDatabase;
		this.password = password;
		this.loged = false;
	}

	public DataBaseProxy (DatabaseRealAccess realDatabase) {
		this.realDatabase = realDatabase;
	}

	@Override
	public Collection<String> getSearchResults(String queryString) {
		// TODO Auto-generated method stub
		if (this.loged) {
			this.realDatabase.getSearchResults(queryString);
		}
		return null;
	}

	@Override
	public int insertNewRow(List<String> rowData) {
		// TODO Auto-generated method stub
		if (this.loged) {
			this.realDatabase.insertNewRow(rowData);
		}
		throw new RuntimeException("You need to Log In");
	}
	
	public boolean logIn(String password) {
		if (this.password.equals(password)) {
			this.loged = true;
			return true;
		}
		throw new RuntimeException("Incorrect credentials");

	}
	
	public void logOut() {
		this.loged = false;
	}
}
