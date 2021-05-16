package negocio;

public class Cliente {
    
        private String nome;
	private String email;
	private String cpf;
	private int idade;
	private String genero;
	private String userName;
	private String password;
	private String[] notificacoes;
	
	public Cliente(String nome, String email, String userName, String password) {
		this.nome = nome;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format("[%s] o cliente %s (%s) da identificacao %s com %d anos do genero %s, recebe %d notificações do nosso marketing!",
				userName,
				nome,
				email,
				cpf,
				idade,
				genero,
				notificacoes != null ? notificacoes.length : 0);
	}
	
	public void impressao() {
		System.out.println(this);
		System.out.println("notificações de Marketing selecionadas:");
		if(notificacoes != null) {
			for(String n: notificacoes) {
				System.out.println(" - " + n);
			}
		}
		
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String[] getNotificacoes() {
		return notificacoes;
	}
	
	public void setNotificacoes(String[] notificacoes) {
		this.notificacoes = notificacoes;
	}
}
