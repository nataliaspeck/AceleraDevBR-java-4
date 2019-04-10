package challenge;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuoteDao {

	public Quote getQuote() throws SQLException {
	    String sql = "SELECT actor, detail FROM scripts " +
                "WHERE actor IS NOT NULL " +
                "ORDER BY RANDOM() LIMIT 1";
        Quote quote = new Quote();
        Connection con = null;
        try {
                con = ConnectionFactory.createConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    quote = new Quote(rs.getString("actor"), rs.getString("detail"));
                }
                rs.close();
                stmt.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
        return quote;
	}

	public Quote getQuoteByActor(String actor) throws SQLException {
        String sql = "SELECT actor, detail FROM scripts " +
                "WHERE actor = '" + actor + "' " +
                "ORDER BY RANDOM() LIMIT 1";
        Quote quote = new Quote();
        Connection con = null;
        try {
            con = ConnectionFactory.createConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                quote = new Quote(rs.getString("actor"), rs.getString("detail"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return quote;
	}

}