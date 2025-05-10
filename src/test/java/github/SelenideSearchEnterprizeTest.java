package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SelenideSearchEnterprizeTest {

    @BeforeAll
    static void setUpBeforeAllTest() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void checkEnterprisesPageTest() {
        // открыть главную страницу
        open("https://github.com/");
        // подвести мышку к пункту меню Solutions
        $$(".HeaderMenu-link").findBy(text("Solutions")).hover();
        // кликнуть на пункт Enterprises
        $("a[href='https://github.com/enterprise']").click();
        // проверка, что на странице есть заголовок: "The AI-powered developer platform
        $("#hero-section-brand-heading").shouldHave(text("he AI-powered developer platform"));
    }
}

