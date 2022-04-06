package it.devlec.esame.controller;

import it.devlec.esame.avviso.ProdottoNonTrovato;
import it.devlec.esame.model.Prodotto;
import it.devlec.esame.model.Prodotto;
import it.devlec.esame.repository.ProdottiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    public class ProdottoRestController {

        private static Logger logger = LoggerFactory.getLogger(ProdottoRestController.class);

        public ProdottiRepository repository;

        ProdottoRestController(ProdottiRepository repository) {
            this.repository = repository;
        }

        @GetMapping("/prodotto")
        public List<Prodotto> leggiTuttiIProdotti() {
            return repository.findAll();
        }
    @GetMapping("/prodotto/{id}")
    public Prodotto trovaProdottoConID(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new ProdottoNonTrovato(id));
    }
    }
