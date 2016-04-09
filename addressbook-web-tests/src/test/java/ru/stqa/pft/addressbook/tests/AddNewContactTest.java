package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class AddNewContactTest extends TestBase{

  @Test
  public void testAddNewContact() {
    app.goTo().homePage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData("firstname6", "middlename", "lastname", "nickname", "company", "address", "homephone", "mobilephone", null);
    app.contact().create(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare (c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
