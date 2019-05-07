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


public class TratamientoDAO {

	private Conexion con;
	private Connection connection;

	public TratamientoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// insertar tratamiento
	public boolean insertar(Tratamiento tratamiento) throws SQLException {
		
		String sql = "INSERT INTO tratamiento (FecTra, DesTra, TipTra,CodCul,CodFer) VALUES (?, ?, ?,?,?)";
		con.conectar();
		
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setDate(1, new Date(tratamiento.getFecTra().getTime()));	
		statement.setString(2, tratamiento.getDesTra());
		statement.setString(3, tratamiento.getTipTra());
		statement.setInt(4, tratamiento.getCodCul());
		statement.setInt(5, tratamiento.getCodFer());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todas las recolectas
	public List<Tratamiento> listarTratamiento() throws SQLException {

		List<Tratamiento> listarTratamiento = new ArrayList<Tratamiento>();
		String sql = "SELECT * FROM tratamiento t JOIN cultivo c ON t.CodCul=c.CodCul JOIN fertilizante f ON t.CodFer=f.CodFer";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int CodTra = resulSet.getInt("CodTra");
			Date FecTraSQL = resulSet.getDate("FecTra");
			java.util.Date FecTra = new java.util.Date(FecTraSQL.getTime());
			String DesTra = resulSet.getString("DesTra");
			String TipTra = resulSet.getString("TipTra");
			int CodCul = resulSet.getInt("CodCul");
			int CodFer = resulSet.getInt("CodFer");
			String NomCul = resulSet.getString("NomCul");
			String NomFer = resulSet.getString("NomFer");
			
			Tratamiento tratamiento = new Tratamiento(CodTra, FecTra, DesTra, TipTra, CodCul,CodFer,NomCul, NomFer);
			listarTratamiento.add(tratamiento);
		}
		con.desconectar();
		return listarTratamiento;
	}

	// obtener por id
	public Tratamiento obtenerPorId(int CodTra) throws SQLException {
		Tratamiento tratamiento = null;

		String sql = "SELECT * FROM tratamiento t JOIN cultivo c ON t.CodCul=c.CodCul JOIN fertilizante f ON t.CodFer=f.CodFer WHERE CodTra= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, CodTra);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			tratamiento = new Tratamiento(res.getInt("CodTra"), res.getDate("FecTra"), res.getString("DesTra"),
					res.getString("TipTra"), res.getInt("CodCul"),res.getInt("CodFer"),res.getString("NomCul"),res.getString("NomFer"));
		}
		res.close();
		con.desconectar();

		return tratamiento;
	}

	// actualizar
	public boolean actualizar(Tratamiento tratamiento) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE tratamiento SET FecTra=?,DesTra=?,TipTra=?, CodCul=?, CodFer=? WHERE CodTra=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);	

		
		statement.setDate(1, new Date(tratamiento.getFecTra().getTime()));
		statement.setString(2, tratamiento.getDesTra());
		statement.setString(3, tratamiento.getTipTra());
		statement.setInt(4, tratamiento.getCodCul());
		statement.setInt(5, tratamiento.getCodFer());
		statement.setInt(6, tratamiento.getCodTra());


		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//eliminar
	public boolean eliminar(Tratamiento tratamiento) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM tratamiento WHERE CodTra=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, tratamiento.getCodTra());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
}
