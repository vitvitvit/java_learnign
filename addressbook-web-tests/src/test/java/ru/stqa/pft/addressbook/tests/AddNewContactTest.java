package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class AddNewContactTest extends TestBase{

  @Test
  public void testAddNewContact() {
    app.getNavigationHelper().openHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().createContact(new ContactData("firstname6", "middlename", "lastname", "nickname", "company", "address", "homephone", "mobilephone", null));
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }
}
