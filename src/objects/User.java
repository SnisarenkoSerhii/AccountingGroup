package objects;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Sergey on 16.05.2016.
 */
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USERS_ID")
    private int usersId;
    @Column(name = "USERS_NAME")
    private String usersName;
    @Column(name = "USERS_SECOND_NAME")
    private String usersSecondName;
    @Column(name = "USERS_GENDER")
    private String usersGender;
    @Column(name = "USERS_AGE")
    private int usersAge;
    @Column(name = "USERS_INFO")
    private String usersInfo;
    @Column(name = "DATE_OF_REGISTRATION")
  //  @Temporal(TemporalType.DATE)
    private Date dateOfRegistration;
    @Column(name = "ACCOUNT_UUID")
    private UUID account;

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public String getUsersSecondName() {
        return usersSecondName;
    }

    public void setUsersSecondName(String usersSecondName) {
        this.usersSecondName = usersSecondName;
    }

    public String getUsersGender() {
        return usersGender;
    }

    public void setUsersGender(String usersGender) {
        this.usersGender = usersGender;
    }

    public int getUsersAge() {
        return usersAge;
    }

    public void setUsersAge(int usersAge) {
        this.usersAge = usersAge;
    }

    public String getUsersInfo() {
        return usersInfo;
    }

    public void setUsersInfo(String usersInfo) {
        this.usersInfo = usersInfo;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public UUID getAccount() {
        return account;
    }

    public void setAccount(UUID account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "User{" +
                "usersId=" + usersId +
                ", usersName='" + usersName + '\'' +
                ", usersSecondName='" + usersSecondName + '\'' +
                ", usersGender='" + usersGender + '\'' +
                ", usersAge=" + usersAge +
                ", usersInfo='" + usersInfo + '\'' +
                '}';
    }
}
