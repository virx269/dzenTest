import Core.BaseTest;
import Pages.ResultPage;
import Pages.MainPage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class DzenTest extends BaseTest {
    private final static String BASE_URL = "https://dzen.ru";
    private final static String SEARCH_STRING = "Альфа банк";

    @Test
    public void checkDzenTest() {
        MainPage mainPage = new MainPage(BASE_URL);

        mainPage.checkLogoDzen();
        mainPage.checkSingButton();
        mainPage.checkPlaceholderText("Поиск Яндекса");

        mainPage.checkNewsBlocks(List.of("Новости", "Интересное для вас", "Видео", "Статьи"));

        Selenide.switchTo().frame("ya-search-iframe-283dku");

        mainPage.checkSearchPanel();
        mainPage.setSearchPanel(SEARCH_STRING);
        mainPage.checkFindButton();
        mainPage.onClickFindButton();

        ResultPage resultPage = new ResultPage();
        Assertions.assertTrue(resultPage.arcticleSize() > 0, "Результаты поиска должны быть больше нуля!");
    }
}

