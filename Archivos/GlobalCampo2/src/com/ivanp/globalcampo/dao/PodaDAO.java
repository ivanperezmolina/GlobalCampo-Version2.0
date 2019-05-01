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


public class PodaDAO {

	private Conexion con;
	private Connection connection;

	public PodaDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// insertar poda
	public boolean insertar(Poda poda) throws SQLException {
		
		String sql = "INSERT INTO poda (FecPod, OliPod, DesPod,CodCul) VALUES (?, ?, ?,?)";
		con.conectar();
		
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setDate(1, new Date(poda.getFecPod().getTime()));	
		statement.setInt(2, poda.getOliPod());
		statement.setString(3, poda.getDesPod());
		statement.setInt(4, poda.getCodCul());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todas las podas
	public List<Poda> listarPoda() throws SQLException {

		List<Poda> listarPoda = new ArrayList<Poda>();
		String sql = "SELECT *  FROM poda p JOIN cultivo c ON p.CodCul=c.CodCul ";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int CodPod = resulSet.getInt("CodPod");
			Date FecRecSQL = resulSet.getDate("FecPod");
			java.util.Date FecPod = new java.util.Date(FecRecSQL.getTime());
			int OliPod = resulSet.getInt("OliPod");
			String DesPod = resulSet.getString("DesPod");
			int CodCul = resulSet.getInt("CodCul");
			String NomCul = resulSet.getString("NomCul");
			
			Poda poda = new Poda(CodPod, FecPod, OliPod, DesPod,CodCul,NomCul);
			listarPoda.add(poda);
		}
		con.desconectar();
		return listarPoda;
	}

	// obtener por id
	public Poda obtenerPorId(int CodPod) throws SQLException {
		Poda poda = null;

		String sql = "SELECT * FROM poda p JOIN cultivo c ON p.CodCul=c.CodCul WHERE CodPod= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, CodPod);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			poda = new Poda(res.getInt("CodPod"), res.getDate("FecPod"), res.getInt("OliPod"),
					res.getString("DesPod"),res.getInt("CodCul"),res.getString("NomCul"));
		}
		res.close();
		con.desconectar();

		return poda;
	}

	// actualizar
	public boolean actualizar(Poda poda) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE poda SET FecPod=?,OliPod=?, DesPod=?, CodCul=? WHERE CodPod=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);	

		
		statement.setDate(1, new Date(poda.getFecPod().getTime()));
		statement.setInt(2, poda.getOliPod());
		statement.setString(3, poda.getDesPod());
		statement.setInt(4, poda.getCodCul());
		statement.setInt(5, poda.getCodPod());

		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//eliminar
	public boolean eliminar(Poda poda) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM poda WHERE CodPod=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, poda.getCodPod());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
}
