package br.com.fiap.agroclimate.agroclimatemvc.repository;

import br.com.fiap.agroclimate.agroclimatemvc.model.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FazendaRepository extends JpaRepository<Fazenda,Long> {
}
