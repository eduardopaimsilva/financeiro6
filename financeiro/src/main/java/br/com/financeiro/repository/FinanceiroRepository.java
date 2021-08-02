package br.com.financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.financeiro.models.Financeiro;

@Repository
public interface FinanceiroRepository extends JpaRepository<Financeiro, Long>{

}
