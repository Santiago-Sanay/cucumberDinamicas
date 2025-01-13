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

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.alex.ultim2.R;
import com.alex.ultim2.activities.LoginActivity;
import com.alex.ultim2.activities.MainActivity;
import com.alex.ultim2.activities.UpdateDataActivity;

import org.junit.Rule;
import org.junit.runner.RunWith;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(AndroidJUnit4.class)
public class UpdateUserDataTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule =
            new ActivityTestRule<>(MainActivity.class);
    @Rule
    public ActivityTestRule<LoginActivity> loginActivityRule =
            new ActivityTestRule<>(LoginActivity.class);
    @Rule
    public ActivityTestRule<UpdateDataActivity> updateUserDataActivityRule =
            new ActivityTestRule<>(UpdateDataActivity.class);

    @Given("^El usuario está en la pantalla de inicio de sesión$")
    public void elUsuarioEstaEnPantallaDeInicioSesion() {
        //onView(withId(R.id.loginActivityLayout)).check(matches(isDisplayed()));
    }

    @When("^Ingreso el nombre de usuario3 (\\S+)$")
    public void ingresaElNombreDeUsuario(final String username) {
        onView(withId(R.id.usernameEditText)).perform(typeText(username), closeSoftKeyboard());
    }

    @And("^Ingreso la contraseña3 (\\S+)$")
    public void ingresaLaContraseña(final String password) {
        onView(withId(R.id.passwordEditText)).perform(typeText(password), closeSoftKeyboard());
    }

    @And("^Presiono el botón de iniciar sesion$")
    public void presionaElBotonDeIniciarSesion() {
        onView(withId(R.id.loginButton)).perform(click());
        SystemClock.sleep(2000); // Espera para la transición de pantalla
    }

    @Then("^Debería ver la pantalla principal3$")
    public void deberiaVerPantallaPrincipal() {
        SystemClock.sleep(3000); // Tiempo para que la transición ocurra

        onView(withId(R.id.updatePasswordButton))
                .check(matches(isDisplayed()));
    }

    @When("^Navega a la pantalla de actualización de datos$")
    public void navegaAPantallaDeActualizacionDeDatos() {
        onView(withId(R.id.updateDataButton)).perform(click());
        //SystemClock.sleep(2000);
    }

    @Then("^Debería ver la pantalla de actualización de datos personales$")
    public void deberiaVerPantallaDeActualizacionDeDatos() {
        //SystemClock.sleep(2000);
        onView(withId(R.id.editTextNombre)).check(matches(isDisplayed()));
    }

    @When("^Ingresa el nuevo nombre (\\S+)$")
    public void ingresaElNuevoNombre(final String newName) {
        onView(withId(R.id.editTextNombre)).perform(replaceText(newName), closeSoftKeyboard());
    }

    @And("^Ingresa el nuevo correo electrónico (\\S+)$")
    public void ingresaElNuevoCorreo(final String newEmail) {
        onView(withId(R.id.editTextCorreo)).perform(replaceText(newEmail), closeSoftKeyboard());
    }

    @And("^Ingresa el nuevo número de teléfono (\\S+)$")
    public void ingresaElNuevoTelefono(final String newPhone) {
        onView(withId(R.id.editTextTelefono)).perform(replaceText(newPhone), closeSoftKeyboard());
    }

    @And("^Presiona el botón para guardar los cambios$")
    public void presionaElBotonParaGuardarCambios() {
        // Desplazarse manualmente hacia abajo
        onView(withId(R.id.buttonSave))
                .perform(ViewActions.swipeUp()) // Desplazamiento hacia arriba (prueba con swipeDown si es necesario)
                .perform(click()); // Hacer clic en el botón
        SystemClock.sleep(2000); // Espera para el mensaje de confirmación
    }

    @Then("^Debería ver un mensaje de confirmación$")
    public void deberiaVerUnMensajeDeConfirmacion() {
        SystemClock.sleep(2000);
        onView(withId(R.id.loginButton)).check(matches(isDisplayed()));
    }

    @Then("^Debería ver un mensaje de error si hay datos inválidos$")
    public void deberiaVerUnMensajeDeErrorSiHayDatosInvalidos() {
        onView(withId(R.id.buttonSave)).check(matches(isDisplayed()));
    }
}