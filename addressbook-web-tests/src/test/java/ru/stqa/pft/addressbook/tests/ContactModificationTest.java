package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{

  @Test
  public void testContactModification(){
    app.getNavigationHelper().openHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("firstname6", "middlename", "lastname", "nickname", "company", "address", "homephone", "mobilephone", null));
    }
    app.getContactHelper().clickEditContact();
    app.getContactHelper().fillContactData(new ContactData("firstnamemod", "middlename", "lastname", "nickname", "company", "address", "homephone", "mobilephone", "workphone"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }

}

