package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AcessoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AcessoController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AcessoController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
                String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		PrintWriter saida = response.getWriter();
		
		if(senha.equalsIgnoreCase(login)) {
			saida.println("<h1>Login efetuado com sucesso!</h1>");
			saida.println("<h2>Acione o botão continuar para ser redirecionado para a página inicial.</h2>");
			saida.println("<input type=submit value=Continuar>");
		} else {
			saida.println("<h1>Credenciais inválidas</h1>");
			saida.println("<h2>Login/Senha incorretos!</h2>");
			saida.println("<a href='login.html'>Voltar</a>");
		}
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
