package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddNewContactTest extends TestBase{

  @Test
  public void testAddNewContact() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withUserFirstName("firstname3").withUserMiddleName("middlename")
            .withUserLastName("lastname").withUserNick("nickname").withUserCompany("company")
            .withUserAddress("address").withUserHomePhone("homephone").withUserMobilePhone("mobilephone")
            .withUserWorkPhone("workphone");
    app.contact().create(contact);
    assertThat(app.contact().getContactCount(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }
}
