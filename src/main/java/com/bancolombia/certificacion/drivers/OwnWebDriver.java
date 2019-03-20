package com.bancolombia.certificacion.drivers;

import java.util.Set;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.gargoylesoftware.htmlunit.javascript.host.media.webkitMediaStream;

public class OwnWebDriver {

	public WebDriver driver;
	public static final String USERNAME = "julianvelez1";
  	public static final String AUTOMATE_KEY = "4LsqQFwAYyvebZfyEiE5";
  	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public static OwnWebDriver Chrome() {
		return new OwnWebDriver();
	}
	
	public WebDriver enLaUrl(String url) {
		try{
		DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("browser", "Chrome");
		    caps.setCapability("browser_version", "73.0");
		    caps.setCapability("os", "Windows");
		    caps.setCapability("os_version", "7");
		    caps.setCapability("resolution", "1024x768");
		 	driver = new RemoteWebDriver(new URL(URL), caps);
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.xpath("//*[text()='Ingresa aquí']")).click();
		Set<String> pantallas=driver.getWindowHandles();
		pantallas.remove(driver.getWindowHandle());
		driver.switchTo().window(pantallas.iterator().next());
		
		}
		catch(Exception e){}
		return driver;
	}
	
}
