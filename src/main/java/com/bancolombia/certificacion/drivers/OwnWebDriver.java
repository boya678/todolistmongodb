package com.bancolombia.certificacion.drivers;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.host.media.webkitMediaStream;

public class OwnWebDriver {

	public WebDriver driver;
	
	public static OwnWebDriver Chrome() {
		return new OwnWebDriver();
	}
	
	public WebDriver enLaUrl(String url) {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.xpath("//*[text()='presione aquí']")).click();
		Set<String> pantallas=driver.getWindowHandles();
		pantallas.remove(driver.getWindowHandle());
		driver.switchTo().window(pantallas.iterator().next());
		return driver;
	}
	
}
