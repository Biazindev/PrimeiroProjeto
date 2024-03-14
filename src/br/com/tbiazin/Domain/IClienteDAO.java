package br.com.tbiazin.Domain;

import java.util.Collection;

public interface IClienteDAO {
	
	public Boolean cadastrar(Clientes cliente);
	
	public void excluir(Long cpf);
	
	public void alterar(Clientes cliente);
	
	public Clientes consultar(Long cpf);
	
	public Collection<Clientes> buscarTodos();

}
