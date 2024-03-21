import java.util.ArrayList;
import java.util.List;

public class Client  extends Person{
    private long cpf;
    private long rg;

    public Client() {

    }

    public String endService(){
        return "Atendimento finalizado!";
    }
    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }
}

