public class Person {
    //declaring instance variables
    public String name;
    public int age;
    public int height;

//constructor
public Person(){
    this.name="NA";
    this.age = 0;
    this.height = 0;
}
//Setter or mutator
public void setName(String name){
    this.name = name;
}
public void setAge(int age){
    this.age = age;
}
public void setHeight(int Height){
    this.height = height;
}
// Getters
    public String getName(){
    return name;
    }
    public int getAge(){
    return age;
    }
    public int getHeight(){
    return height;
    }
}
class Runnable{
    public static void main(String[] args) {
        //Create an instance of Person
        Person person = new Person("OGI", 30, 6);
        Person person2 = new Person("Alican", 30, 6);
        Person person3 = new Person("Kaan", 30, 6);

        //set user info
        person.setName("OGI");
        person.setAge(30);
        person.setHeight(6);
        //get user info

        System.out.println("The name of the person is " + person.getName());
        System.out.println("The age of the person is " + person.getAge());
        System.out.println("The height of the person is " + person.getHeight());
    }
}