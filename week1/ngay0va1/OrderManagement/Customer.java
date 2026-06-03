class Customer{
    private String id;
    private String name;
    private String phone;
    private String address;

    public Customer(String id, String name, String phone, String address){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }


    public void printInfo(){
        System.out.println(id + " - " + name + " - " + phone + " - " + address);
    }

    public String getInfo(){
        return id + " - " + name;
    }
}