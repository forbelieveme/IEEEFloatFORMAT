/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Concatenador;
import logica.Contador;
import logica.Conversor;
import logica.InversorArray;
import logica.Recolector;

/**
 *
 * @author usuario
 */
@WebServlet(name = "ConversorServlet", urlPatterns = {"/ConversorServlet"})
public class ConversorServlet extends HttpServlet {
        Conversor conversor = new Conversor();
        InversorArray inversor = new InversorArray();
        Recolector recolector = new Recolector();
        Contador contador = new Contador();
        Concatenador conc = new Concatenador();
        
        String signo;
        String mantisa;
        String exponente;

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
        


        
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConversorServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Signo: " + signo );
            out.println("<br>");
            out.println("Mantisa: " + mantisa );
            out.println("<br>");
            out.println("Exponente: " + exponente );
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
        
        
        String valorAux =request.getParameter("n1");
        signo = conversor.asignarSigno(valorAux);
        valorAux = conversor.cambiarSigno(valorAux);

        ArrayList<Integer> parteEntera = new ArrayList();
        ArrayList<Integer> parteDecimal = new ArrayList();
        ArrayList<Integer> exponenteArr = new ArrayList();

        parteEntera = inversor.invertirArreglo(conversor.convertirEnteroBinario(valorAux));

        String decimalAux = recolector.obtenerParteDecimal(valorAux);

        parteDecimal = conversor.convertirDecimalBinario(decimalAux);

        exponenteArr = conversor.convertirEnteroBinario(contador.contarPosiciones(parteEntera, parteDecimal));
        conversor.mantisaOchoBits(exponenteArr);

        exponenteArr = inversor.invertirArreglo(exponenteArr);

        mantisa = conc.obtenerMantisa(parteEntera, parteDecimal);
        exponente = inversor.mantisaString(exponenteArr);
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
