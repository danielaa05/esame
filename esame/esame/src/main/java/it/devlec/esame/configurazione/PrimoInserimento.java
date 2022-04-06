package it.devlec.esame.configurazione;

import it.devlec.esame.model.Prodotto;
import it.devlec.esame.repository.ProdottiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class PrimoInserimento {
    private static final Logger logger = LoggerFactory.getLogger(PrimoInserimento.class);

    @Bean
    CommandLineRunner inserisciElementi(ProdottiRepository repository) {
        return args -> {
            SimpleDateFormat dataScadenza = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat dataAcquisto = new SimpleDateFormat("dd-MM-yyyy");

            Date scadenza = dataScadenza.parse("22-05-2022");
            Date acquisto = dataAcquisto.parse("21-04-2022");
            Prodotto p1 = new Prodotto("fragole", scadenza, acquisto, 12, 3);
            logger.info("nome: "+p1.getNome()+" data di scadenza: "+p1.getDatadiscadenza()+"data di acquisto: "+p1.getDatadiacquisto()+"quantita: "+p1.getQuantita()+"prezzo: "+p1.getPrezzo());
            repository.save(p1);

            scadenza = dataScadenza.parse("12-06-2022");
            acquisto = dataAcquisto.parse("21-04-2022");
            Prodotto p2 = new Prodotto("pasta", scadenza, acquisto, 2f, 5f);
            logger.info("nome: "+p2.getNome()+" data di scadenza: "+p2.getDatadiscadenza()+"data di acquisto: "
                    +p2.getDatadiacquisto()+"quantita: "+p2.getQuantita()+"prezzo: "+p2.getPrezzo());
            repository.save(p2);

            scadenza = dataScadenza.parse("30-04-2022");
            acquisto = dataAcquisto.parse("21-04-2022");
            Prodotto p3 = new Prodotto("pane", scadenza, acquisto, 1f, 3f);
            logger.info("nome: "+p3.getNome()+" data di scadenza: "+p3.getDatadiscadenza()+"data di acquisto: "
                    +p3.getDatadiacquisto()+"quantita: "+p3.getQuantita()+"prezzo: "+p3.getPrezzo());
            repository.save(p3);
        };
    }
}