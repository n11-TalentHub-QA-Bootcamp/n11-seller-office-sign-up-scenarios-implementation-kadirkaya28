package starter.n11.navigation.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class n11SignUpPageElements {
    public static Target USERNAME_INPUT = Target.the("username input").
            locatedBy("#usernameInputText");

    public static Target PASSWORD_INPUT = Target.the("password input").
            locatedBy("#passwordInputText");

    public static Target RETYPE_PASSWORD_INPUT = Target.the("retype password input").
            locatedBy("#passwordRetypeInputText");

    public static Target EMAIL_INPUT = Target.the("email input").
            locatedBy("#emailInputText");

    public static Target RETYPE_EMAIL_INPUT = Target.the("retype email input").
            locatedBy("#emailRetypeInputText");

    public static Target NICKNAME_INPUT = Target.the("store name input").
            locatedBy("#nicknameInputText");

    public static Target MEMBERSHIP_WARNING_MESSAGE = Target.the("membership warning message").
            locatedBy("#membershipTypeRadioMessage");

    public static Target CONTRACT_WARNING_MESSAGE = Target.the("contract warning message").
            locatedBy("#j_id261_j_id_cy");

    public static Target SUBMIT_BUTTON = Target.the("submit button").
            locatedBy("#j_id274_j_id_dj");
}

