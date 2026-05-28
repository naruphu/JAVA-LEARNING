class BankAccount{
    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(){
        accountNumber = "";
        ownerName = "";
        balance = 0.0;
    }
    public BankAccount(String accountNumber, String ownerName, double Initialbalance){
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if(Initialbalance < 0) this.balance = 0;
        else this.balance = Initialbalance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }
    public String getOwnerName(){
        return ownerName;
    }
    public double getBalance(){
        return balance;
    }
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }


    void deposit(double amount){
        if(amount > 0){
            balance += amount;
        }
        else System.out.println("Invalid");
    }

    void withdraw(double amount){
        if(amount <= 0) System.out.println("Not suitable");
        else if(amount > balance) System.out.println("Too much");
        else balance -= amount;
    }

    void transferTo(BankAccount receiver, double amount){
        if (amount <= 0) {
        System.out.println("Not suitable");
        } else if (amount > balance) {
            System.out.println("Too much");
        } else {
            receiver.balance += amount;
            balance -= amount;
        }
    }

    public String printInfo(){
        return "TAI KHOAN: " + ownerName + ", " + accountNumber + ", " + balance;
    }

    boolean isRich(){
        return balance >= 10000000l;
    }




}