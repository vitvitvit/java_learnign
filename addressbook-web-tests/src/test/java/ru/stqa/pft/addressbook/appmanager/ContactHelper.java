package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super (wd);
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactData(ContactData contactData) {
    type(By.name("firstname"), contactData.getUserFirstName());
    type(By.name("middlename"), contactData.getUserMiddleName());
    type(By.name("lastname"),contactData.getUserLastName());
    type(By.name("nickname"),contactData.getUserNick());
    type(By.name("company"),contactData.getUserCompany());
    type(By.name("address"),contactData.getUserAddress());
    type(By.name("home"),contactData.getUserHomePhone());
    type(By.name("mobile"),contactData.getUserMobilePhone());
    type(By.name("work"),contactData.getUserWorkPhone());
  }

  public void openAddNewPage() {
    click(By.linkText("ADD_NEW"));
  }
}
