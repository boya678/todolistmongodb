package com.bancolombia.certificacion.stepdefinitions;

import static com.bancolombia.certificacion.drivers.OwnWebDriver.Chrome;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.bancolombia.certificacion.tasks.Digitar;
import com.bancolombia.certificacion.tasks.Ingresar;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ClaveStepDefinition {
	
	@Given("^(.*) uso el usuario (.*)$")
	public void anaUsoElUsuarioAbcd(String nombre, String usuario) {
		theActorCalled(nombre).can(BrowseTheWeb.with(Chrome().enLaUrl("https://svpbanistmo.qa.todo1.com")));
		theActorInTheSpotlight().wasAbleTo(Ingresar.elUsuario(usuario));
	}


	@When("^intenta autenticarse con la clave (.*)$")
	public void intentaAutenticarseConLaClave(String clave) {
		theActorInTheSpotlight().attemptsTo(Digitar.la(clave));
	}
}
