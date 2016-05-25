package objects;

import objects.GroupOfUsers;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sergey on 16.05.2016.
 */
@Entity
@Table(name = "GROUPS")
public class Groups {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int groupsId;
    @Column(name = "GROUP_NAME")
    private String groupName;
    @OneToMany
    private Set<GroupOfUsers> groups =  new HashSet<GroupOfUsers>();

    public int getGroupsId() {
        return groupsId;
    }

    public void setGroupsId(int groupsId) {
        this.groupsId = groupsId;
    }

    public Collection<GroupOfUsers> getGroups() {
        return groups;
    }

    public void setGroups(Set<GroupOfUsers> groups) {
        this.groups = groups;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
