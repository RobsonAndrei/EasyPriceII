package carlos.robson.easyprice.Persistencia;

public class SupermercadoDTO {

    private int idSupermercado;
    private long cpf;
    private String nome;
    private String latitude;
    private String longitude;
    private long telefone;

    public int getIdSupermercado() {
        return idSupermercado;
    }

    public long getCpf() {
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

    public void setIdSupermercado(int idSupermercado) {
        this.idSupermercado = idSupermercado;
    }

    public void setCpf(long cpf) {
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
