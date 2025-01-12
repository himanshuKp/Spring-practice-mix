package Basic;

public class ContructorPractice1 {
    private String bankName;
    private String area;
    private String phoneNo;

    ContructorPractice1(){
        bankName = "ibank";
        area = "gandhi nagar";
        phoneNo = "95986598";
    }

    ContructorPractice1(String bankName, String area, String phoneNo){
        this.bankName = bankName;
        this.area = area;
        this.phoneNo = phoneNo;
    }

    void displayBankDetails(){
        System.out.println("bank name: "+bankName);
        System.out.println("area: "+area);
        System.out.println("phone no: "+phoneNo);
    }

    public static void main(String[] args) {
        ContructorPractice1 bank2 = new ContructorPractice1("Ibank", "Jaydev nagar", "958856685");
        ContructorPractice1 bank1 = new ContructorPractice1();


        bank1.displayBankDetails();
        System.out.println("*****************");
        bank2.displayBankDetails();
    }
}
