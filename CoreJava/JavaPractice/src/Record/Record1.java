package Record;

public class Record1 {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1001, "Himanshu", "hk@hk.com", "998, Sector 11");
        System.out.println(customer1);
        System.out.println(customer1.customerId()+" : "+customer1.customerEmail());
        System.out.println(customer1.customerId());
        System.out.println();
        System.out.println(customer1.displayId());
    }
}
