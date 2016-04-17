package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
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
    type(By.name("lastname"),contactData.getUserLastName());
    type(By.name("address"),contactData.getUserAddress());
    type(By.name("home"),contactData.getUserHomePhone());
    type(By.name("mobile"),contactData.getUserMobilePhone());
    type(By.name("work"),contactData.getUserWorkPhone());
    type(By.name("email"),contactData.getUserEmail());
    type(By.name("email2"),contactData.getUserEmail2());
    type(By.name("email3"),contactData.getUserEmail3());
  }

  public void openAddNewPage() {
    click(By.linkText("ADD_NEW"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='"+ id +"']")).click();
  }

  public void clickEditContactById(int id) {
    wd.findElement(By.xpath("//input[@id='"+ id +"']/../../td[8]/a/img")).click();
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

  public void create(ContactData contact) {
    openAddNewPage();
    fillContactData(contact);
    submitContactCreation();
    contactCache = null;
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    clickEditContactById(contact.getId());
    fillContactData(contact);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    clickDeleteContact();
    contactCache = null;
    confirmDeletion();
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

  private Contacts contactCache = null;

   public Contacts all() {
     if (contactCache != null) {
       return new Contacts(contactCache);
     }
     contactCache = new Contacts();
     List<WebElement> elements = wd.findElements(By.name("entry"));
     for (WebElement element : elements) {
       String lastName = element.findElement(By.xpath("td[2]")).getText();
       String firstName = element.findElement(By.xpath("td[3]")).getText();
       String allPhones = element.findElement(By.xpath("td[6]")).getText();
       String allEmails = element.findElement(By.xpath("td[5]")).getText();
       String address = element.findElement(By.xpath("td[4]")).getText();
       int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
       contactCache.add(new ContactData().withId(id).withUserFirstName(firstName).withUserLastName(lastName)
               .withAllPhones(allPhones).withAllEmails(allEmails).withUserAddress(address));
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    clickEditContactById(contact.getId());
    String userFirstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String userLastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String userHomePhone = wd.findElement(By.name("home")).getAttribute("value");
    String userMobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
    String userWorkPhone = wd.findElement(By.name("work")).getAttribute("value");
    String userEmail = wd.findElement(By.name("email")).getAttribute("value");
    String userEmail2 = wd.findElement(By.name("email2")).getAttribute("value");
    String userEmail3 = wd.findElement(By.name("email3")).getAttribute("value");
    String userAddress = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withUserFirstName(userFirstName).withUserLastName(userLastName)
            .withUserHomePhone(userHomePhone).withUserMobilePhone(userMobilePhone).withUserWorkPhone(userWorkPhone)
            .withUserEmail(userEmail).withUserEmail2(userEmail2).withUserEmail3(userEmail3).withUserAddress(userAddress);
  }

  public ContactData infoFromEditFormModified(ContactData contact) {
    clickEditContactById(contact.getId());
    String userFirstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String userLastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String userHomePhone = "H: " + wd.findElement(By.name("home")).getAttribute("value");
    String userMobilePhone = "M: " + wd.findElement(By.name("mobile")).getAttribute("value");
    String userWorkPhone = "W: " + wd.findElement(By.name("work")).getAttribute("value") + "\n";
    String userEmail = wd.findElement(By.name("email")).getAttribute("value");
    String userEmail2 = wd.findElement(By.name("email2")).getAttribute("value");
    String userEmail3 = wd.findElement(By.name("email3")).getAttribute("value");
    String userAddress = wd.findElement(By.name("address")).getAttribute("value") + "\n";
    String userFirstAndLastNames = userFirstName.concat(" ").concat(userLastName);
    wd.navigate().back();
    clickDetailsContactById(contact.getId());
    String domain1 = wd.findElement(By.xpath("//div[@id='content']//a[2]")).getText();
    String domain2 = wd.findElement(By.xpath("//div[@id='content']//a[4]")).getText();
    String domain3 = wd.findElement(By.xpath("//div[@id='content']//a[6]")).getText();
    userEmail = userEmail.concat(" (").concat(domain1).concat(")");
    userEmail2 = userEmail2.concat(" (").concat(domain2).concat(")");
    userEmail3 = userEmail3.concat(" (").concat(domain3).concat(")");
    wd.navigate().back();

    return new ContactData().withId(contact.getId()).withUserFirstAndLastNames(userFirstAndLastNames)
            .withUserAddress(userAddress).withUserHomePhone(userHomePhone).withUserMobilePhone(userMobilePhone)
            .withUserWorkPhone(userWorkPhone).withUserEmail(userEmail).withUserEmail2(userEmail2).withUserEmail3(userEmail3);
  }

  public ContactData infoFromDetailsForm(ContactData contact) {
    clickDetailsContactById(contact.getId());
    String allData = wd.findElement(By.id("content")).getText();
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withAllData(allData);
  }

  private void clickDetailsContactById(int id) {
    wd.findElement(By.xpath("//input[@id='"+ id +"']/../../td[7]/a/img")).click();
  }
}
