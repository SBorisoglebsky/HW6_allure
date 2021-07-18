package guru.qa.test;

import com.codeborne.selenide.Configuration;
import guru.qa.utils.WebSteps;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    private static final String REPOSITORY = "allure-framework/allure-gradle";
    private static final String ISSUE_NAME = "JCenter sundown";

    private WebSteps webSteps = new WebSteps();

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.startMaximized = true;
    }

    @Test
    void searchIssuesSelenide() {
        open("");
        $(".header-search-input").click();
        $(".header-search-input").setValue(REPOSITORY).submit();

        $(linkText(REPOSITORY)).click();

        $(".js-repo-nav").find(byText("Issues")).click();
        //проверка, что вкладка существет
        $("span[data-content='Issues']").shouldBe(visible);
        //Проверка искомого ISSUE_NAME
        $$("div[aria-label='Issues']").findBy(text(ISSUE_NAME)).shouldBe(visible);
    }

    @Test
    void searchIssuesLambda() {
        step("Open main page", () -> open(""));
        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY).submit();
        });
        step("Переходим в репозиторий", () ->  $(linkText(REPOSITORY)).click());
        step("Переходим в Issues", () -> $(".js-repo-nav").find(byText("Issues")).click());
        step("Проверям искомый Issues-"+ ISSUE_NAME,
                () -> $$("div[aria-label='Issues']").findBy(text(ISSUE_NAME)).shouldBe(visible));
    }

    @Test
    public void searchIssuesBySteps(){

        webSteps.openMainPage();
        webSteps.searchRepo(REPOSITORY);
        webSteps.goToRepo(REPOSITORY);
        webSteps.goIssues();
        webSteps.checkIssue(ISSUE_NAME);

    }

}

