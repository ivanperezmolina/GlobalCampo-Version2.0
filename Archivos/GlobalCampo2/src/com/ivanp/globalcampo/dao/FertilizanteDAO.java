package com.ivanp.globalcampo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ivanp.globalcampo.model.*;

public class FertilizanteDAO {
	private Conexion con;
	private Connection connection;

	public FertilizanteDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// insertar fertilizante
	public boolean insertar(Fertilizante fertilizante) throws SQLException {
		String sql = "INSERT INTO fertilizante (NomFer, DesFer, TipCulFer, UniFer) VALUES (?, ?, ?,?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, fertilizante.getNomFer());
		statement.setString(2, fertilizante.getDesFer());
		statement.setString(3, fertilizante.getTipCulFer());
		statement.setString(4, fertilizante.getUniFer());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todos los fertilizantes
	public List<Fertilizante> listarFertilizante() throws SQLException {

		List<Fertilizante> listarFertilizante = new ArrayList<Fertilizante>();
		String sql = "SELECT * FROM fertilizante";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int CodFer = resulSet.getInt("CodFer");
			String NomFer = resulSet.getString("NomFer");
			String DesFer = resulSet.getString("DesFer");
			String TipCulFer = resulSet.getString("TipCulFer");
			String UniFer = resulSet.getString("UniFer");
			
			Fertilizante fertilizante = new Fertilizante(CodFer, NomFer, DesFer, TipCulFer, UniFer);
			listarFertilizante.add(fertilizante);
		}
		con.desconectar();
		return listarFertilizante;
	}

	// obtener por id
	public Fertilizante obtenerPorId(int CodFer) throws SQLException {
		Fertilizante fertilizante = null;

		String sql = "SELECT * FROM fertilizante WHERE CodFer= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, CodFer);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			fertilizante = new Fertilizante(res.getInt("CodFer"), res.getString("NomFer"), res.getString("DesFer"),
					res.getString("TipCulFer"), res.getString("UniFer"));
		}
		res.close();
		con.desconectar();

		return fertilizante;
	}

	// actualizar
	public boolean actualizar(Fertilizante fertilizante) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE fertilizante SET NomFer=?,DesFer=?,TipCulFer=?, UniFer=? WHERE CodFer=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, fertilizante.getNomFer());
		statement.setString(2, fertilizante.getDesFer());
		statement.setString(3, fertilizante.getTipCulFer());
		statement.setString(4, fertilizante.getUniFer());
		statement.setInt(5, fertilizante.getCodFer());

		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//eliminar
	public boolean eliminar(Fertilizante fertilizante) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM fertilizante WHERE CodFer=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, fertilizante.getCodFer());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}

}
