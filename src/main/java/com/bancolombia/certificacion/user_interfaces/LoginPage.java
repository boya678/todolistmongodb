package com.bancolombia.certificacion.user_interfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
 public static final Target USUARIO=Target.the("usuario").locatedBy("//*[@id='username']");
 public static final Target ACEPTAR=Target.the("aceptar").locatedBy("//*[@id='btnGo']");
 public static final Target MENSAJE=Target.the("mensaje de error").located(By.id("summary"));
 public static final Target CLAVE=Target.the("clave").locatedBy("//*[@id='password']");

 
}
