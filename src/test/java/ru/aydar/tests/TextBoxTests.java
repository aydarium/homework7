package ru.aydar.tests;

import org.junit.jupiter.api.Test;
import ru.aydar.pages.TextBoxPage;

public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest()
    {
        textBoxPage
                .openPage()
                .setUserName("Alex")
                .setEmail("alex@egorov.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .clickSubmit()
                .checkUserName("Alex")
                .checkEmail("alex@egorov.com")
                .checkCurrentAddress("Some street 1")
                .checkPermanentAddress("Another street 1");
    }
}
