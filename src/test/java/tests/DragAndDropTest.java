package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void dragAndDrop()
    {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //способ с action
        //SelenideElement x = $("#column-a");
        //SelenideElement y = $("#column-b");
        //actions().moveToElement(x).click(y).perform();
        //способ просто командой
        $("#column-a").dragAndDropTo("#column-b");
        //проверка, но почему то если запускать вместе с action, то тест падает, так что я не уверена что action тогда работает
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}