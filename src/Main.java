import objects.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by Sergey on 16.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setUsersAge(12);
        user.setUsersGender("male");
        user.setUsersName("NAME");
        user.setUsersSecondName("SecondNAME");

        User user2 = new User();
        user2.setUsersAge(1222);
        user2.setUsersGender("qwe");
        user2.setUsersName("NAwqeME");
        user2.setUsersSecondName("SecondwqeNAME");

        GroupOfUsers groupOfUsers = new GroupOfUsers();
        groupOfUsers.setGroupOfUsersName("Users");
        groupOfUsers.getGroupOfUsers().add(user);
        groupOfUsers.getGroupOfUsers().add(user2);

        Groups groups = new Groups();
        groups.setGroupName("Pupils");
        groups.getGroups().add(groupOfUsers);

        SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(groups);
        session.save(groupOfUsers);
        session.save(user);
        session.save(user2);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        user = (User) session.get(User.class, 3);
        System.out.println("name " + user.getUsersGender());
        System.out.println(user.getUsersName());
        session.getSessionFactory().close();

    }
}
