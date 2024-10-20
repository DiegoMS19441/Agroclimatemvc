package br.com.fiap.agroclimate.agroclimatemvc.repository;

import br.com.fiap.agroclimate.agroclimatemvc.model.Agricultor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgricultorRepository extends JpaRepository<Agricultor, Long> {

}
