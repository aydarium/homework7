package ru.aydar.tests;

import org.junit.jupiter.api.Test;
import ru.aydar.pages.RegistrationPage;
public class RegistrationTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void submitCompleteFormTest()
        {
            registrationPage
                    .openPage()
                    .setFirstName("Vasya")
                    .setLastName("Pupkin")
                    .setEmail("vasiliy@pupkins.ru")
                    .setGender("Male")
                    .setPhoneNumber("5551235678")
                    .setDateOfBirth("29", "February", "2004")
                    .setSubject("Arts")
                    .setSubject("Social Studies")
                    .setSubject("History")
                    .setHobby("Reading")
                    .setHobby("Music")
                    .uploadFile("image.jpg")
                    .setAddress("Pushkin Street, Kolotushkin's House")
                    .setState("Haryana")
                    .setCity("Panipat")
                    .clickSubmit()
                    .checkResultVisible()
                    .checkResultValue("Student Name","Vasya Pupkin")
                    .checkResultValue("Student Email","vasiliy@pupkins.ru")
                    .checkResultValue("Gender", "Male")
                    .checkResultValue("Mobile","5551235678")
                    .checkResultValue("Date of Birth","29 February,2004")
                    .checkResultValue("Subjects","Arts, Social Studies, History")
                    .checkResultValue("Hobbies","Reading, Music")
                    .checkResultValue("Picture","image.jpg")
                    .checkResultValue("Address","Pushkin Street, Kolotushkin's House")
                    .checkResultValue("State and City", "Haryana Panipat");
        }

    @Test
    void submitRequiredFieldsTest()
    {
        registrationPage
                .openPage()
                .setFirstName("Vasilisa")
                .setLastName("Pupkina")
                .setGender("Female")
                .setPhoneNumber("5551235524")
                .setDateOfBirth("05", "September", "1999")
                .clickSubmit()
                .checkResultVisible()
                .checkResultValue("Student Name","Vasilisa Pupkina")
                .checkResultValue("Gender", "Female")
                .checkResultValue("Mobile","5551235524")
                .checkResultValue("Date of Birth","05 September,1999");
    }

    @Test
    void emptyRequiredFieldsTest()
    {
        registrationPage
                .openPage()
                .setPhoneNumber("5551235524")
                .clickSubmit()
                .checkResultHidden();
    }

    @Test
    void submitInvalidPhoneNumberTest()
    {
        registrationPage
                .openPage()
                .setFirstName("Vasilisa")
                .setLastName("Pupkina")
                .setGender("Female")
                .setPhoneNumber("555123552")
                .setDateOfBirth("30", "September", "1999")
                .clickSubmit()
                .checkResultHidden();
    }
}
