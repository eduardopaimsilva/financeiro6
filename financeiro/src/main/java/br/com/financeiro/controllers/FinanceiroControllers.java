package br.com.financeiro.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.financeiro.models.Financeiro;
import br.com.financeiro.repository.FinanceiroRepository;
import br.com.financeiro.service.FinanceiroService;

@RestController
@RequestMapping("/financeiro")
public class FinanceiroControllers {
	
	
	@Autowired ///estancia objeto
	private FinanceiroService service;
	
	
	@GetMapping()
	public List<Financeiro> buscarTodos() {
		return service.bucarTodos(); // busca todos
		
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<Financeiro> buscarPorId(@PathVariable Long id) {
		
		Optional<Financeiro> financeiro = service.buscarPorId(id);
		
		if(financeiro.isPresent()) {
			return ResponseEntity.ok(financeiro.get());
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Financeiro salvar(@RequestBody Financeiro financeiro) {
		return service.salvar(financeiro);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Financeiro> atualizar(@RequestBody Financeiro financeiro) {
		
		Optional<Financeiro> fin = service.buscarPorId(financeiro.getId() );
		
         if( fin.isPresent() ) {
        	 
        	 BeanUtils.copyProperties(financeiro, fin.get(), "id");
        	 //cli e o objeto que buscamos na base de dados
        	 return ResponseEntity.ok( service.salva( fin.get()) );
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Financeiro> excuir(@PathVariable Long id) {
		
		Optional<Financeiro> fin = service.buscarPorId( id );
		
		if(fin.isPresent()) {
		service.excluir(id);
		
		return ResponseEntity.noContent().build();
	}
	
	return ResponseEntity.notFound().build();
	
	}
}
