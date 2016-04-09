package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id;
  private final String userFirstName;
  private final String userMiddleName;
  private final String userLastName;
  private final String userNick;
  private final String userCompany;
  private final String userAddress;
  private final String userHomePhone;
  private final String userMobilePhone;
  private final String userWorkPhone;

  public ContactData(int id, String userFirstName, String userMiddleName, String userLastName, String userNick, String userCompany, String userAddress, String userHomePhone, String userMobilePhone, String userWorkPhone) {
    this.id = id;
    this.userFirstName = userFirstName;
    this.userMiddleName = userMiddleName;
    this.userLastName = userLastName;
    this.userNick = userNick;
    this.userCompany = userCompany;
    this.userAddress = userAddress;
    this.userHomePhone = userHomePhone;
    this.userMobilePhone = userMobilePhone;
    this.userWorkPhone = userWorkPhone;
  }

  public ContactData(String userFirstName, String userMiddleName, String userLastName, String userNick, String userCompany, String userAddress, String userHomePhone, String userMobilePhone, String userWorkPhone) {
    this.id = Integer.MAX_VALUE;
    this.userFirstName = userFirstName;
    this.userMiddleName = userMiddleName;
    this.userLastName = userLastName;
    this.userNick = userNick;
    this.userCompany = userCompany;
    this.userAddress = userAddress;
    this.userHomePhone = userHomePhone;
    this.userMobilePhone = userMobilePhone;
    this.userWorkPhone = userWorkPhone;
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
}


