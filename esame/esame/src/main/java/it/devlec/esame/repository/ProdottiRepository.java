package it.devlec.esame.repository;

import it.devlec.esame.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProdottiRepository extends JpaRepository<Prodotto, Long> {
        public List<Prodotto> findByDatadiscadenzaBetween(Date datada, Date dataa);
        public List<Prodotto> findByDatadiacquistoBetween(Date datada, Date dataa);
    }
