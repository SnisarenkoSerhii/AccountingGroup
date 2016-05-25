package tomcat;

import objects.GroupOfUsers;
import objects.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.management.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Sergey on 21.05.2016.
 */
@WebServlet(name = "ShowAllUsersServlet", description = "ShowAllUsersServlet",
        urlPatterns = { "/ShowAllUsersServlet"})
public class ShowAllUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        org.hibernate.Query query = session.createQuery("from User");
        List<User> users = (List<User>)query.list();

        PrintWriter writer = resp.getWriter();
        session.getTransaction().commit();
        session.close();

            writer.println(
                    "<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <title>AllUsers</title>\n" +
                            "<link href=\"CSS\\ShowAllUsersCSS.css\" rel=\"stylesheet\" type=\"text/css\">"+
                            "</head>\n" +
                            "<body>\n" +
                            "<table>\n" +
                            "    <tr>\n" +
                            "        <th>Id</th>\n" +
                            "        <th>Name</th>\n" +
                            "        <th>SecondName</th>\n" +
                            "        <th>Gender</th>\n" +
                            "        <th>Age</th>\n" +
                            "        <th>Info</th>\n" +
                            "        <th>Date of registration</th>\n" +
                            "        <th>Account UUID</th>\n" +
                            "    </tr>");
        for (User u : users) {
            writer.println("    <tr>\n" +
                            "        <td>" + u.getUsersId() + "</td>\n" +
                            "        <td>" + u.getUsersName() + "</td>\n" +
                            "        <td>" + u.getUsersSecondName() + "</td>\n" +
                            "        <td>" + u.getUsersGender() + "</td>\n" +
                            "        <td>" + u.getUsersAge() + "</td>\n" +
                            "        <td>" + u.getUsersInfo() + "</td>\n" +
                            "        <td>" + u.getDateOfRegistration() + "</td>\n" +
                            "        <td>" + u.getAccount() + "</td>\n" +
                            "    </tr>");
        }
        writer.println("</table>\n" +
                "<a href=\"../HTML/EditUser.html\">Edit user by Id</a>" +
                "</body>\n" +
                "</body>\n" +
                "</html>");


        session.getSessionFactory().close();


    }
}
