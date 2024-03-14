package br.com.tbiazin.Domain;


import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class ClienteSetDAO implements IClienteDAO {
    
    private Set<Clientes> set;
    
    public ClienteSetDAO() {
        this.set = new HashSet<>();
    }

    @Override
    public Boolean cadastrar(Clientes cliente) {
        return this.set.add(cliente);
    }

    @Override
    public void excluir(Long cpf) {
        Clientes clienteEncontrato = null;
        for (Clientes cliente : this.set) {
            if (cliente.getCpf().equals(cpf)) {
                clienteEncontrato = cliente;
                break;
            }
        }
        
        if (clienteEncontrato != null) {
            this.set.remove(clienteEncontrato);
        }
    }

    @Override
    public void alterar(Clientes cliente) {
        if (this.set.contains(cliente)) {
            for (Clientes clienteCadastrado : this.set) {
                if (clienteCadastrado.equals(cliente)) {
                    clienteCadastrado.setNome(cliente.getNome());
                    clienteCadastrado.setTel(cliente.getTel());
                    clienteCadastrado.setNum(cliente.getNum());
                    clienteCadastrado.setEnd(cliente.getEnd());
                    clienteCadastrado.setCidade(cliente.getCidade());
                    clienteCadastrado.setEstado(cliente.getEstado());
                    break;
                }
            }
        }
    }

    @Override
    public Clientes consultar(Long cpf) {
        for (Clientes clienteCadastrado : this.set) {
             if (clienteCadastrado.getCpf().equals(cpf)) {
                 return clienteCadastrado;
             }
        }
        return null;
    }

    @Override
    public Collection<Clientes> buscarTodos() {
        return this.set;
    }

	
	


	
}