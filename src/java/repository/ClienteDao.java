package repository;

import java.util.ArrayList;
import java.util.List;
import negocio.Cliente;

public class ClienteDao {
    private static List<Cliente> clientes;
    
    private static void prepara() {
		if(clientes == null) {
			clientes = new ArrayList<Cliente>();
		}
	}
	
	public static boolean incluir(Cliente cliente) {
		prepara();
		
		try {
			clientes.add(cliente);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
		
	public static List<Cliente> obterLista(){
		prepara();
		return clientes;
	}
}
