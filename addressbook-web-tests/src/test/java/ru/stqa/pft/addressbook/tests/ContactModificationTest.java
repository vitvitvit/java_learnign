package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTest extends TestBase{

  @Test
  public void testContactModification(){
    app.getNavigationHelper().openHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("firstname6", "middlename", "lastname", "nickname", "company", "address", "homephone", "mobilephone", null));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().clickEditContact(before.size() - 1);
    app.getContactHelper().fillContactData(new ContactData("firstnamemod2", "middlename", "lastname", "nickname", "company", "address", "homephone", "mobilephone", "workphone"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }

}

