package Record;

public record Customer(int customerId, String customerName, String customerEmail, String customerAddress) {
    public Customer {
        if(customerId <= 0){
            throw new IllegalArgumentException();
        }
    }
    private static int discount = 10;
    public int customerId(){
        System.out.println("Inside public accessor method customerId");
        return this.customerId;
    }
    public int displayId() {
        System.out.println("This method returns customerId");
        return this.customerId;
    }
}
