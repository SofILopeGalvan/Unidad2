package mx.edu.utng.prendas.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.utng.prendas.dao.PrendaDAOImp;
import mx.edu.utng.prendas.model.Prenda;
import mx.edu.utng.prendas.dao.PrendaDAO;
public class PrendaController extends HttpServlet {
   private static final String
           LISTA_PRENDAS = "/lista_prendas.jsp";
   private static final String 
           AGREGAR_O_CAMBIAR = "prenda.jsp";
   private PrendaDAO dao;
   
   public PrendaController(){
       dao = new PrendaDAOImp();
   }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("borrar")){
            forward = LISTA_PRENDAS;
            int idPrenda = Integer.parseInt(
                request.getParameter("idPrenda"));
            dao.borrarPrenda(idPrenda);
            request.setAttribute("prenda",
                    dao.desplegarPrenda());
         }else if(action.equalsIgnoreCase("cambiar")){
             forward = AGREGAR_O_CAMBIAR;
             int idPrenda = Integer.parseInt(
                request.getParameter("idPrenda"));
             Prenda prenda = 
                     dao.elegirPrenda(idPrenda);
             request.setAttribute("prenda", prenda);
         } else if(action.equalsIgnoreCase("agregar")){
             forward = AGREGAR_O_CAMBIAR;
         } else{
             forward = LISTA_PRENDAS;
             request.setAttribute("prenda", 
                     dao.desplegarPrenda());
         }
        
        RequestDispatcher view = 
                request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Prenda prenda = new Prenda();
        prenda.setDescripcion(request.getParameter("descripcion"));
        prenda.setColor(request.getParameter("color"));
        prenda.setStand(request.getParameter("stand"));
        prenda.setPrecio(Integer.parseInt(
                request.getParameter("precio")));
        String idPrenda = request.getParameter("idPrenda");
        
        if(idPrenda==null|| idPrenda.isEmpty()||idPrenda.trim().equals("")){
            dao.agregarPrenda(prenda);
        }else{
            prenda.setIdPrenda(Integer.parseInt(idPrenda));
            dao.cambiarPrenda(prenda);
        }
        RequestDispatcher view = 
                request.getRequestDispatcher(LISTA_PRENDAS);
        request.setAttribute("prenda", 
                dao.desplegarPrenda());
        view.forward(request, response);
    }
}
