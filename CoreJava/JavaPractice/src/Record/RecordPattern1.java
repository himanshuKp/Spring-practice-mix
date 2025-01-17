package Record;

public class RecordPattern1 {
    public static void main(String[] args) {
        Customer customer = new Customer(1001, "himanshu", "hk@hk.com", "998");
        checkRecordMatch(customer);
    }

    private static void checkRecordMatch(Object object) {
        if(object instanceof Customer(int customerId, String customerName, String customerEmail, String customerAddress)){
            System.out.println("username : "+customerName);
            System.out.println("email: "+customerEmail);
        }
    }
}
