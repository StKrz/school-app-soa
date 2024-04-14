package gr.aueb.cf.schoolapp.model;

import java.io.Reader;

public class Student {
    private Integer id;
    private String firstname;
    private String lastname;
    private String gender;
    private String birthday;
    private int cityId;
    private int userId;

    private Student() {

    }

    public Student(Integer id, String firstname, String lastname, String gender, String birthday, int cityId, int userId) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.birthday = birthday;
        this.cityId = cityId;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender=" + gender +
                ", birthday='" + birthday + '\'' +
                ", cityId=" + cityId +
                ", userId=" + userId +
                '}';
    }
}
