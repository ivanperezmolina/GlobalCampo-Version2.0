package com.ivanp.globalcampo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ivanp.globalcampo.dao.CultivoDAO;

import com.ivanp.globalcampo.model.Cultivo;

/**
 * Servlet implementation class AdminArticulo
 */
@WebServlet("/adminCultivo")
public class AdminCultivo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CultivoDAO cultivoDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {

			cultivoDAO = new CultivoDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminCultivo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
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
		System.out.println("Hola Servlet..");
		doGet(request, response);
	}
	
	private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		RequestDispatcher dispatcher= request.getRequestDispatcher("indexCultivo.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Cultivo cultivo = new Cultivo(0, request.getParameter("nomCul"), request.getParameter("desCul"), request.getParameter("regCul"),request.getParameter("copeCul"));
		cultivoDAO.insertar(cultivo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("indexCultivo.jsp");
		dispatcher.forward(request, response);
	}
	
	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/registerCultivo.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		List<Cultivo> listaCultivo= cultivoDAO.listarCultivo();
		
		request.setAttribute("listaCultivo", listaCultivo);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrarCultivo.jsp");
		dispatcher.forward(request, response);
	}	
	
	private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Cultivo cultivo = cultivoDAO.obtenerPorId(Integer.parseInt(request.getParameter("codCul")));
		request.setAttribute("cultivo", cultivo);		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editarCultivo.jsp");
		dispatcher.forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Cultivo cultivo = new Cultivo(Integer.parseInt(request.getParameter("codCul")), request.getParameter("nomCul"), request.getParameter("desCul"), request.getParameter("regCul"), request.getParameter("copeCul"));
		cultivoDAO.actualizar(cultivo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("indexCultivo.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Cultivo cultivo = cultivoDAO.obtenerPorId(Integer.parseInt(request.getParameter("codCul")));
		cultivoDAO.eliminar(cultivo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("indexCultivo.jsp");
		dispatcher.forward(request, response);
		
	}
}
