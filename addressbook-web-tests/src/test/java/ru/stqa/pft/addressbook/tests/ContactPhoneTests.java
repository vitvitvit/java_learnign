package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withUserFirstName("firstname6").withUserMiddleName("middlename")
              .withUserLastName("lastname").withUserNick("nickname").withUserCompany("company")
              .withUserAddress("address").withUserHomePhone("homephone").withUserMobilePhone("mobilephone")
              .withUserWorkPhone("workphone"));
    }
  }

  @Test
  public void testContactPhones() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getUserHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getUserHomePhone())));
    assertThat(contact.getUserMobilePhone(), equalTo(cleaned(contactInfoFromEditForm.getUserMobilePhone())));
    assertThat(contact.getUserWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getUserWorkPhone())));
  }

  public String cleaned(String phone) {
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }

}
