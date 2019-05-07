package com.ivanp.globalcampo.model;

import java.sql.*;

public class Acceso {
	Database db = new Database();
	String sql="";
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public Acceso() {
		
		
	}
	
	public int validar(String usuario, String contra) throws ClassNotFoundException {
		
		int nivel=0;
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(),db.getUser(),db.getContra());
			sql="SELECT nivel FROM users WHERE username= '"+usuario+"' and pass='"+contra+"'";  
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				nivel=rs.getInt(1);				
			}
			
			con.close();
			rs.close();
			return nivel;
		} catch (SQLException e) {
			return nivel;
		}
		
	}
	
}
