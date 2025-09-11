package br.com.bentao.api_produtos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bentao.api_produtos.model.Calendario;

public interface CalendarioRepository extends JpaRepository<Calendario, Long> {
    List<Calendario> findByTest(String test);
}
