public class Automobile {

    private String targa;

    private Cliente proprietario;

    public Automobile() {

    }

    public Automobile(String targa, Cliente proprietario) {
        this.targa = targa;
        this.proprietario = proprietario;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public Cliente getProprietario() {
        return proprietario;
    }

    public void setProprietario(Cliente proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "targa='" + targa + '\'' +
                ", proprietario=" + proprietario +
                '}';
    }
}