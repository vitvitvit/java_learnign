package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class AddNewContactTest extends TestBase{

  @Test
  public void testAddNewContact() {
    app.getContactHelper().openAddNewPage();
    app.getContactHelper().fillContactData(new ContactData("firstname", "middlename", "lastname", "nickname", "company", "address", "homephone", "mobilephone", "workphone"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage();
  }

}
