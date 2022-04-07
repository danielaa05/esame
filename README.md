# esame finale
Esame finale di Daniela Madaro

## Proprietà
Applicazione basata su Spring boot con le seguenti funzioni:
- H2 in memoria
- Restifull API.

### Link github
https://github.com/danielaa05/esame.git

### Esempi di query con postman

| titolo                                | link postman                                                                     | metodi usati |
|---------------------------------------|----------------------------------------------------------------------------------|-- -----------|
| mostra tutti i prodotti               | http://localhost:8080/prodotto                                                   | GET          |
| trova un prodotto                     | http://localhost:8080/prodotto/3                                                 | GET          |
| aggiorna prodotto                     | http://localhost:8080/prodotto/2                                                 | PUT          |
| aggiunge un prodotto                  | http://localhost:8080/prodotto                                                   | POST         |
| cancella prodotto                     | http://localhost:8080/prodotto/2                                                 | DELETE       |
| trova prodotto dalla data di scadenza | http://localhost:8080/prodotto/ricercatradate?datada=29-04-2022&dataa=01-05-2022 | GET          |
| trova prodotto dalla data di acquisto | http://localhost:8080/prodotto/datadiacquisto?datada=20-04-2022&dataa=22-04-2022 | GET          |
| carica file                           | http://localhost:8080/caricafile                                                 | POST         |

![figure](esame2/esame/esame/img/mostraTutti.png "block diagram for NIDS")