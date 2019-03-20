package com.bancolombia.certificacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ElTexto implements Question<String> {
	
	private Target target;
	
	public ElTexto(Target target) {
		this.target=target;
	}

	public String answeredBy(Actor actor) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return target.resolveFor(actor).getText();
	}
	
	public static ElTexto del(Target target) {
		return new ElTexto(target);
	}
	
	

}
