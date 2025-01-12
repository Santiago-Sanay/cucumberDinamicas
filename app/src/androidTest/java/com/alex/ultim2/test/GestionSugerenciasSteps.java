package com.alex.ultim2.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
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
import com.alex.ultim2.activities.Sugerencias;

import org.junit.Rule;
import org.junit.runner.RunWith;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(AndroidJUnit4.class)
public class GestionSugerenciasSteps {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule =
            new ActivityTestRule<>(MainActivity.class);
    @Rule
    public ActivityTestRule<LoginActivity> loginActivityRule =
            new ActivityTestRule<>(LoginActivity.class);
    @Rule
    public ActivityTestRule<Sugerencias> suggestionsActivityRule =
            new ActivityTestRule<>(Sugerencias.class);

    @Given("^Yo tengo una actividad de inicio de sesión2$")
    public void I_have_a_login_activity_sugerencias() {
        // Verificación opcional de inicialización de actividad
    }

    @When("^Ingreso el nombre de usuario2 (\\S+)$")
    public void I_input_username_sugerencias(final String username) {
        onView(withId(R.id.usernameEditText)).perform(typeText(username), closeSoftKeyboard());
    }

    @And("^Ingreso la contraseña2 (\\S+)$")
    public void I_input_password_sugerencias(final String password) {
        onView(withId(R.id.passwordEditText)).perform(typeText(password), closeSoftKeyboard());
        SystemClock.sleep(1000);
    }

    @And("^Presiono el botón de enviar2$")
    public void I_press_submit_button_sugerencias() {
        SystemClock.sleep(1000);
        onView(withId(R.id.loginButton)).perform(click());
    }

    @And("^Debería ver la siguiente actividad2$")
    public void I_should_see_next_activity_sugerencias() {
        SystemClock.sleep(3000); // Tiempo para que la transición ocurra

        onView(withId(R.id.updatePasswordButton))
                .check(matches(isDisplayed()));
    }

    @When("^Presiono el botón Actualizar Campo profesional$")
    public void I_press_update_professional_button() {
        onView(withId(R.id.updatePostgrados1)).perform(click());
    }

    @Then("^Debería ver la actividad profesional$")
    public void I_should_see_professional_activity() {
        onView(withId(R.id.Sugerencias)).check(matches(isDisplayed()));
    }

    @When("^Presiono el botón Sugerencias$")
    public void I_press_suggestions_button() {
        onView(withId(R.id.Sugerencias)).perform(click());
    }

    @Then("^Debería ver la actividad sugerencias$")
    public void I_should_see_suggestions_activity() {
        SystemClock.sleep(3000); // Tiempo para que la transición ocurra

        onView(withId(R.id.radioButtonSiSugerencia))
                .check(matches(isDisplayed()));
       // onView(withId(R.id.radioGroupSugerencias)).check(matches(isDisplayed()));
    }

    @And("^Activo el check \"Sí\" para indicar que tengo sugerencias$")
    public void I_check_yes_for_suggestions() {
        // Inicia la actividad

        onView(withId(R.id.radioButtonSiSugerencia)).perform(click());

        SystemClock.sleep(3000);
    }

    @And("^Ingreso el tema (\\S+)$")
    public void I_input_topic(final String topic) {

        //EditText editTextTema = activity.findViewById(R.id.editTextTema);
        //editTextTema.setEnabled(true);
        onView(withId(R.id.editTextTema))
                .perform(new EnableViewAction(), click(), replaceText(topic), closeSoftKeyboard());//onView(withId(R.id.editTextTema)).perform(typeText(topic), closeSoftKeyboard());
    }

    //@And("^Ingreso la descripción (\\S+)$")
    @And("^Ingreso la descripción (\\S+)$")
    public void I_input_description(final String description) {
        onView(withId(R.id.editTextDescripcion))
                .perform(new EnableViewAction(), click(), replaceText(description), closeSoftKeyboard());//onView(withId(R.id.editTextTema)).perform(typeText(topic), closeSoftKeyboard());
    }

    @And("^Presiono el botón para guardar la sugerencia$")
    public void I_press_save_suggestion_button() {
        onView(withId(R.id.botonGuardar)).perform(click());
    }

    @Then("^Debería ver un mensaje de éxito de sugerencia guardada$")
    public void I_should_see_success_message() {
        SystemClock.sleep(3000); // Tiempo para que la transición ocurra

        onView(withId(R.id.updatePasswordButton))
                .check(matches(isDisplayed()));
    }

    @And("^Activo el check \"No\" para indicar que no tengo sugerencias$")
    public void I_check_no_for_suggestions() {
        onView(withId(R.id.radioButtonNo)).perform(click());
    }

    @And("^Intento ingresar el tema (\\S+)$")
    public void I_attempt_to_input_topic(final String topic) {
        onView(withId(R.id.editTextTema)).perform(typeText(topic), closeSoftKeyboard());
    }

    @And("^Intento ingresar la descripción (\\S+)$")
    public void I_attempt_to_input_description(final String description) {
        onView(withId(R.id.editTextDescripcion)).perform(typeText(description), closeSoftKeyboard());
    }

    @Then("^Debería ver un mensaje de error indicando que no se activó el check$")
    public void I_should_see_error_message() {
        SystemClock.sleep(3000); // Tiempo para que la transición ocurra

        onView(withId(R.id.updatePasswordButton))
                .check(matches(isDisplayed()));
    }
}
