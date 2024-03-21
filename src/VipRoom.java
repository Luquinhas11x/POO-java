public class VipRoom extends Room implements FinalPrice {

    private int availableRoom;

    private int unavailableRoom;

    public VipRoom( int availableRoom, int unavailableRoom) {
        this.availableRoom = availableRoom;
        this.unavailableRoom = unavailableRoom;
    }

    public VipRoom(){

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
        double expensivePrice = 230.50;
        total =(getDays() * expensivePrice);
        return total;
    }


}
