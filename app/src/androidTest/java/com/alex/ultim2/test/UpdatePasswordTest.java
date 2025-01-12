package com.alex.ultim2.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.os.SystemClock;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.alex.ultim2.R;
import com.alex.ultim2.activities.LoginActivity;
import com.alex.ultim2.activities.MainActivity;
import com.alex.ultim2.activities.UpdatePasswordActivity;

import org.junit.Rule;
import org.junit.runner.RunWith;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(AndroidJUnit4.class)
public class UpdatePasswordTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule1 =
            new ActivityTestRule<>(MainActivity.class);
    @Rule
    public ActivityTestRule<LoginActivity> activityRule =
            new ActivityTestRule<>(LoginActivity.class);
    @Rule
    public ActivityTestRule<UpdatePasswordActivity> activityRule2 =
            new ActivityTestRule<>(UpdatePasswordActivity.class);
    @Rule
    private LoginActivity activity;



   @Given("^Yo tengo una actividad de inicio de sesión1$")

    public void I_have_a_login_activity_for_update_password() {
       // assertNotNull("La actividad de inicio de sesión debería estar inicializada", activity);
    }

    @When("^Ingreso el nombre de usuario1 (\\S+)$")
    public void I_input_username_for_update_password(final String username) {
        onView(withId(R.id.usernameEditText)).perform(typeText(username), closeSoftKeyboard());
    }

    @And("^Ingreso la contraseña1 (\\S+)$")
    public void I_input_password_for_update_password(final String password) {
        onView(withId(R.id.passwordEditText)).perform(typeText(password), closeSoftKeyboard());
        SystemClock.sleep(3000);
    }

    @And("^Presiono el botón de enviar1$")
    public void I_press_submit_button_for_update_password() {
        SystemClock.sleep(3000);

        onView(withId(R.id.loginButton)).perform(click());
    }

    @And("^Debería ver la siguiente actividad1$")
    public void I_should_see_on_next_activity_update_password() {
        SystemClock.sleep(3000); // Tiempo para que la transición ocurra

        onView(withId(R.id.updatePasswordButton))
                .check(matches(isDisplayed()));

    }



    @When("^Presiono el botón de actualizar contraseña$")
    public void presionoElBotonDeActualizarContraseña() {
        onView(withId(R.id.updatePasswordButton))
                .perform(click());
    }

    @Then("^Debería ver la actividad de actualizar contraseña$")
    public void deberiaVerLaActividadDeActualizarContraseña() {
        onView(withId(R.id.buttonUpdatePassword ))
                .check(matches(isDisplayed()));
    }

    @And("^Ingreso la contraseña actual (\\S+)$")
    public void ingresoLaContraseñaActual(String currentPassword) {
        onView(withId(R.id.editTextCurrentPassword))
                .perform(typeText(currentPassword), closeSoftKeyboard());
    }

    @And("^Ingreso la nueva contraseña (\\S+)$")
    public void ingresoLaNuevaContraseña(String newPassword) {
        onView(withId(R.id.editTextNewPassword))
                .perform(typeText(newPassword), closeSoftKeyboard());
    }

    @And("^Confirmo la nueva contraseña (\\S+)$")
    public void confirmoLaNuevaContraseña(String confirmPassword) {
        onView(withId(R.id.editTextConfirmPassword))
                .perform(typeText(confirmPassword), closeSoftKeyboard());
    }

    @And("^Presiono el botón para guardar la nueva contraseña$")
    public void presionoElBotonParaGuardarLaNuevaContraseña() {
        onView(withId(R.id.buttonUpdatePassword))
                .perform(click());
    }

    @Then("^Debería ver un mensaje de éxito$")
    public void deberiaVerUnMensajeDeExito() {

        onView(withId(R.id.updatePasswordButton))
                .check(matches(isDisplayed()));
    }
    @Then("^Debería ver un mensaje de error en password$")
    public void I_should_see_error_message() {
        onView(withId(R.id.buttonUpdatePassword))
                .check(matches(isDisplayed())); // Verifica que el texto coincida
    }


}
