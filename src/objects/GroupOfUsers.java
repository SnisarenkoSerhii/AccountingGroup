package objects;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Sergey on 16.05.2016.
 */

@Entity
@Table(name = "GROUP_OF_USERS")
public class GroupOfUsers {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int groupOfUsersId;
    private String groupOfUsersName;
    @OneToMany
    private Collection<User> groupOfUsers = new ArrayList<User>();

    public int getGroupOfUsersId() {
        return groupOfUsersId;
    }

    public void setGroupOfUsersId(int groupOfUsersId) {
        this.groupOfUsersId = groupOfUsersId;
    }

    public String getGroupOfUsersName() {
        return groupOfUsersName;
    }

    public void setGroupOfUsersName(String groupOfUsersName) {
        this.groupOfUsersName = groupOfUsersName;
    }

    public Collection<User> getGroupOfUsers() {
        return groupOfUsers;
    }

    public void setGroupOfUsers(Collection<User> groupOfUsers) {
        this.groupOfUsers = groupOfUsers;
    }
}

