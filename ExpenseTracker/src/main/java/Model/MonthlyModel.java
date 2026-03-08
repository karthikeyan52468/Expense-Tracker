package Model;

public class MonthlyModel {

	int id;
	String name;
	double amount;
	double expense;
	int monthyear;
	public MonthlyModel(int id, String name, double amount, int monthyear) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
	
		this.monthyear = monthyear;
	}
	@Override
	public String toString() {
		return "ExpenseModel [id=" + id + ", name=" + name + ", amount=" + amount + ", expense=" + expense
				+ ", monthyear=" + monthyear + "]";
	}
	
	
	
}
