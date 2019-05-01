package com.ivanp.globalcampo.dao;

import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ivanp.globalcampo.model.*;


public class RecolectaDAO {

	private Conexion con;
	private Connection connection;

	public RecolectaDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// insertar recolecta
	public boolean insertar(Recolecta recolecta) throws SQLException {
		
		String sql = "INSERT INTO recolecta (FecRec, KilRec, TraCul, DNIPerRec, DesRec,CodCul) VALUES (?, ?, ?,?,?,?)";
		con.conectar();
		
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setDate(1, new Date(recolecta.getFecRec().getTime()));
	
		statement.setInt(2, recolecta.getKilRec());
		statement.setInt(3, recolecta.getTraCul());
		statement.setString(4, recolecta.getDniPerRec());
		statement.setString(5, recolecta.getDesRec());
		statement.setInt(6, recolecta.getCodCul());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todas las recolectas
	public List<Recolecta> listarRecolecta() throws SQLException {

		List<Recolecta> listarRecolecta = new ArrayList<Recolecta>();
		String sql = "SELECT * FROM recolecta r JOIN cultivo c ON r.CodCul=c.CodCul ";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int CodRec = resulSet.getInt("CodRec");
			Date FecRecSQL = resulSet.getDate("FecRec");
			java.util.Date FecRec = new java.util.Date(FecRecSQL.getTime());
			int KilRec = resulSet.getInt("KilRec");
			int TraCul = resulSet.getInt("TraCul");
			String DNIPerRec = resulSet.getString("DNIPerRec");
			String DesRec = resulSet.getString("DesRec");
			int CodCul = resulSet.getInt("CodCul");
			String NomCul = resulSet.getString("NomCul");
			
			Recolecta recolecta = new Recolecta(CodRec, FecRec, KilRec, TraCul, DNIPerRec,DesRec,CodCul,NomCul);
			listarRecolecta.add(recolecta);
		}
		con.desconectar();
		return listarRecolecta;
	}

	//Coger datos de la tabla cultivos
	public List<Cultivo> listarCultivo() throws SQLException {

		List<Cultivo> listarCultivo = new ArrayList<Cultivo>();
		String sql = "SELECT CodCul,NomCul FROM cultivo";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int CodCul = resulSet.getInt("CodCul");
			String NomCul = resulSet.getString("NomCul");
			String DesCul = resulSet.getString("DesCul");
			String RegCul = resulSet.getString("RegCul");
			String CopeCul = resulSet.getString("CopeCul");
			
			Cultivo cultivo = new Cultivo(CodCul, NomCul, DesCul, RegCul, CopeCul);
			listarCultivo.add(cultivo);
		}
		con.desconectar();
		return listarCultivo;
	}
	
	// obtener por id
	public Recolecta obtenerPorId(int CodRec) throws SQLException {
		Recolecta recolecta = null;

		String sql = "SELECT * FROM recolecta r JOIN cultivo c ON r.CodCul=c.CodCul WHERE CodRec= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, CodRec);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			recolecta = new Recolecta(res.getInt("CodRec"), res.getDate("FecRec"), res.getInt("KilRec"),
					res.getInt("TraCul"), res.getString("DNIPerRec"),res.getString("DesRec"),res.getInt("CodCul"),res.getString("NomCul"));
		}
		res.close();
		con.desconectar();

		return recolecta;
	}

	// actualizar
	public boolean actualizar(Recolecta recolecta) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE recolecta SET FecRec=?,KilRec=?,TraCul=?, DNIPerRec=?, DesRec=?, CodCul=? WHERE CodRec=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);	

		
		statement.setDate(1, new Date(recolecta.getFecRec().getTime()));
		statement.setInt(2, recolecta.getKilRec());
		statement.setInt(3, recolecta.getTraCul());
		statement.setString(4, recolecta.getDniPerRec());
		statement.setString(5, recolecta.getDesRec());
		statement.setInt(6, recolecta.getCodCul());
		statement.setInt(7, recolecta.getCodRec());

		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//eliminar
	public boolean eliminar(Recolecta recolecta) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM recolecta WHERE CodRec=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, recolecta.getCodRec());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
	

}
