package br.com.financeiro.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.financeiro.models.Financeiro;
import br.com.financeiro.repository.FinanceiroRepository;

@Service
public class FinanceiroService {
	
	@Autowired ///estancia objeto
	private FinanceiroRepository repository;
	
	@Transactional ///rollback
	public Financeiro salvar(Financeiro financeiro) {
		return repository.save(financeiro);
		
	}

	public Financeiro salva(Financeiro financeiro) {
		return repository.save(financeiro);
	}

	public List<Financeiro> bucarTodos() {
		return repository.findAll();
	}


	public Optional<Financeiro> buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}
    
	@Transactional
	public void excluir(Long id) {
		repository.deleteById(id);
		
	}
}

