package br.com.desafio.cooperforteservice.repository;

import br.com.desafio.cooperforteservice.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findById(Long id);

    List<Cliente> findAllByExcluidoFalse();
}
