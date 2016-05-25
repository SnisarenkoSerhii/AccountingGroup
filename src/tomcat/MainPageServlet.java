package tomcat;

import objects.GroupOfUsers;
import objects.Groups;
import objects.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Sergey on 20.05.2016.
 */
@WebServlet(name = "MainPage", description = "Main page",
        urlPatterns = { "/MainPage"})
public class MainPageServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Start page</title>\n" +

                "</head>\n" +
                "<body>\n" +
                "<h3>You can input new User here.</h3>\n" +
                "<form action=\"../HTML/InputUserPage.html\">\n" +
                "    <input type=\"submit\" value=\"Input\" />\n" +
                "</form>"+
                "<form action=\"/ShowAllUsersServlet\">\n" +
                "    <input type=\"submit\" value=\"ShowAllUsers\" />\n" +
                "</form>"+
                "</body>\n" +
                "</html>");
    }
}
