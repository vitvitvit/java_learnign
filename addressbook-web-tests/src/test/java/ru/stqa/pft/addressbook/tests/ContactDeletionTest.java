package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by inwi on 20.03.2016.
 */
public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().openHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().clickDeleteContact();
    app.getContactHelper().confirmDeletion();
  }
}
