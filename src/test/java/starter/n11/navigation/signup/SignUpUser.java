package starter.n11.navigation.signup;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import starter.n11.navigation.user_interface.n11SignUpPageElements;
import starter.n11.navigation.user_interface.n11SellerHomePageElements;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SignUpUser implements Task {

    private final String username_text;
    private final String password_text;
    private final String email_text;
    private final String nickname_text;

    @Step("Sign up with valid credentials")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(n11SellerHomePageElements.REGISTER_BUTTON),
                WaitUntil.the(n11SignUpPageElements.USERNAME_INPUT,isClickable())
                        .forNoMoreThan(5).seconds(),
                SendKeys.of(this.username_text).into(n11SignUpPageElements.USERNAME_INPUT),
                SendKeys.of(this.password_text).into(n11SignUpPageElements.PASSWORD_INPUT),
                SendKeys.of(this.password_text).into(n11SignUpPageElements.RETYPE_PASSWORD_INPUT),
                SendKeys.of(this.email_text).into(n11SignUpPageElements.EMAIL_INPUT),
                SendKeys.of(this.email_text).into(n11SignUpPageElements.RETYPE_EMAIL_INPUT),
                SendKeys.of(this.nickname_text).into(n11SignUpPageElements.NICKNAME_INPUT),
                Click.on(n11SignUpPageElements.SUBMIT_BUTTON)
        );
    }
    public SignUpUser(String username_text, String email_text,
                      String password_text, String nickname_text){
        this.username_text = username_text;
        this.email_text = email_text;
        this.password_text = password_text;
        this.nickname_text = nickname_text;
    }
    public static SignUpUser signUpPage(String username_text, String email_text,
                                          String password_text, String nickname_text) {
        return instrumented(SignUpUser.class
                ,username_text,email_text,password_text,nickname_text);
    }
}
