public class NormalRoom extends Room implements FinalPrice {

    private int availableRoom;

    private int unavailableRoom;

    public NormalRoom(int availableRoom, int unavailableRoom) {
        this.availableRoom = availableRoom;
        this.unavailableRoom = unavailableRoom;
    }

    public NormalRoom(){

    }

    public int getAvailableRoom() {
        return availableRoom;
    }

    public int getUnavailableRoom() {
        return unavailableRoom;
    }



    @Override
    public double valorTotal() {
        double total = 0;
        double normalPrice = 150.50;
        total = (getDays() * normalPrice);
        return total;
    }
}
