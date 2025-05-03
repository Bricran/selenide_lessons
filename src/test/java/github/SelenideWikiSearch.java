package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SelenideWikiSearch {

    @BeforeAll
    static void setUpBeforeAllTest() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void findWikiGithubJUnit5() {
        // открыть главную страницу
        open("https://github.com/");
        // кликнуть на поле поиска
        $("[placeholder='Search or jump to...']").click();
        // ввести в поле поиска selenide и нажать enter
        $("#query-builder-test").setValue("selenide").pressEnter();
        // кликнуть на selenide репозиторий из списка
        $("a[href='/selenide/selenide']").click();
        //кликнуть на раздел Wiki проекта
        $("#wiki-tab").click();
        //проверка, что в списке страниц (Pages) есть страница SoftAssertions
        $(".Link--muted.js-wiki-more-pages-link.btn-link.mx-auto.f6").click();
        $(".js-wiki-sidebar-toggle-display").shouldHave(text("SoftAssertions"));
        //кликнуть страницу SoftAssertions
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();
        //проверка, что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }
}
