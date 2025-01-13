package Sealed;

sealed class Employee {
		void displayEmployee() {
			System.out.println("Inside the Employee class");
		}
}

sealed class PermanentEmployee extends Employee{
	void displayPermanentEmployee() {
		System.out.println("Inside the Permanent Employee class");
	}
}

final class ContractEmployee extends PermanentEmployee{
	void displayContractEmployee() {
		System.out.println("Inside the Contract Employee class");
	}
}

class Client{
	
	public static void main(String[] args) {
		
		ContractEmployee ce = new ContractEmployee();
		ce.displayEmployee();
		ce.displayPermanentEmployee();
		ce.displayContractEmployee();
			
	}
}
