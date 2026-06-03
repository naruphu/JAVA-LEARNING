class CashPayment implements PaymentMethod{
    @Override
    public void pay(double amount){
        if(amount <= 0) System.out.println("Invalid");
        else System.out.println("Paid " + amount + "  by cash");
    }
}