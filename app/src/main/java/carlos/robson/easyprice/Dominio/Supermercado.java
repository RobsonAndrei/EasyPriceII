package carlos.robson.easyprice.Dominio;

public class Supermercado {

    private int idSupermercado;
    private String latitude;
    private String longitude;
    private long telefone;
    private String cpf;
    private String nome;

    //ID_SUPERMERCADO, LATITUDE, LONGITUDE, TELEFONE, CPF, NOME
    public Supermercado(String latitude, String longitude, long telefone, String cpf, String nome) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.telefone = telefone;
        this.cpf = cpf;
        this.nome = nome;
    }

    public Supermercado(int idSupermercado, String latitude, String longitude, long telefone, String cpf, String nome) {
        this.idSupermercado = idSupermercado;
        this.latitude = latitude;
        this.longitude = longitude;
        this.telefone = telefone;
        this.cpf = cpf;
        this.nome = nome;
    }

    public int getIdSupermercado() {
        return idSupermercado;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
}
