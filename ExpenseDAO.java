import java.sql.*;
import java.util.*;

public class ExpenseDAO {

    public void addExpense(Expense e) {
        String query = "INSERT INTO expenses(amount, category, description, date) VALUES(?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setDouble(1, e.getAmount());
            ps.setString(2, e.getCategory());
            ps.setString(3, e.getDescription());
            ps.setString(4, e.getDate());
            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Expense> getAllExpenses() {
        List<Expense> list = new ArrayList<>();
        String query = "SELECT * FROM expenses ORDER BY date DESC";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                list.add(new Expense(
                    rs.getInt("id"),
                    rs.getDouble("amount"),
                    rs.getString("category"),
                    rs.getString("description"),
                    rs.getString("date")
                ));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public double getMonthlyTotal(String month) {
        String query = "SELECT SUM(amount) FROM expenses WHERE date LIKE ?";
        double total = 0;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, month + "%");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) total = rs.getDouble(1);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return total;
    }

    public List<Expense> getByCategory(String category) {
        List<Expense> list = new ArrayList<>();
        String query = "SELECT * FROM expenses WHERE category=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Expense(
                    rs.getInt("id"),
                    rs.getDouble("amount"),
                    rs.getString("category"),
                    rs.getString("description"),
                    rs.getString("date")
                ));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void deleteExpense(int id) {
        String query = "DELETE FROM expenses WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
