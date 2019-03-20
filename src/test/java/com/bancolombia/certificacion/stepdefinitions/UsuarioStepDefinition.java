package com.bancolombia.certificacion.stepdefinitions;

import static com.bancolombia.certificacion.drivers.OwnWebDriver.Chrome;
import static com.bancolombia.certificacion.user_interfaces.LoginPage.ACEPTAR;
import static com.bancolombia.certificacion.user_interfaces.LoginPage.CLAVE;
import static com.bancolombia.certificacion.user_interfaces.LoginPage.MENSAJE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.stateOf;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import com.bancolombia.certificacion.drivers.OwnWebDriver;
import com.bancolombia.certificacion.questions.ElTexto;
import com.bancolombia.certificacion.tasks.Ingresar;
import com.bancolombia.certificacion.user_interfaces.LoginPage;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

public class UsuarioStepDefinition {
	
	
	@Before
	public void init() {
		OnStage.setTheStage(Cast.ofStandardActors());
	}
	
	@Given("^(.*) abre la SVP$")
	public void AbreLaSVP(String nombre) {
		theActorCalled(nombre).can(BrowseTheWeb.with(Chrome().enLaUrl("https://svpbanistmo.qa.todo1.com")));
	}

	@When("^intenta autenticarse con el usuario (.*)$")
	public void intentaAutenticarseConElUsuario(String usuario) {
		theActorInTheSpotlight().attemptsTo(Ingresar.elUsuario(usuario));
	}

	@Then("^observa el mensaje (.*)$")
	public void observaElMensaje(String mensaje) {
	   theActorInTheSpotlight().should(seeThat(ElTexto.del(MENSAJE),is(equalTo(mensaje))));
	}


	@Then("^no puede continuar$")
	public void noPuedeContinuar() {
		theActorInTheSpotlight().should(seeThat(stateOf(ACEPTAR),isNotEnabled()));
	}


	@Then("^observa el ingreso de la clave$")
	public void observaElIngresoDeLaClave() {
		theActorInTheSpotlight().should(seeThat(the(CLAVE),isVisible()));
	}

}
