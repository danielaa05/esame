package it.devlec.esame.repository;

import it.devlec.esame.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdottiRepository extends JpaRepository<Prodotto, Long> {
}
