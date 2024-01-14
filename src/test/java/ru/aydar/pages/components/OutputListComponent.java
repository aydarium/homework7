package ru.aydar.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class OutputListComponent {
    public void checkOutput(String key, String value)
    {
        $("#output #" + key).shouldHave(text(value));
    }
}
