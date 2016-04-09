package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Set;

public class AddNewContactTest extends TestBase{

  @Test
  public void testAddNewContact() {
    app.goTo().homePage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withUserFirstName("firstname6").withUserMiddleName("middlename")
            .withUserLastName("lastname").withUserNick("nickname").withUserCompany("company")
            .withUserAddress("address").withUserHomePhone("homephone").withUserMobilePhone("mobilephone");
    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
