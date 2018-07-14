/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shettigarasg3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class AvailableServlet extends HttpServlet {
    
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
        List<String> alist = mdb.getAvailableList(datein, dateout);
       
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Room Availability</title>"); 
            out.println("<link rel =\"stylesheet\" type=\"text/css\" href=\"shettigar.css\"/>");
            out.println("</head>");
            out.println("<body>");
            
            out.println("<form ACTION=\"Book\" METHOD=\"POST\">");
            out.println("<fieldset id=\"info\">");
            out.println("<legend> Book Room: </legend>");
            
            String cno = String.format("<label for=\"no\"> Customer No: </label> <INPUT id= \"no\" type=text size=20 name=\"cid\" value=\"%s\"> <br>",cid);
            out.println(cno);
            
            String din = String.format("<label for=\"no\"> Date In: </label> <INPUT id= \"no\" type=text size=20 name=\"datein\" value=\"%s\"> <br>",datein);
            out.println(din);
            
            String dout = String.format("<label for=\"no\"> Date Out: </label> <INPUT id= \"no\" type=text size=20 name=\"dateout\" value=\"%s\"> <br>",dateout);
            out.println(dout);
            
            out.println("<select id = \"available\" name =\"availablelist\" size=\"10\">");
            for (String s : alist)
            {
                String line = String.format("<option>%s </option>", s);
                out.println(line);
            }
            out.println("</select> <br>");
            String rno = String.format("<label for=\"no\"> Room No: </label> <INPUT id= \"no\" type=text size=20 name=\"roomno\" value=\"\"> <br>");
            out.println(rno);
            
            out.println("<INPUT id=\"button1\" NAME=\"btnBook2\" type =\"submit\" VALUE=\"Book\" >");
            out.println("<a href=\"index.html\"> Main Menu </a> <br>");
            out.println("</fieldset>");
            out.println("</form>");
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
