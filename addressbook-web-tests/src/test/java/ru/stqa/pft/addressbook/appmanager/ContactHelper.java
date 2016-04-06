package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
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

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void clickEditContact(int index) {
    wd.findElements(By.name("selected[]")).get(index);
    click(By.xpath("//table[@id='maintable']/tbody/tr[" + (index + 2) + "]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void clickDeleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void confirmDeletion() {
    wd.switchTo().alert().accept();
  }

  public void createContact(ContactData contact) {
    openAddNewPage();
    fillContactData(contact);
    submitContactCreation();
    returnToHomePage();
  }

  public void returnToHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home page"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String name = element.getText();
      ContactData contact = new ContactData (name, null, null, null, null, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
