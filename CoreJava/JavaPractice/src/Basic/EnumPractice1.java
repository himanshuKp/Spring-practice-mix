package Basic;

enum Designation{
    CEO(2), GeneralManager(4),RegionalManager(20),BranchManager(30);
    private final int noOfEmployees;
    Designation(int noOfEmployees){
        this.noOfEmployees = noOfEmployees;
    }
    public int getNoOfEmployees(){
        return noOfEmployees;
    }
}

public class EnumPractice1 {
    public void reportees(Designation designation){
        System.out.println(designation.getNoOfEmployees());
    }
    public static void main(String[] args) {
        EnumPractice1 bank = new EnumPractice1();
        bank.reportees(Designation.BranchManager);
    }
}
