import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Archivio {

    private ArrayList<Automobile> automobili;

    private ArrayList<Cliente> proprietari;

    public Archivio() {

    }

    public Archivio(ArrayList<Automobile> automobili, ArrayList<Cliente> proprietari) {
        this.automobili = automobili;
        this.proprietari = proprietari;
    }

    public ArrayList<Automobile> getAutomobili() {
        return automobili;
    }

    public void setAutomobili(ArrayList<Automobile> automobili) {
        this.automobili = automobili;
    }

    public ArrayList<Cliente> getProprietari() {
        return proprietari;
    }

    public void setProprietari(ArrayList<Cliente> proprietari) {
        this.proprietari = proprietari;
    }

    private int indiceCliente(String cf) throws AssicurazioneException {
        int result = -1;
        if (cf == null) {
            throw new AssicurazioneException("Il parametro inserito è null");
        } else {
            for (int i = 0; i < proprietari.size(); i++) {
                if (proprietari.get(i).getCf().equals(cf)) {
                    result = i;
                }
            }
        }
        return result;
    }

    private int indiceTarga(String targa) throws AssicurazioneException {
        int result = -1;
        if (targa == null) {
            throw new AssicurazioneException("Il parametro inserito è null");
        } else {
            for (int i = 0; i < automobili.size(); i++) {
                if (automobili.get(i).getTarga().equals(targa)) {
                    result = i;
                }
            }
        }
        return result;
    }

    public void addCliente(String cf) throws AssicurazioneException {
        if (cf == null) {
            throw new AssicurazioneException("Il parametro inserito è null");
        } else {
            int result = indiceCliente(cf);
            if (result == -1) {
                Cliente cliente = new Cliente(cf);
                proprietari.add(cliente);
            }
        }
    }

    public String readCliente(String cf) throws AssicurazioneException {
        String result = null;
        if (cf == null) {
            throw new AssicurazioneException("Il parametro inserito è null");
        } else {
            for (int i = 0; i < proprietari.size(); i++) {
                if (proprietari.get(i).getCf().equals(cf)) {
                    result = proprietari.get(i).getCf();
                }
            }
        }
        return result;
    }

    public List<String> readClienti() throws AssicurazioneException {
        if (proprietari == null) {
            throw new AssicurazioneException("La lista dei proprietari non è stata inizializzata");
        }

        List<String> clienti = new ArrayList<>();
        for (Cliente cliente : proprietari) {
            if (cliente != null && cliente.getCf() != null) {
                clienti.add(cliente.getCf());
            }
        }
        return clienti;
    }

    public Cliente modificaCliente(String cf, String newCF) throws AssicurazioneException {
        if (cf == null || newCF == null) {
            throw new AssicurazioneException("I parametri inseriti non possono essere null");
        }
        for (Cliente cliente : proprietari) {
            if (Objects.equals(cliente.getCf(), cf)) {
                cliente.setCf(newCF);
                return cliente;
            }
        }
        return null;
    }

    public void removeCliente(String cf) throws AssicurazioneException {
        if (cf == null) {
            throw new AssicurazioneException("Il parametro inserito è null");
        } else {
            int indice = indiceCliente(cf);
            if (indice >= 0) {
                proprietari.remove(indice);
                for (int i = 0; i < automobili.size(); i++) {
                    if (automobili.get(i).getProprietario().getCf().equals(cf)) {
                        automobili.remove(i);
                    }
                }
            }
        }
    }

    public void addAutomobile(String targa, String cf) throws AssicurazioneException {
        if (targa == null || cf == null) {
            throw new AssicurazioneException("Uno dei parametri inseriti è null");
        } else {
            int result = indiceTarga(targa);
            if (result == -1) {
                Automobile automobile = new Automobile(targa, new Cliente(cf));
                automobili.add(automobile);
            }
        }
    }

    public String readMacchina(String targa) throws AssicurazioneException {
        String result = null;
        if (targa == null) {
            throw new AssicurazioneException("Il parametro inserito è null");
        } else {
            for (int i = 0; i < automobili.size(); i++) {
                if (automobili.get(i).getTarga().equals(targa)) {
                    result = automobili.get(i).getTarga();
                }
            }
        }
        return result;
    }

    public List<String> readMacchine() throws AssicurazioneException {
        if (automobili == null) {
            throw new AssicurazioneException("La lista delle automobili non è stata inizializzata");
        }

        List<String> macchine = new ArrayList<>();
        for (Automobile automobile : automobili) {
            if (automobile != null && automobile.getTarga() != null) {
                macchine.add(automobile.getTarga());
            }
        }
        return macchine;
    }

    public Automobile modificaAutomobile(String targa, String newTarga, Cliente proprietario, Cliente newProprietario) throws AssicurazioneException {
        if (targa == null || proprietario == null) {
            throw new AssicurazioneException("I parametri inseriti non possono essere null");
        }
        for (Automobile automobile : automobili) {
            if (Objects.equals(automobile.getTarga(), targa)) {
                automobile.setTarga(newTarga);
                automobile.setProprietario(newProprietario);
                return automobile;
            }
        }
        return null;
    }

    public void removeAutomobile(String targa) throws AssicurazioneException {
        if (targa == null) {
            throw new AssicurazioneException("Il parametro inserito è null");
        } else {
            int indice = indiceTarga(targa);
            if (indice >= 0) {
                automobili.remove(indice);
            }
        }
    }

    public ArrayList<String> returnTarga(String cf) throws AssicurazioneException {
        if (cf == null) {
            throw new AssicurazioneException("Il parametro inserito è null");
        }

        ArrayList<String> targhe = new ArrayList<>();
        for (Automobile auto : automobili) {
            if (auto.getProprietario().getCf().equals(cf)) {
                targhe.add(auto.getTarga());
            }
        }
        return targhe;
    }

    public String clienteTarga(String targa) throws AssicurazioneException {
        String result = null;
        if (targa == null) {
            throw new AssicurazioneException("Il parametro inserito è null");
        } else {
            for (int i = 0; i < automobili.size(); i++) {
                if (automobili.get(i).getTarga().equals(targa)) {
                    result = automobili.get(i).getProprietario().getCf();
                }
            }
        }
        return result;
    }

    public int contaAuto(String cf) throws AssicurazioneException {
        int count = 0;
        if (cf == null) {
            throw new AssicurazioneException("Il parametro inserito è null");
        } else {
            for (int i = 0; i < automobili.size(); i++) {
                if (automobili.get(i).getProprietario().getCf().equals(cf)) {
                    count++;
                }
            }
        }
        return count;
    }

}