package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddNewContactTest extends TestBase{

  @Test
  public void testAddNewContact() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/123.png");
    ContactData contact = new ContactData().withUserFirstName("firstname3").withUserLastName("lastname")
            .withUserAddress("address").withUserHomePhone("homephone").withUserMobilePhone("mobilephone")
            .withUserWorkPhone("workphone").withUserEmail("email1@test.com").withUserEmail2("email2@test.com")
            .withUserEmail3("email3@test.com").withPhoto(photo);
    app.contact().create(contact);
    assertThat(app.contact().getContactCount(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }

}
