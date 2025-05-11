package github;

import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class DragAndDropTests {

    @BeforeAll
    static void setUpBeforeAllTest() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void dragAndDropTest(){
        // открыть сайт https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // проверка, что прямоугольники находятся в изначальном положении
        $("#column-a").shouldHave(exactText("A"));
        $("#column-b").shouldHave(exactText("B"));

        // Подвинуть курсор к элементу A, кликнуть и держать, передвинуть, отпустить кнопку мыши
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(200, 0).release().perform();
        // проверка, что прямоугольники поменялись местами
        $("#column-a").shouldHave(exactText("B"));
        $("#column-b").shouldHave(exactText("A"));

    }

    @Test
    void dragAndDrop2Test() {
        // открыть сайт https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // проверка, что прямоугольники находятся в изначальном положении
        $("#column-a").shouldHave(exactText("A"));
        $("#column-b").shouldHave(exactText("B"));
        // поменять местами прямоугольники
        $("#column-a").dragAndDropTo("#column-b");
        // проверка, что прямоугольники поменялись местами
        $("#column-a").shouldHave(exactText("B"));
        $("#column-b").shouldHave(exactText("A"));
    }
}
