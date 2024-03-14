package br.com.tbiazin.Domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClienteMapDAO implements IClienteDAO {
	
	private Map<Long, Clientes> map;
	
	public ClienteMapDAO() {
		
		this.map = new HashMap<>();
	}

	@Override
	public Boolean cadastrar(Clientes cliente) {
		if (this.map.containsKey(cliente.getCpf())) {
		return false;}
		this.map.put(cliente.getCpf(), cliente)
		return true;
	}

	@Override
	public void excluir(Long cpf) {
		Clientes clienteCadastrado = this.map.get(cpf);
		if (clienteCadastrado != null) {
			this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
		}
	}

	@Override
	public void alterar(Clientes cliente) {
		Clientes clienteCadastrado = this.map.get(cliente.getCpf());
		if (clienteCadastrado != null) {
			clienteCadastrado.setNome(cliente.getNome());
			clienteCadastrado.setTel(cliente.getTel());
			clienteCadastrado.setNum(cliente.getNum());
			clienteCadastrado.setEnd(cliente.getEnd());
			clienteCadastrado.setCidade(cliente.getCidade());
			clienteCadastrado.setEstado(cliente.getEstado());
		}
		
	}

	@Override
	public Clientes consultar(Long cpf) {
		return this.map.get(cpf);
	}

	@Override
	public Collection<Clientes> buscarTodos() {
		return this.map.values();
	}

}
