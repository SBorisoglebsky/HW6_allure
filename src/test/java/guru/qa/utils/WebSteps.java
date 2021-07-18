package guru.qa.utils;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Open main page")
    public void openMainPage() {
        open("");
    }

    @Step("Search repository [{repository}]")
    public void searchRepo(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").setValue(repo).submit();
    }

    @Step("Go to repository ")
    public void goToRepo(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Go to Issues")
    public void goIssues() {
        $(".js-repo-nav").find(byText("Issues")).click();
    }

    @Step("Check Issues [{issue}]")
    public void checkIssue(String issue) {
        $$("div[aria-label='Issues']").findBy(text(issue)).shouldBe(visible);
    }

}
