package home.blackharold.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet()
public class ServletDBTest extends HttpServlet {

    private static final long serialVerisonUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        setup connection variables
        String DBDriver = "com.mysql.cj.jdbc.Driver";

        String user = "springstudent";
        String password = "springstudent";

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=Europe/Moscow";

        try {
            PrintWriter out = resp.getWriter();

            out.println("Connecting to db... ");
            Class.forName(DBDriver);

            System.out.println("url: " + jdbcUrl);
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            out.println("Connection is open? " + !connection.isClosed());
            connection.close();
            out.println("Connection is open? " + !connection.isClosed());

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
