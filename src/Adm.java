import java.util.ArrayList;
import java.util.List;

public class Adm extends Person{
    String userID;
    String password;
    public Adm(){

    }

    public String endService(){
        return "Acompanhamento finalizado!";
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
