package it.devlec.esame.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Prodotto {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private Date datadiscadenza;
    private Date datadiacquisto;
    private float prezzo;
    private float quantita;

    public Prodotto(){}

    public Prodotto(String nome, Date datadiscadenza, Date datadiacquisto, float prezzo, float quantita) {
        this.nome = nome;
        this.datadiscadenza = datadiscadenza;
        this.datadiacquisto = datadiacquisto;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    public Prodotto(String nome, float prezzo) {
        this.nome = nome;
        this.datadiscadenza = datadiscadenza;
        this.datadiacquisto = datadiacquisto;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatadiscadenza() {
        return datadiscadenza;
    }

    public void setDatadiscadenza(Date datadiscadenza) {
        this.datadiscadenza = datadiscadenza;
    }

    public Date getDatadiacquisto() {
        return datadiacquisto;
    }

    public void setDatadiacquisto(Date datadiacquisto) {
        this.datadiacquisto = datadiacquisto;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public float getQuantita() {
        return quantita;
    }

    public void setQuantita(float quantita) {
        this.quantita = quantita;
    }
}