package br.com.desafio.cooperforteservice.repository;

import br.com.desafio.cooperforteservice.entity.LogTransacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<LogTransacao, Long> {
}
