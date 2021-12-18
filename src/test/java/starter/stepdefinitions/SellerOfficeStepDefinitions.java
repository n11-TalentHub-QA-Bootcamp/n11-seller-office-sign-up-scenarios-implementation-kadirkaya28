package starter.stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import starter.n11.navigation.signup.SignUpUser;
import starter.n11.navigation.tasks.NavigateTo;
import starter.n11.navigation.user_interface.n11SignUpPageElements;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class SellerOfficeStepDefinitions {

    Actor actor = Actor.named("kadirkaya");
    @Managed
    WebDriver webDriver;

    @Given("user launch browser and open the sign up page")
    public void userLaunchBrowserAndOpenTheSignUpPage() {
        actor.can(BrowseTheWeb.with(webDriver));
        actor.wasAbleTo(NavigateTo.theN11SellerHomePage());
    }

    @When("user signed in seller office with valid credentials without contract box")
    public void userSignedInSellerOfficeWithValidCredentialsWithoutContractBox() {
        actor.attemptsTo(SignUpUser.signUpPage(
                "tester kadir",
                "tester123@n11.com",
                "tester123",
                "TesterKadir"
        ));
    }

    @Then("user sees error message")
    public void userSeesErrorMessage() {
        actor.attemptsTo(
                WaitUntil.the(n11SignUpPageElements.MEMBERSHIP_WARNING_MESSAGE,isCurrentlyVisible())
                        .forNoMoreThan(5).seconds(),
                Ensure.that(n11SignUpPageElements.MEMBERSHIP_WARNING_MESSAGE).isDisplayed(),
                Ensure.that(n11SignUpPageElements.CONTRACT_WARNING_MESSAGE).isDisplayed()
        );
    }
}
