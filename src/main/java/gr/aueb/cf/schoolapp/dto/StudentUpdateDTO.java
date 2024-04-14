package gr.aueb.cf.schoolapp.dto;

public class StudentUpdateDTO extends BaseDTO {
    private String firstname;
    private String lastname;
    private String gender;
    private String birthday;
    private int cityId;
    private int userId;

    public StudentUpdateDTO() {

    }

    public StudentUpdateDTO(String firstname, String lastname, String gender, String birthday, int cityId, int userId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.birthday = birthday;
        this.cityId = cityId;
        this.userId = userId;
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
}
