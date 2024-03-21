import java.util.ArrayList;
import java.util.List;

public class HotelServer {
    private List<Client> checkIn = new ArrayList<>();
    private List<Client> checkOut = new ArrayList<>();


    public List<Client> getCheckIn(){
        return checkIn;
    }

    public void setCheckIn(List<Client> checkIn){
        this.checkIn = checkIn;
    }

    public void addCheckIn(Client checkInClient){
        this.checkIn.add(checkInClient);
    }

    public List<Client> getCheckOut(){
        return checkOut;
    }

    public void setCheckOut(List<Client> checkOut){
        this.checkOut = checkOut;
    }

    public void addCheckOut(Client checkOutClient){
        this.checkOut.add(checkOutClient);
    }
}
