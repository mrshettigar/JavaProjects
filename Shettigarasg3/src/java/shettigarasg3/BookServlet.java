/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shettigarasg3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shettigardblib.Reservation;

/**
 *
 * @author Mangesh
 */
public class BookServlet extends HttpServlet {
    
    private Reservation mdb;
    
     @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
        mdb = new Reservation("ism6236","ism6236bo"); 
        
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String cid = request.getParameter("cid");
        String datein = request.getParameter("datein");
        String dateout = request.getParameter("dateout");
        String roomno = request.getParameter("roomno");
        Boolean avail = mdb.checkRoomAvailability(roomno, datein, dateout);
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookServlet</title>");
            out.println("<link rel =\"stylesheet\" type=\"text/css\" href=\"shettigar.css\"/>");
            out.println("</head>");
            out.println("<body>");
            
            if(avail){
                out.println(String.format("Total cost of stay is %.2f",mdb.book(cid, roomno, datein, dateout)));
            }
            else
            {
                out.println("Room not available, please choose from the available rooms only!");
            }
            out.println("<br>");
            out.println("<a href=\"index.html\"> Main Menu </a> <br>");
            
            
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
