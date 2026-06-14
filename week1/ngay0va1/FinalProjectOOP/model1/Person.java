package model1;
public abstract class Person{
    private int id;
    private String name;
    private String mail;

    public Person(int id, String name, String mail){
        this.id = id;
        this.name = name;
        this.mail = mail;
    }

    public abstract void displayInfo();

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getMail(){
        return mail;
    }

    public void setId(int id){
        this.id = id;
    }   

    public void setName(String name){
        this.name = name;
    }

    public void setMail(String mail){
        this.mail = mail;
    }

    @Override
    public String toString(){
        return "Person{ id: " + id + ", name: " + name + ", email: " + mail + " }"; 
    }

}