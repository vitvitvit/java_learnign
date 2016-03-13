package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase{

  @Test
  public void testAddNewContact() {
    openAddNewPage();
    fillContactData(new ContactData("firstname", "middlename", "lastname", "nickname", "company", "address", "homephone", "mobilephone", "workphone"));
    submitContactCreation();
    gotoHomePage();
  }
    
}
