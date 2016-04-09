package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String userFirstName;
  private String userMiddleName;
  private String userLastName;
  private String userNick;
  private String userCompany;
  private String userAddress;
  private String userHomePhone;
  private String userMobilePhone;
  private String userWorkPhone;

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

    if (userFirstName != null ? !userFirstName.equals(that.userFirstName) : that.userFirstName != null) return false;
    return userLastName != null ? userLastName.equals(that.userLastName) : that.userLastName == null;

  }

  @Override
  public int hashCode() {
    int result = userFirstName != null ? userFirstName.hashCode() : 0;
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


