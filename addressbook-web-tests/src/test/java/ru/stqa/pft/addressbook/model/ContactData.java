package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name = "addressbook")
public class ContactData {

  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "firstname")
  private String userFirstName;

  @Transient
  private String userMiddleName;

  @Expose
  @Column(name = "lastname")
  private String userLastName;

  @Transient
  private String userNick;

  @Transient
  private String userCompany;

  @Expose
  @Type(type = "text")
  @Column(name = "address")
  private String userAddress;

  @Expose
  @Type(type = "text")
  @Column(name = "home")
  private String userHomePhone;

  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String userMobilePhone;

  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private String userWorkPhone;

  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String userEmail;

  @Expose
  @Column(name = "email2")
  @Type(type = "text")
  private String userEmail2;

  @Expose
  @Column(name = "email3")
  @Type(type = "text")
  private String userEmail3;

  @Transient
  private String allPhones;

  @Transient
  private String allEmails;

  @Transient
  private String allData;

  @Transient
  private String userFirstAndLastNames;

  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  public File getPhoto() {
    return new File(photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public String getUserFirstAndLastNames() {
    return userFirstAndLastNames;
  }

  public ContactData withUserFirstAndLastNames(String userFirstAndLastNames) {
    this.userFirstAndLastNames = userFirstAndLastNames;
    return this;
  }

  public String getAllData() {
    return allData;
  }

  public ContactData withAllData(String allData) {
    this.allData = allData;
    return this;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public ContactData withUserEmail(String userEmail) {
    this.userEmail = userEmail;
    return this;
  }

  public String getUserEmail2() {
    return userEmail2;
  }

  public ContactData withUserEmail2(String userEmail2) {
    this.userEmail2 = userEmail2;
    return this;
  }

  public String getUserEmail3() {
    return userEmail3;
  }

  public ContactData withUserEmail3(String userEmail3) {
    this.userEmail3 = userEmail3;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getUserFirstName() {
    return userFirstName;
  }

  public String getUserMiddleName() {
    return userMiddleName;
  }

  public String getUserLastName() {
    return userLastName;
  }

  public String getUserNick() {
    return userNick;
  }

  public String getUserCompany() {
    return userCompany;
  }

  public String getUserAddress() {
    return userAddress;
  }

  public String getUserHomePhone() {
    return userHomePhone;
  }

  public String getUserMobilePhone() {
    return userMobilePhone;
  }

  public String getUserWorkPhone() {
    return userWorkPhone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (userFirstName != null ? !userFirstName.equals(that.userFirstName) : that.userFirstName != null) return false;
    return userLastName != null ? userLastName.equals(that.userLastName) : that.userLastName == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (userFirstName != null ? userFirstName.hashCode() : 0);
    result = 31 * result + (userLastName != null ? userLastName.hashCode() : 0);
    return result;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", userFirstName='" + userFirstName + '\'' +
            ", userLastName='" + userLastName + '\'' +
            '}';
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withUserFirstName(String userFirstName) {
    this.userFirstName = userFirstName;
    return this;
  }

  public ContactData withUserMiddleName(String userMiddleName) {
    this.userMiddleName = userMiddleName;
    return this;
  }

  public ContactData withUserLastName(String userLastName) {
    this.userLastName = userLastName;
    return this;
  }

  public ContactData withUserNick(String userNick) {
    this.userNick = userNick;
    return this;
  }

  public ContactData withUserCompany(String userCompany) {
    this.userCompany = userCompany;
    return this;
  }

  public ContactData withUserAddress(String userAddress) {
    this.userAddress = userAddress;
    return this;
  }

  public ContactData withUserHomePhone(String userHomePhone) {
    this.userHomePhone = userHomePhone;
    return this;
  }

  public ContactData withUserMobilePhone(String userMobilePhone) {
    this.userMobilePhone = userMobilePhone;
    return this;
  }

  public ContactData withUserWorkPhone(String userWorkPhone) {
    this.userWorkPhone = userWorkPhone;
    return this;
  }
}


