package tomcat;

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

/**
 * Created by Sergey on 24.05.2016.
 */
@WebServlet(name = "EditUserServlet", description = "EditUserServlet",
        urlPatterns = { "/EditUser"})
public class EditUserServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        String userName = request.getParameter("userName");
        String userSecondName = request.getParameter("userSecondName");
        String gender = request.getParameter("gender");
        String info = request.getParameter("info");
        Integer age = Integer.valueOf(request.getParameter("age"));

        SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, userId);
        user.setUsersName(userName);
        user.setUsersSecondName(userSecondName);
        user.setUsersAge(age);
        user.setUsersGender(gender);
        user.setUsersInfo(info);
        session.getTransaction().commit();
        session.getSessionFactory().close();
    }
}
