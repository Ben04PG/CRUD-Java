package com.aprendec.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aprendec.dao.ProductoDAO;
import com.aprendec.model.Producto;

/**
 * Servlet implementation class ProductoController
 * Servlet que maneja las operaciones CRUD para los productos.
 * Se encarga de procesar las solicitudes del cliente y delegar las acciones
 * a la clase ProductoDAO para interactuar con la base de datos.
 */
@WebServlet(description = "Administra peticiones para la tabla productos", urlPatterns = { "/productos" })
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 * Constructor por defecto de ProductoController.
     * Llama al constructor de la superclase HttpServlet.
	 */
	public ProductoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *
     * Maneja las solicitudes GET del cliente.
     * Dependiendo del parámetro "opcion", se redirige la solicitud a la vista que corresponde
     * o realiza las operaciones del listado, edición o eliminación de productos.
     * 
     * @param request  La solicitud HTTP recibida.
     * @param response La respuesta HTTP que se enviará al cliente.
     * @throws ServletException Si ocurre un error en la ejecución del servlet.
     * @throws IOException      Si ocurre un error de entrada/salida.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String opcion = request.getParameter("opcion");

		if (opcion.equals("crear")) {
			System.out.println("Usted a presionado la opcion crear");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/crear.jsp");
			requestDispatcher.forward(request, response);
		} else if (opcion.equals("listar")) {
			ProductoDAO productoDAO = new ProductoDAO();
			List<Producto> lista = new ArrayList<>();
			try {
				lista = productoDAO.obtenerProductos();
				for (Producto producto : lista) {
					System.out.println(producto);
				}

				request.setAttribute("lista", lista);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listar.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Usted a presionado la opcion listar");
		} else if (opcion.equals("meditar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("Editar id: " + id);
			ProductoDAO productoDAO = new ProductoDAO();
			Producto p = new Producto();
			try {
				p = productoDAO.obtenerProducto(id);
				System.out.println(p);
				request.setAttribute("producto", p);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/editar.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (opcion.equals("eliminar")) {
			ProductoDAO productoDAO = new ProductoDAO();
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				productoDAO.eliminar(id);
				System.out.println("Registro eliminado satisfactoriamente...");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *
     * Maneja las solicitudes POST del cliente.
     * Procesa la creación o edición de un producto, utilizando los datos enviados en la solicitud.
     * 
     * @param request  La solicitud HTTP recibida.
     * @param response La respuesta HTTP que se enviará al cliente.
     * @throws ServletException Si ocurre un error en la ejecución del servlet.
     * @throws IOException      Si ocurre un error de entrada/salida.
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion = request.getParameter("opcion");
		Date fechaActual = new Date();

		if (opcion.equals("guardar")) {
			ProductoDAO productoDAO = new ProductoDAO();
			Producto producto = new Producto();
			producto.setNombre(request.getParameter("nombre"));
			producto.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
			producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
			producto.setFechaCrear(new java.sql.Timestamp(fechaActual.getTime()));
			try {
		        if (productoDAO.guardar(producto)) {
		            request.setAttribute("mensajeExito", "El producto ha sido guardado satisfactoriamente.");
		        } else {
		            request.setAttribute("mensajeError", "Ha ocurrido un error al guardar el producto, o el producto ya existe");
		        }
		        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/crear.jsp");
		        requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.getSession().setAttribute("mensajeError", "Error en la base de datos: " + e.getMessage());;
	            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/crear.jsp");
	            requestDispatcher.forward(request, response);
			}
		} else if (opcion.equals("editar")) {
			Producto producto = new Producto();
			ProductoDAO productoDAO = new ProductoDAO();

			producto.setId(Integer.parseInt(request.getParameter("id")));
			producto.setNombre(request.getParameter("nombre"));
			producto.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
			producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
			producto.setFechaActualizar(new java.sql.Timestamp(fechaActual.getTime()));
			try {
		        if (productoDAO.editar(producto)) {
		            request.setAttribute("mensajeExito", "El producto ha sido editado satisfactoriamente.");
		        } else {
		            request.setAttribute("mensajeError", "Ha ocurrido un error al editar el producto.");
		        }
		        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/editar.jsp");
		        requestDispatcher.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	            request.getSession().setAttribute("mensajeError", "Error en la base de datos: " + e.getMessage());
	            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/editar.jsp");
	            requestDispatcher.forward(request, response);
			}
		}

		// doGet(request, response);
	}

}
