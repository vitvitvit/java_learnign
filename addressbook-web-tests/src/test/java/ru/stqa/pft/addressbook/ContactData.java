package ru.stqa.pft.addressbook;

public class ContactData {
  private final String userFirstName;
  private final String userMiddleName;
  private final String userLastName;
  private final String userNick;
  private final String userCompany;
  private final String userAddress;
  private final String userHomePhone;
  private final String userMobilePhone;
  private final String userWorkPhone;

  public ContactData(String userFirstName, String userMiddleName, String userLastName, String userNick, String userCompany, String userAddress, String userHomePhone, String userMobilePhone, String userWorkPhone) {
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
}
