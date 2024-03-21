public class Person {
    private String firstName;
    private String lastName;

    public String endService(){
        return  "CheckIn/CheckOut/Acompanhamento finalizado!";
    }

    public Person(String firstName, String lastName) {
    }

    public Person() {

    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public void setFullName(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }


}
