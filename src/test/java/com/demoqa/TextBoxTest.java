package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTests() {
        open("/text-box");

        $("#userName").setValue("John Doe");
        $("#userEmail").setValue("johnd@gmail.com");
        $("#currentAddress").setValue("875 Park Ave, New York, NY, 10075, United States");
        $("#permanentAddress").setValue("1130 Maple Ave, Los Angeles, CA, 90015, United States");
        $("#submit").scrollIntoView(true);
        $("#submit").click();

        $("#output #name").shouldHave(text("John Doe"));
        $("#output #email").shouldHave(text("johnd@gmail.com"));
        $("#output #currentAddress").shouldHave(text
                ("875 Park Ave, New York, NY, 10075, United States"));
        $("#output #permanentAddress").shouldHave(text
                ("1130 Maple Ave, Los Angeles, CA, 90015, United States"));
    }

}
