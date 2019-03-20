package com.bancolombia.certificacion.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features="src/test/resources/features/usuario.feature",
		glue="com.bancolombia.certificacion.stepdefinitions",
		snippets=SnippetType.CAMELCASE
		)

public class UsuarioRunner {

}
