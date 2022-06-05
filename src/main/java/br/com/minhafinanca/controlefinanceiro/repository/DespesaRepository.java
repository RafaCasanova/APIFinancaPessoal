package br.com.minhafinanca.controlefinanceiro.repository;

import br.com.minhafinanca.controlefinanceiro.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa,Long> {

    List<Despesa> findByNome(String nome);
}
