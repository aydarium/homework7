package ru.aydar.pages;

import com.codeborne.selenide.SelenideElement;
import ru.aydar.pages.components.OutputListComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {
    private final SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton =  $("#submit");

    OutputListComponent outputListComponent = new OutputListComponent();

    public TextBoxPage openPage() {
        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage clickSubmit()
    {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkUserName(String value) {
        outputListComponent.checkOutput("name", value);
        return this;
    }

    public TextBoxPage checkEmail(String value) {
        outputListComponent.checkOutput("email", value);
        return this;
    }

    public TextBoxPage checkCurrentAddress(String value) {
        outputListComponent.checkOutput("currentAddress", value);
        return this;
    }

    public TextBoxPage checkPermanentAddress(String value) {
        outputListComponent.checkOutput("permanentAddress", value);
        return this;
    }
}
