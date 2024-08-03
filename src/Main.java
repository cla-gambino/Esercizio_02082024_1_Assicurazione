import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws AssicurazioneException {

        Archivio archivio = new Archivio(new ArrayList<>(), new ArrayList<>());
        int scelta = -1;

        while (scelta != 0) {
            String inputScelta = JOptionPane.showInputDialog("MENU GESTIONE ASSICURAZIONE" +
                    "\n1) Inserisci un nuovo cliente " +
                    "\n2) Visualizza un cliente " +
                    "\n3) Visualizza tutti i clienti" +
                    "\n4) Modifica un cliente" +
                    "\n5) Elimina un cliente" +
                    "\n6) Inserisci una nuova automobile" +
                    "\n7) Visualizza un automobile" +
                    "\n8) Visualizza tutte le automobili" +
                    "\n9) Modifica un automobile" +
                    "\n10) Elimina un automobile" +
                    "\n11) Visualizza le automobili di un unico proprietario" +
                    "\n12) Visualizza il proprietario di un automobile" +
                    "\n13) Visualizza il numero di automobili di un proprietario" +
                    "\n0) Esci"
            );

            if (inputScelta == null || inputScelta.trim().isEmpty()) {
                scelta = -1;
            } else {
                try {
                    scelta = Integer.parseInt(inputScelta);
                } catch (NumberFormatException e) {
                    scelta = -1;
                }
            }

            switch (scelta) {

                case 1: {
                    String codiceFiscale = JOptionPane.showInputDialog("Inserisci il codice fiscale");
                    archivio.addCliente(codiceFiscale);
                    if (codiceFiscale == null) {
                        JOptionPane.showMessageDialog(null, "Il cliente non può essere inserito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente inserito correttamente");
                        break;
                    }
                }

                case 2: {
                    String codiceFiscale = JOptionPane.showInputDialog("Inserisci il codice fiscale");
                    StringBuilder messaggio = new StringBuilder();
                    String cliente = archivio.readCliente(codiceFiscale);
                    messaggio.append("Cliente: ")
                            .append(cliente);
                    JOptionPane.showMessageDialog(null, messaggio.toString());
                    break;
                }

                case 3: {
                    StringBuilder messaggio = new StringBuilder();
                    List<String> clienti = archivio.readClienti();
                    messaggio.append("Lista dei clienti: ")
                            .append(clienti);
                    JOptionPane.showMessageDialog(null, messaggio.toString());
                    break;
                }

                case 4: {
                    String vecchioCodiceFiscale = JOptionPane.showInputDialog("Inserisci il codice fiscale del cliente da modificare");
                    String nuovoCodiceFiscale = JOptionPane.showInputDialog("Inserisci il nuovo codice fiscale del cliente");

                    try {
                        Cliente clienteModificato = archivio.modificaCliente(vecchioCodiceFiscale, nuovoCodiceFiscale);
                        if (clienteModificato != null) {
                            JOptionPane.showMessageDialog(null, "Cliente modificato correttamente: " + clienteModificato.getCf());
                        } else {
                            JOptionPane.showMessageDialog(null, "Cliente non trovato");
                        }
                    } catch (AssicurazioneException e) {
                        JOptionPane.showMessageDialog(null, "Errore durante la modifica del cliente: " + e.getMessage());
                    }
                    break;
                }

                case 5: {
                    String cliente = JOptionPane.showInputDialog("Inserisci il codice fiscale del cliente da eliminare");
                    archivio.removeCliente(cliente);
                    if (cliente == null) {
                        JOptionPane.showMessageDialog(null, "Il cliente non può essere eliminato");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente eliminato correttamente");
                        break;
                    }
                }

                case 6: {
                    String targa = JOptionPane.showInputDialog("Inserisci la targa dell'automobile");
                    String cf = JOptionPane.showInputDialog("Inserisci il codice fiscale del proprietario dell'automobile");
                    archivio.addAutomobile(targa, cf);
                    if (targa == null || cf == null) {
                        JOptionPane.showMessageDialog(null, "L'automobile non può essere inserita");
                    } else {
                        JOptionPane.showMessageDialog(null, "Automobile inserita correttamente");
                        break;
                    }
                }

                case 7: {
                    String targa = JOptionPane.showInputDialog("Inserisci la targa dell' automobile");
                    StringBuilder messaggio = new StringBuilder();
                    String automobile = archivio.readMacchina(targa);
                    messaggio.append("Automobile: ")
                            .append(automobile);
                    JOptionPane.showMessageDialog(null, messaggio.toString());
                    break;
                }

                case 8: {
                    StringBuilder messaggio = new StringBuilder();
                    List<String> automobili = archivio.readMacchine();
                    messaggio.append("Lista delle automobili: ")
                            .append(automobili);
                    JOptionPane.showMessageDialog(null, messaggio.toString());
                    break;
                }

                case 9: {
                    String vecchiaTarga = JOptionPane.showInputDialog("Inserisci la targa dell' automobile da modificare");
                    String nuovaTarga = JOptionPane.showInputDialog("Inserisci la nuova targa dell'automobile");
                    String vecchioCodiceFiscale = JOptionPane.showInputDialog("Inserisci il codice fiscale del cliente da modificare");
                    String nuovoCodiceFiscale = JOptionPane.showInputDialog("Inserisci il nuovo codice fiscale del cliente");
                    Cliente vecchioCliente = new Cliente(vecchioCodiceFiscale);
                    Cliente nuovoCliente = new Cliente(nuovoCodiceFiscale);

                    try {
                        Automobile automobileModificata = archivio.modificaAutomobile(vecchiaTarga, nuovaTarga, vecchioCliente, nuovoCliente);
                        if (automobileModificata != null) {
                            JOptionPane.showMessageDialog(null, "Automobile modificata correttamente!" + "\nNuova targa: " + automobileModificata.getTarga() + "\n" + automobileModificata.getProprietario());
                        } else {
                            JOptionPane.showMessageDialog(null, "Automobile non trovata");
                        }
                    } catch (AssicurazioneException e) {
                        JOptionPane.showMessageDialog(null, "Errore durante la modifica dell'automobile: " + e.getMessage());
                    }
                    break;
                }

                case 10: {
                    String automobile = JOptionPane.showInputDialog("Inserisci la targa dell'automobile da eliminare");
                    archivio.removeAutomobile(automobile);
                    if (automobile == null) {
                        JOptionPane.showMessageDialog(null, "L'automobile non può essere eliminato");
                    } else {
                        JOptionPane.showMessageDialog(null, "Automobile eliminata correttamente");
                        break;
                    }
                }

                case 11: {
                    String cf = JOptionPane.showInputDialog("Inserisci il codice fiscale del proprietario dell'automobile");
                    if (cf == null || cf.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Il codice fiscale non può essere vuoto");
                    } else {
                        try {
                            ArrayList<String> targhe = archivio.returnTarga(cf);
                            if (targhe.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Nessuna automobile trovata per questo proprietario");
                            } else {
                                StringBuilder message = new StringBuilder("Targhe delle automobili del proprietario:\n");
                                for (String targa : targhe) {
                                    message.append(targa).append("\n");
                                }
                                JOptionPane.showMessageDialog(null, message.toString());
                            }
                        } catch (AssicurazioneException e) {
                            JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
                        }
                    }
                    break;
                }

                case 12: {
                    String targa = JOptionPane.showInputDialog("Inserisci la targa dell'automobile");
                    StringBuilder messaggio = new StringBuilder();
                    String proprietario = archivio.clienteTarga(targa);
                    messaggio.append("Il proprieatrio: ")
                            .append(proprietario);
                    JOptionPane.showMessageDialog(null, messaggio.toString());
                    break;

                }

                case 13: {
                    String cf = JOptionPane.showInputDialog("Inserisci il codice fiscale del proprietario dell'automobile");
                    StringBuilder messaggio = new StringBuilder();
                    String numeroMacchine = String.valueOf(archivio.contaAuto(cf));
                    messaggio.append("Il numero di automobili del proprietario è: ")
                            .append(numeroMacchine);
                    JOptionPane.showMessageDialog(null, messaggio.toString());
                    break;
                }
            }
        }
    }
}