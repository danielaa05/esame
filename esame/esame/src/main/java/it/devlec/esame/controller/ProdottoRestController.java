package it.devlec.esame.controller;

import it.devlec.esame.avviso.ProdottoNonTrovato;
import it.devlec.esame.model.Prodotto;
import it.devlec.esame.model.Prodotto;
import it.devlec.esame.repository.ProdottiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
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
    public Prodotto trovaProdottoConID(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ProdottoNonTrovato(id));
    }
    @PostMapping("/prodotto")
    public Prodotto inserisciUnNuovoProdotto(@RequestBody Prodotto nuovoProdotto){
        return repository.save(nuovoProdotto);
    }
    @PutMapping("/prodotto/{id}")
    public Prodotto aggiornaDatiProdotto(@PathVariable Long id, @RequestBody Prodotto prodotto){
        return repository.findById(id).map(nuovoProdotto -> {
                    nuovoProdotto.setNome(prodotto.getNome());
                    nuovoProdotto.setDatadiscadenza(prodotto.getDatadiscadenza());
                    nuovoProdotto.setDatadiacquisto(prodotto.getDatadiacquisto());
                    nuovoProdotto.setPrezzo(prodotto.getPrezzo());
                    nuovoProdotto.setQuantita(prodotto.getQuantita());
                    return repository.save(nuovoProdotto);
                }).orElseGet(() -> {
                    prodotto.setId(id);
                    return repository.save(prodotto);
                });
    }
    @DeleteMapping("/prodotto/{id}")
    void eliminaProdotto(@PathVariable Long id){
        repository.deleteById(id);
    }

    @GetMapping("/prodotto/ricercatradate")
    public List<Prodotto> RicercaProdottoTraDate(
            @RequestParam(name = "datada") @DateTimeFormat(pattern = "dd-MM-yyyy")
                    Date datada,
            @RequestParam(name = "dataa") @DateTimeFormat(pattern = "dd-MM-yyyy")
                    Date dataa
    ){
        return repository.findByDatadiscadenzaBetween(datada, dataa);
    }
    @GetMapping("/prodotto/datadiacquisto")
    public List<Prodotto> RicercaProdottoConDataDiAcquisto(
            @RequestParam(name = "datada") @DateTimeFormat(pattern = "dd-MM-yyyy")
                    Date datada,
            @RequestParam(name = "dataa") @DateTimeFormat(pattern = "dd-MM-yyyy")
                    Date dataa
    ){
        return repository.findByDatadiacquistoBetween(datada, dataa);
    }
    @PostMapping("/caricafile")
    public String caricaFile (@RequestParam("file") MultipartFile file){
        String infoFile = file.getOriginalFilename() + " - " + file.getContentType();
        String conFormat = String.format("%s-%s", file.getOriginalFilename(), file.getContentType());
        logger.info(infoFile);
        logger.warn(conFormat);
        return conFormat;
    }
}