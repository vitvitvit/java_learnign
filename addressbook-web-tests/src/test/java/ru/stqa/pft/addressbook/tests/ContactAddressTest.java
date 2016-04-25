package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withUserFirstName("firstname3").withUserLastName("lastname")
              .withUserAddress("address").withUserHomePhone("homephone").withUserMobilePhone("mobilephone")
              .withUserWorkPhone("workphone").withUserEmail("email1@test.com").withUserEmail2("email2@test.com")
              .withUserEmail3("email3@test.com"));
    }
  }

  @Test
  public void testContactPhones() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getUserAddress(), equalTo(contactInfoFromEditForm.getUserAddress()));
  }

}

