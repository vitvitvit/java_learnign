package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsTest extends TestBase {

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

  //This test works if a contact contains only firstname, lastname, address, 3 phones and 3 emails.
  @Test
  public void testContactPhones() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditFormModified(contact);
    ContactData contactInfoFromDetailsForm = app.contact().infoFromDetailsForm(contact);

    assertThat(contactInfoFromDetailsForm.getAllData(), equalTo(mergeAllData(contactInfoFromEditForm)));
  }

  private String mergeAllData(ContactData contact) {
    return Arrays.asList(contact.getUserFirstAndLastNames(), contact.getUserAddress(), contact.getUserHomePhone()
            , contact.getUserMobilePhone(), contact.getUserWorkPhone(), contact.getUserEmail()
            ,contact.getUserEmail2(), contact.getUserEmail3())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }

}

