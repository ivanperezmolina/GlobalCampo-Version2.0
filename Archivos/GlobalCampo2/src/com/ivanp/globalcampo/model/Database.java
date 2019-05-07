package com.ivanp.globalcampo.model;

public class Database {
	
	private String url;
	private String user;
	private String contra;
	private String driver;
	
	
	public Database() {
		this.url = "jdbc:mysql://localhost:3306/globalcampo";
		this.user = "root";
		this.contra = "";
		this.driver = "com.mysql.jdbc.Driver";
	}


	/**
	 * @return the url
	 */
	public final String getUrl() {
		return url;
	}




	/**
	 * @return the user
	 */
	public final String getUser() {
		return user;
	}





	/**
	 * @return the contra
	 */
	public final String getContra() {
		return contra;
	}




	/**
	 * @return the driver
	 */
	public final String getDriver() {
		return driver;
	}


	
	
	
	
	
	

}
