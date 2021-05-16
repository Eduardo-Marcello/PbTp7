
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Cliente;
import repository.ClienteDao;

public class ClienteController extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClienteController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClienteController at " + request.getContextPath() + "</h1>");
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
       // processRequest(request, response);
       
                List<Cliente> clientes = ClienteDao.obterLista();
                
       		Cliente cliente = new Cliente(request.getParameter("nome"), 
				request.getParameter("email"),
				request.getParameter("user"),
				request.getParameter("password"));
		
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setIdade(Integer.parseInt(request.getParameter("idade")));
		cliente.setGenero(request.getParameter("genero"));
		cliente.setNotificacoes(request.getParameterValues("servicos"));
		
                if(ClienteDao.incluir(cliente)) {
			PrintWriter saida = response.getWriter();
			
			saida.println("<h1>Cadastro Confirmado</h1>");
			saida.println("<h2>"+cliente.toString()+"</h2>");
			saida.println("<p> O Cliente foi cadastrado com sucesso!</p>");
			saida.println("<h1>Listagem de clientes cadastrados: "+clientes.size()+"</h1>");
			for(Cliente c: clientes) {
				saida.println("<h2>"+c.getNome()+" | "+ c.getIdade() + " | " + c.getEmail() +"</h2>");
			}
                        saida.println("<a href='cadastro.jsp'>Voltar</a>");
		} else {
                
                }
                //cliente.impressao();
		
		//request.getRequestDispatcher("confirmacao.html").forward(request, response);
                
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
