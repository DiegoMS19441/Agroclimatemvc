package br.com.fiap.agroclimate.agroclimatemvc.repository;

import br.com.fiap.agroclimate.agroclimatemvc.model.Safra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SafraRepository extends JpaRepository<Safra, Long> {
}
