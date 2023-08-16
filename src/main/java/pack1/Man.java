package pack1;
public class Man extends Person {
    public Man(String firstName, String lastName, int age, Person partner) {
        super(firstName, lastName, age, partner);
    }
    @Override
    public boolean isRetired() {
        if (age < 65) {
            return super.isRetired();
        } else
            return true;
    }

    public void registerPartnership() {}
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

}