package carlos.robson.easyprice.Persistencia;

public class ExceptionDAO extends Exception {

    public ExceptionDAO() {
        super();
    }

    public ExceptionDAO(String mensagem) {
        super(mensagem);
    }

    public ExceptionDAO(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
