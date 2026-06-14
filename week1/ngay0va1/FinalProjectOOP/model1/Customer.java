package model1;
public class Customer extends Person{
    private String membershipLevel;

    public Customer(int id, String name, String mail, String membershipLevel){
        super(id, name, mail);
        this.membershipLevel = membershipLevel;
    }

    public String getMembershipLevel(){
        return membershipLevel;
    }

    public void setMembershipLevel(String membershipLevel){
        this.membershipLevel = membershipLevel;
    }

    @Override
    public void displayInfo(){
        System.out.println(this);
        // this là object hiện tại
        // khi mà println(object) thì java tự gọi object.toString ();
        // nên this là dag gọi this.toString();
    }
    @Override
    public String toString(){
        return "Customer{ id: " + getId() + ", name: " + getName() + ", email: " + getMail() +  ", membershipLevel: " + membershipLevel + " }"; 
    }
}