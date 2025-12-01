import java.util.Scanner;

public class run {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExpenseService service = new ExpenseService();

        while (true) {
            System.out.println("\n===== Expense Tracker =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Monthly Total");
            System.out.println("4. Filter by Category");
            System.out.println("5. Delete Expense");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Category: ");
                    String cat = sc.nextLine();

                    System.out.print("Description: ");
                    String desc = sc.nextLine();

                    System.out.print("Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();

                    service.addExpense(amt, cat, desc, date);
                    break;

                case 2:
                    service.showAll();
                    break;

                case 3:
                    System.out.print("Enter Month (YYYY-MM): ");
                    String month = sc.nextLine();
                    service.showMonthlyTotal(month);
                    break;

                case 4:
                    System.out.print("Enter Category: ");
                    String c = sc.nextLine();
                    service.showByCategory(c);
                    break;

                case 5:
                    System.out.print("Enter ID to Delete: ");
                    int id = sc.nextInt();
                    service.deleteExpense(id);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
