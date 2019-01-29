package co.com.accenture;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Registro {
	
	private WebDriver driver;
	private String contra;
	private String nombreTarea;
	
	
	@Before
	public void inicializar() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
		System.out.println("Levantando el navegador de chrome.");
		
	}
	@Test
	public void probando() throws InterruptedException {

		contra = "Asana789";
	    nombreTarea = "Mi primera automatizacion";
	
		driver.get("https://asana.com/es");
		System.out.println("Abriendo la pagina de Asana");
		
		driver.findElement(By.xpath("//*[@id='siteHeader']/div[3]/div[2]/div/nav/a[4]")).click();
		System.out.println("Click en el boton iniciar sesion");
		
		WebElement email = driver.findElement(By.xpath("//*[@id=\"login-email-modal-login\"]"));
		email.sendKeys("y.munoz@accenture.com");
		System.out.println("Escribiendo en el campo email");
		
		WebElement clave = driver.findElement(By.xpath("//*[@id=\"login-password-modal-login\"]"));
	    clave.sendKeys(contra);
	    System.out.println("Escribiendo contraseña");
	   
	    driver.findElement(By.xpath("//*[@id='login-submit-modal-login']")).click();
		System.out.println("Click en el boton iniciar sesion");
				
	    driver.findElement(By.xpath("//a[@class='NavigationLink HomeTasksForTodaySection-myTasksLink']")).click();
	    System.out.println("Ver todas las tareas");
	    
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[contains(text(), 'Agregar tarea')]")).click();
	    System.out.println("Agregar Tarea");
	    
	    Thread.sleep(2000);
	    WebElement tarea = driver.findElement(By.id("pot.1101207220589800upcoming_1102622618998976"));
        tarea.clear();
        tarea.sendKeys(nombreTarea);
        driver.findElement(By.id("pot.1101207220589800upcoming_1102622618998976")).clear();
        tarea.clear();
	    System.out.println("Escribiendo tarea");
	    
	}
	@After
	public void cerrarDriver() {
//		driver.quit();
		System.out.println("Cerrando el navegador de Chrome");
	}	
}
