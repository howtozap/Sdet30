package TestScriptDebug;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.LoginPage;

public class LoginDebug {
	@Test
	public void login () {
		ChromeDriver driver =new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp("admin", "admin");
		driver.quit();
	}

}
