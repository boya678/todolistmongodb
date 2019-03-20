package com.bancolombia.certificacion.tasks;

import static com.bancolombia.certificacion.user_interfaces.LoginPage.ACEPTAR;
import static com.bancolombia.certificacion.user_interfaces.LoginPage.USUARIO;

import com.bancolombia.certificacion.user_interfaces.LoginPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;

public class Ingresar implements Task {

	private String usuario="";
	
	public Ingresar (String usuario) {
		if(!usuario.equals("\"\"")) {
			this.usuario=usuario;
			System.out.println(usuario);
		}
	}
	
	@Step("{0} ingresa el usuario #usuario")
	public <T extends Actor> void performAs(T actor) {
		if(!usuario.equals("")) {
			actor.attemptsTo(Enter.theValue(usuario).into(USUARIO),Click.on(ACEPTAR));
		}
	}
	
	public static Ingresar elUsuario(String usuario) {
		return Tasks.instrumented(Ingresar.class, usuario);
	}

}
