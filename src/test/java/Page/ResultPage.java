package Page;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;

public class ResultPage {
    private final ElementsCollection articleResult = $$x("//li ");

    public int arcticleSize() {
        return articleResult.size();
    }
}
