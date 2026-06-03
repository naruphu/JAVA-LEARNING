class BankTransferPayment implements PaymentMethod{
    private String bankName;
    private String bankNumber;

    public BankTransferPayment(String bankName, String bankNumber){
        this.bankName = bankName;
        this.bankNumber = bankNumber;
    }

    @Override
    public void pay(double amount){
        if(amount <= 0) System.out.println("Invalid");
        else{
            System.out.println("Paid " + amount + "  by transfer");
            System.out.println("Bank: " + bankName);
            System.out.println("Account " + bankNumber);
        }
    }
}