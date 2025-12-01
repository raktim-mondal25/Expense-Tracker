import java.util.List;

public class ExpenseService {
    ExpenseDAO dao = new ExpenseDAO();

    public void addExpense(double amount, String category, String desc, String date) {
        dao.addExpense(new Expense(amount, category, desc, date));
        System.out.println("Expense Added Successfully!\n");
    }

    public void showAll() {
        List<Expense> list = dao.getAllExpenses();

        System.out.println("\n-------- All Expenses --------");
        for (Expense e : list) {
            System.out.println(e.getId() + " | ₹" + e.getAmount() + " | " + e.getCategory() +
                    " | " + e.getDescription() + " | " + e.getDate());
        }
    }

    public void showByCategory(String category) {
        List<Expense> list = dao.getByCategory(category);

        System.out.println("\n-------- Category: " + category + " --------");
        for (Expense e : list) {
            System.out.println(e.getId() + " | ₹" + e.getAmount() + " | " + e.getDescription());
        }
    }

    public void showMonthlyTotal(String month) {
        double total = dao.getMonthlyTotal(month);
        System.out.println("\nTotal for " + month + " = ₹" + total);
    }

    public void deleteExpense(int id) {
        dao.deleteExpense(id);
        System.out.println("Expense Deleted!\n");
    }
}
