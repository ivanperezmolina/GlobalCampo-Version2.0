package com.ivanp.globalcampo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ivanp.globalcampo.dao.RecolectaDAO;

import com.ivanp.globalcampo.model.Recolecta;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/adminRecolecta")
public class AdminRecolecta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RecolectaDAO recolectaDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {

			recolectaDAO = new RecolectaDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminRecolecta() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet Recolecta..");
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "nuevo":
				nuevo(request, response);
				break;
			case "register":
				System.out.println("entro");
				registrar(request, response);
				break;
			case "mostrar":
				mostrar(request, response);
				break;
			case "showedit":
				showEditar(request, response);
				break;	
			case "editar":
				editar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			default:
				break;
			}			
		} catch (SQLException e) {
			e.getStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet Recolecta..");
		doGet(request, response);
	}
	
	private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		RequestDispatcher dispatcher= request.getRequestDispatcher("indexRecolecta.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		final String miFechaString = request.getParameter("fecRec");
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date miFechaDate;
		
		try {
			miFechaDate = sdf.parse(miFechaString);
			
			final int kilosRecogidos = Integer.parseInt(request.getParameter("kilRec"));
			final int trabajadoresCultivo = Integer.parseInt(request.getParameter("traCul"));
			final String dniResponsable = request.getParameter("dniPerRes");
			final String descripcionRecolecta = request.getParameter("desRec");
			final int codigoCultivo = (Integer.parseInt(request.getParameter("codCul")));
			final String nombreCultivo = request.getParameter("nomCul");
			
			Recolecta recolecta = new Recolecta(0, miFechaDate, kilosRecogidos, trabajadoresCultivo,dniResponsable,descripcionRecolecta,codigoCultivo,nombreCultivo);        
			
			recolectaDAO.insertar(recolecta);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("indexRecolecta.jsp");	
			
			dispatcher.forward(request, response);
			
		} catch (ParseException e) {
			System.out.println("Error de formato.");
		}
	}
	
	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/registerRecolecta.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		List<Recolecta> listaRecolecta= recolectaDAO.listarRecolecta();
		
		request.setAttribute("listaRecolecta", listaRecolecta);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrarRecolecta.jsp");
		dispatcher.forward(request, response);
	}	
	
	private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Recolecta recolecta = recolectaDAO.obtenerPorId(Integer.parseInt(request.getParameter("codRec")));
		request.setAttribute("recolecta", recolecta);		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editarRecolecta.jsp");
		dispatcher.forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		final String miFechaString = request.getParameter("fecRec");
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date miFechaDate;
		
		try {
			miFechaDate = sdf.parse(miFechaString);
			
			final int codigoRecolecta = (Integer.parseInt(request.getParameter("codRec")));
			final int kilosRecogidos = Integer.parseInt(request.getParameter("kilRec"));
			final int trabajadoresCultivo = Integer.parseInt(request.getParameter("traCul"));
			final String dniResponsable = request.getParameter("dniPerRec");
			final String descripcionRecolecta = request.getParameter("desRec");
			final int codigoCultivo = (Integer.parseInt(request.getParameter("codCul")));
			final String nombreCultivo = request.getParameter("nomCul");
			
			
			Recolecta recolecta = new Recolecta(codigoRecolecta, miFechaDate, kilosRecogidos, trabajadoresCultivo,dniResponsable,descripcionRecolecta,codigoCultivo,nombreCultivo);        
			recolectaDAO.actualizar(recolecta);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("indexRecolecta.jsp");	
			dispatcher.forward(request, response);
		} catch (ParseException e) {
			System.out.println("Error de formato.");
		}
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Recolecta recolecta = recolectaDAO.obtenerPorId(Integer.parseInt(request.getParameter("codRec")));
		recolectaDAO.eliminar(recolecta);
		RequestDispatcher dispatcher = request.getRequestDispatcher("indexRecolecta.jsp");
		dispatcher.forward(request, response);
		
	}

}
