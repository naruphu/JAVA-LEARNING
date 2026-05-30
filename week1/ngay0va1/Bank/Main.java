class Main{
    public static void main(String[] args){
        BankAccount a1 = new BankAccount("0123", "Phu", 10000);
        BankAccount a2 = new BankAccount("0123", "Tam", 100000);
        System.out.println(a1.getAccountNumber());
        a1.withdraw(5000);
        System.out.println(a1.getBalance());
        a1.transferTo(a2, 3000);
        System.out.println(a2.getBalance());
        a1.withdraw(50000);
        System.out.println(a1.getBalance());
        System.out.println(a1.printInfo());
        System.out.println(a2.printInfo());
        System.out.println(a1.isRich());
        

    }
}