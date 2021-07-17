package guru.qa.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SelenideTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.startMaximized = true;
    }

    @Test
    void searchIssuesSelenide(){
        open("");

    }
    @Test
    void searchIssuesLambda(){
        step("Open main page", () -> open(""));


    }
}
