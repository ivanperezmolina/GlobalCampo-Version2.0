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


import com.ivanp.globalcampo.dao.TratamientoDAO;

import com.ivanp.globalcampo.model.Tratamiento;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/adminTratamiento")
public class AdminTratamiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TratamientoDAO tratamientoDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {

			tratamientoDAO = new TratamientoDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminTratamiento() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet Tratamiento..");
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
		System.out.println("Hola Servlet Tratamiento..");
		doGet(request, response);
	}
	
	private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		RequestDispatcher dispatcher= request.getRequestDispatcher("indexTratamiento.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		final String miFechaString = request.getParameter("fecTra");
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date miFechaDate;
		
		try {
			miFechaDate = sdf.parse(miFechaString);
			
			final String tipoTratamiento = request.getParameter("tipTra");
			final String descripcionTratamiento = request.getParameter("desTra");
			final int codigoCultivo = (Integer.parseInt(request.getParameter("codCul")));
			final int codigoFertilizante = (Integer.parseInt(request.getParameter("codFer")));
			final String nombreCultivo =request.getParameter("nomCul");
			final String nombreFertilizante =request.getParameter("nomFer");
			
			Tratamiento tratamiento = new Tratamiento(0, miFechaDate, descripcionTratamiento, tipoTratamiento,codigoCultivo, codigoFertilizante,nombreCultivo,nombreFertilizante);        
			
			tratamientoDAO.insertar(tratamiento);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("indexTratamiento.jsp");	
			
			dispatcher.forward(request, response);
			
		} catch (ParseException e) {
			System.out.println("Error de formato.");
		}
	}
	
	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/registerTratamiento.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		List<Tratamiento> listaTratamiento= tratamientoDAO.listarTratamiento();
		
		request.setAttribute("listaTratamiento", listaTratamiento);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrarTratamiento.jsp");
		dispatcher.forward(request, response);
	}	
	
	private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Tratamiento tratamiento = tratamientoDAO.obtenerPorId(Integer.parseInt(request.getParameter("codTra")));
		request.setAttribute("tratamiento", tratamiento);		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editarTratamiento.jsp");
		dispatcher.forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		final String miFechaString = request.getParameter("fecTra");
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date miFechaDate;
		
		try {
			miFechaDate = sdf.parse(miFechaString);
			
			final int codigoTratamiento = (Integer.parseInt(request.getParameter("codTra")));
			final String tipoTratamiento = request.getParameter("tipTra");
			final String descripcionTratamiento = request.getParameter("desTra");
			final int codigoCultivo = (Integer.parseInt(request.getParameter("codCul")));
			final int codigoFertilizante = (Integer.parseInt(request.getParameter("codFer")));
			final String nombreCultivo =request.getParameter("nomCul");
			final String nombreFertilizante =request.getParameter("nomFer");
			
			Tratamiento tratamiento = new Tratamiento(codigoTratamiento, miFechaDate, descripcionTratamiento, tipoTratamiento,codigoCultivo,codigoFertilizante,nombreCultivo,nombreFertilizante);        
			tratamientoDAO.actualizar(tratamiento);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("indexTratamiento.jsp");	
			dispatcher.forward(request, response);
		} catch (ParseException e) {
			System.out.println("Error de formato.");
		}
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Tratamiento tratamiento = tratamientoDAO.obtenerPorId(Integer.parseInt(request.getParameter("codTra")));
		tratamientoDAO.eliminar(tratamiento);
		RequestDispatcher dispatcher = request.getRequestDispatcher("indexTratamiento.jsp");
		dispatcher.forward(request, response);
		
	}
}
