package org.mynah.brew.model;

import java.util.Date;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class Cadre {

    private Integer id;
    @NotNull(message = "姓名不能为空！")
    @Size(max = 100, message = "姓名最大长度为100")
    private String name;
    @NotNull(message = "部门不能为空！")
    private Integer department;
    private Integer gender;
    private Date birthday;
    @Size(max = 100, message = "民族最大长度为100")
    private String nation;
    @Size(max = 100, message = "籍贯最大长度为100")
    private String birthplace;
    private Integer appearance;
    private Integer education;
    @Size(max = 200, message = "毕业院校最大长度为200")
    private String graduate;
    @Size(max = 200, message = "专业最大长度为200")
    private String major;
    @Size(max = 200, message = "研究方向最大长度为200")
    private String research;
    @Size(max = 100, message = "电话最大长度为100")
    private String phone;
    @Size(max = 100, message = "电子邮件最大长度为100")
    private String email;
    @Size(max = 6, message = "邮编最大长度为6")
    private String zipcode;
    @Size(max = 300, message = "地址最大长度为300")
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public Integer getAppearance() {
        return appearance;
    }

    public void setAppearance(Integer appearance) {
        this.appearance = appearance;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public String getGraduate() {
        return graduate;
    }

    public void setGraduate(String graduate) {
        this.graduate = graduate;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
