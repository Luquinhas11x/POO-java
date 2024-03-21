public class Room {
    private int numberRoom;
    private int days;
    public Room(){

    }

    public Room(int days, int numberRoom) {
        this.days = days;
        this.numberRoom = numberRoom;
    }

    public int getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(int numberRoom) {
        this.numberRoom = numberRoom;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

}
