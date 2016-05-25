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
import java.util.Date;
import java.util.UUID;

/**
 * Created by Sergey on 20.05.2016.
 */
@WebServlet(name = "ShowUserServlet",  urlPatterns = { "/ShowUser"})
public class ShowUserServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String userSecondName = request.getParameter("userSecondName");
        String gender = request.getParameter("gender");
        String info = request.getParameter("info");
        Integer age = Integer.valueOf(request.getParameter("age"));


        User user = new User();
        user.setUsersName(userName);
        user.setUsersSecondName(userSecondName);
        user.setUsersAge(age);
        user.setUsersGender(gender);
        user.setUsersInfo(info);
        user.setDateOfRegistration(new Date());
        user.setAccount(UUID.randomUUID());


        GroupOfUsers groupOfUsers = new GroupOfUsers();
        groupOfUsers.setGroupOfUsersName("Users");
        groupOfUsers.getGroupOfUsers().add(user);

        Groups groups = new Groups();
        groups.setGroupName("Pupils");
        groups.getGroups().add(groupOfUsers);

        SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(groups);
        session.save(groupOfUsers);
        session.save(user);
        session.getTransaction().commit();
        session.close();
        session.getSessionFactory().close();

        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Simple WEb application</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h3>Hello</h3>\n" +
                        "<table border=\"1\" cellpadding=\"5\" cellspacing=\"0\" width=\"50%\">\n" +
                        "<tr>\n" +
                        "<td>Id</td>\n" +
                        "<td>Name</td>\n" +
                        "<td>SecondName</td>\n" +
                        "<td>Gender</td>\n" +
                        "<td>Age</td>\n" +
                        "<td>Info</td>\n" +
                        "<td>Date of registration</td>\n" +
                        "<td>Account UUID</td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "<td>" + user.getUsersId() + "</td>\n" +
                        "<td>" + userName + "</td>\n" +
                        "<td>"+ userSecondName +"</td>\n" +
                        "<td>"+ gender +"</td>\n" +
                        "<td>"+ age +"</td>\n" +
                        "<td>"+ info +"</td>\n" +
                        "<td>"+ user.getDateOfRegistration() +"</td>\n" +
                        "<td>"+ user.getAccount() +"</td>\n" +
                        "</tr>\n" +
                        "</table>" +

                "</body>\n" +
                "</html>"
        );

    }
}
