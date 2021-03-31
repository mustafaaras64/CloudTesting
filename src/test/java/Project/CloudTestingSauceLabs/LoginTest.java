package Project.CloudTestingSauceLabs;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginTest {
	public static WebDriver driver;
	public static final String USERNAME = "xxxxxxxx";
	public static final String ACCESS_KEY = "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	
	public static void main(String[] args) throws MalformedURLException {
	
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 7");
		caps.setCapability("version", "51.0");

		driver = new RemoteWebDriver(new URL(URL), caps);
		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("button[class='radius']")).click();
		System.out.println(driver.findElement(By.xpath("//h4[@class='subheader']")).getText());
		driver.findElement(By.xpath("//i[contains(text(),'Logout')]")).click();
	}

}
