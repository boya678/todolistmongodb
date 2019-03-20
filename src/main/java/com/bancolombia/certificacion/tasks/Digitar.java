package com.bancolombia.certificacion.tasks;

import static com.bancolombia.certificacion.user_interfaces.LoginPage.ACEPTAR;
import static com.bancolombia.certificacion.user_interfaces.LoginPage.CLAVE;

import com.bancolombia.certificacion.user_interfaces.LoginPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Digitar  implements Task{

	private String clave="";
	
	public Digitar(String clave) {
		if(!clave.equals("\"\"")) {
		this.clave = clave;
		}
	}

	public <T extends Actor> void performAs(T actor) {
		if(!clave.equals("")) {
			actor.attemptsTo(Enter.theValue(clave).into(CLAVE),Click.on(ACEPTAR));
		}
	}
	
	public static Digitar la(String clave) {
		return Tasks.instrumented(Digitar.class, clave);
	}
	

}
