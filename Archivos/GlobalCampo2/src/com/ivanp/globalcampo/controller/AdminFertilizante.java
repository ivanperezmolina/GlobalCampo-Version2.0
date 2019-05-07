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

import com.ivanp.globalcampo.dao.FertilizanteDAO;
import com.ivanp.globalcampo.model.Fertilizante;

/**
 * Servlet implementation class AdminFertilizante
 */
@WebServlet("/adminFertilizante")
public class AdminFertilizante extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FertilizanteDAO fertilizanteDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {

			fertilizanteDAO = new FertilizanteDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFertilizante() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet AdminFertilizante..");
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
		System.out.println("Hola Servlet AdminFertilizante..");
		doGet(request, response);
	}
	
	private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		RequestDispatcher dispatcher= request.getRequestDispatcher("indexFertilizante.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Fertilizante fertilizante = new Fertilizante(0, request.getParameter("nomFer"), request.getParameter("desFer"), request.getParameter("tipCulFer"),request.getParameter("uniFer"));
		fertilizanteDAO.insertar(fertilizante);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("indexFertilizante.jsp");
		dispatcher.forward(request, response);
	}
	
	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/registerFertilizante.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		List<Fertilizante> listaFertilizante= fertilizanteDAO.listarFertilizante();
		
		request.setAttribute("listaFertilizante", listaFertilizante);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrarFertilizante.jsp");
		dispatcher.forward(request, response);
		
	}	
	
	private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Fertilizante fertilizante = fertilizanteDAO.obtenerPorId(Integer.parseInt(request.getParameter("codFer")));
		request.setAttribute("fertilizante", fertilizante);		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editarFertilizante.jsp");
		dispatcher.forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Fertilizante fertilizante = new Fertilizante(Integer.parseInt(request.getParameter("codFer")), request.getParameter("nomFer"), request.getParameter("desFer"), request.getParameter("tipCulFer"), request.getParameter("uniFer"));
		fertilizanteDAO.actualizar(fertilizante);
		RequestDispatcher dispatcher = request.getRequestDispatcher("indexFertilizante.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Fertilizante fertilizante = fertilizanteDAO.obtenerPorId(Integer.parseInt(request.getParameter("codFer")));
		fertilizanteDAO.eliminar(fertilizante);
		RequestDispatcher dispatcher = request.getRequestDispatcher("indexFertilizante.jsp");
		dispatcher.forward(request, response);
		
	}
}
