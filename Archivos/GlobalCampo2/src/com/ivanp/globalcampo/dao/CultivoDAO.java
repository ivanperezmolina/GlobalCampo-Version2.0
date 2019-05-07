package com.ivanp.globalcampo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.ivanp.globalcampo.model.*;


public class CultivoDAO {
	private Conexion con;
	private Connection connection;

	public CultivoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// insertar cultivo
	public boolean insertar(Cultivo cultivo) throws SQLException {
		String sql = "INSERT INTO cultivo (NomCul, DesCul, RegCul, CopeCul) VALUES (?, ?, ?,?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cultivo.getNomCul());
		statement.setString(2, cultivo.getDesCul());
		statement.setString(3, cultivo.getRegCul());
		statement.setString(4, cultivo.getCopeCul());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todos los productos
	public List<Cultivo> listarCultivo() throws SQLException {

		List<Cultivo> listarCultivo = new ArrayList<Cultivo>();
		String sql = "SELECT * FROM cultivo";
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
	public Cultivo obtenerPorId(int CodCul) throws SQLException {
		Cultivo cultivo = null;

		String sql = "SELECT * FROM cultivo WHERE CodCul= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, CodCul);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			cultivo = new Cultivo(res.getInt("CodCul"), res.getString("NomCul"), res.getString("DesCul"),
					res.getString("RegCul"), res.getString("CopeCul"));
		}
		res.close();
		con.desconectar();

		return cultivo;
	}

	// actualizar
	public boolean actualizar(Cultivo cultivo) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE cultivo SET NomCul=?,DesCul=?,RegCul=?, CopeCul=? WHERE CodCul=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cultivo.getNomCul());
		statement.setString(2, cultivo.getDesCul());
		statement.setString(3, cultivo.getRegCul());
		statement.setString(4, cultivo.getCopeCul());
		statement.setInt(5, cultivo.getCodCul());

		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//eliminar
	public boolean eliminar(Cultivo cultivo) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM cultivo WHERE CodCul=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, cultivo.getCodCul());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}

}
