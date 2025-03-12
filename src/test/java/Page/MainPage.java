package Page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement logoDzen = $(".dzen-layout--desktop-base-header__logoWithText-3k.dzen-layout--desktop-base-header__isMorda-2n");
    private final SelenideElement searchPanel = $x("//input[contains(@class, 'arrow__input')]");
    private final SelenideElement placeHolderYandex = $x("//div[@class='dzen-search-arrow-common__placeholder']");
    private final SelenideElement findButton = $x("//button[@class='arrow__button' and text()='Найти']");
    private final SelenideElement signButton = $x("//button[contains(@class, 'dzen-layout--login-button__textButton-1t')]");
    private final ElementsCollection newsBlocks = $$("div.dzen-desktop--floor-title__title-2v[data-testid='floor-title-text']");

    public MainPage(String url) {
        Selenide.open(url);
    }

    public void onClickFindButton() {
        findButton.click();
    }

    public void checkPlaceholderText(String expectedText) {
        placeHolderYandex.shouldHave(Condition.exactText(expectedText));
    }

    public void checkLogoDzen() {
        logoDzen.should(Condition.exist);
        logoDzen.shouldBe(Condition.visible);
    }

    public void checkSearchPanel() {
        searchPanel.should(Condition.exist);
        searchPanel.shouldBe(Condition.visible);
    }

    public void setSearchPanel(String SEARCH_STRING) {
        searchPanel.setValue(SEARCH_STRING);
    }

    public void checkFindButton() {
        findButton.should(Condition.exist);
        findButton.shouldBe(Condition.enabled);
    }

    public void checkSingButton() {
        signButton.should(Condition.exist);
        signButton.shouldBe(Condition.enabled);
        signButton.shouldHave(Condition.exactText("Войти"));
    }

    public void checkNewsBlocks(List<String> expectedTitles) {
        List<String> listNewsBlocks = new ArrayList<>();
        newsBlocks.forEach(item -> listNewsBlocks.add(item.getText()));
        Assertions.assertTrue(expectedTitles.containsAll(listNewsBlocks), "Не соответсвие вариантов новостных блоков!");
    }
}

