package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Set;

public class ContactModificationTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withUserFirstName("firstname6").withUserMiddleName("middlename")
              .withUserLastName("lastname").withUserNick("nickname").withUserCompany("company")
              .withUserAddress("address").withUserHomePhone("homephone").withUserMobilePhone("mobilephone"));
    }
  }

  @Test
  public void testContactModification(){
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withUserFirstName("firstname6").withUserMiddleName("middlename")
            .withUserLastName("lastname").withUserNick("nickname").withUserCompany("company")
            .withUserAddress("address").withUserHomePhone("homephone").withUserMobilePhone("mobilephone");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}

