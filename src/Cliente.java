public class Cliente {

    private String cf;

    public Cliente() {

    }

    public Cliente(String cf) {
        this.cf = cf;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cf='" + cf + '\'' +
                '}';
    }
}