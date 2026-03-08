package Model;

public class ExpenseModel {

	
	int id;
	int monthyear;
	double amount;
	double expense;
	public ExpenseModel(int id, int monthyear, double amount, double expense) {
		super();
		this.id = id;
		this.monthyear = monthyear;
		this.amount = amount;
		this.expense = expense;
	}
	@Override
	public String toString() {
		return "ExpenseModel [id=" + id + ", monthyear=" + monthyear + ", amount=" + amount + ", expense=" + expense
				+ "]";
	}
	
	
	
}
