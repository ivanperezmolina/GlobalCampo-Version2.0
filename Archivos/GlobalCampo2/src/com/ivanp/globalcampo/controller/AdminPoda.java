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


import com.ivanp.globalcampo.dao.PodaDAO;

import com.ivanp.globalcampo.model.Poda;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/adminPoda")
public class AdminPoda extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PodaDAO podaDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {

			podaDAO = new PodaDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminPoda() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet Poda..");
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
		System.out.println("Hola Servlet Poda..");
		doGet(request, response);
	}
	
	private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		RequestDispatcher dispatcher= request.getRequestDispatcher("indexPoda.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		final String miFechaString = request.getParameter("fecPod");
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date miFechaDate;
		
		try {
			miFechaDate = sdf.parse(miFechaString);
			
			final int olivosPodados = Integer.parseInt(request.getParameter("oliPod"));
			final String descripcionPoda = request.getParameter("desPod");
			final int codigoCultivo = (Integer.parseInt(request.getParameter("codCul")));
			final String nombreCultivo = request.getParameter("nomCul");
			
			Poda poda = new Poda(0, miFechaDate, olivosPodados, descripcionPoda,codigoCultivo,nombreCultivo);        
			
			podaDAO.insertar(poda);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("indexPoda.jsp");	
			
			dispatcher.forward(request, response);
			
		} catch (ParseException e) {
			System.out.println("Error de formato.");
		}
	}
	
	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/registerPoda.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		List<Poda> listaPoda= podaDAO.listarPoda();
		
		request.setAttribute("listaPoda", listaPoda);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrarPoda.jsp");
		dispatcher.forward(request, response);
	}	
	
	private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Poda poda = podaDAO.obtenerPorId(Integer.parseInt(request.getParameter("codPod")));
		request.setAttribute("poda", poda);		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editarPoda.jsp");
		dispatcher.forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		final String miFechaString = request.getParameter("fecPod");
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date miFechaDate;
		
		try {
			miFechaDate = sdf.parse(miFechaString);
			
			final int codigoPoda = (Integer.parseInt(request.getParameter("codPod")));
			final int olivosPodados = Integer.parseInt(request.getParameter("oliPod"));
			final String descripcionPoda = request.getParameter("desPod");
			final int codigoCultivo = (Integer.parseInt(request.getParameter("codCul")));
			final String nombreCultivo = request.getParameter("nomCul");
			
			
			Poda poda = new Poda(codigoPoda, miFechaDate, olivosPodados, descripcionPoda,codigoCultivo,nombreCultivo);        
			podaDAO.actualizar(poda);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("indexPoda.jsp");	
			dispatcher.forward(request, response);
		} catch (ParseException e) {
			System.out.println("Error de formato.");
		}
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Poda poda = podaDAO.obtenerPorId(Integer.parseInt(request.getParameter("codPod")));
		podaDAO.eliminar(poda);
		RequestDispatcher dispatcher = request.getRequestDispatcher("indexPoda.jsp");
		dispatcher.forward(request, response);
		
	}
}
