package aug9;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class ValidateLogin {
	public static void main(String[] args) throws Throwable {
		FileReader fr = new FileReader("d://LoginData.txt");
		BufferedReader br = new BufferedReader(fr);
		String str="";
		while ((str=br.readLine())!=null) {
			{
				//java time stamp
				Date date = new Date();
				DateFormat df =new SimpleDateFormat("YYYY_MM_dd hh_mm_ss");
				String datef =df.format(date);
				String login[]=str.split(";");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("http://orangehrm.qedgetech.com/");
				Thread.sleep(3000);
				driver.findElement(By.cssSelector("#txtUsername")).sendKeys(login[0]);
				driver.findElement(By.cssSelector("#txtPassword")).sendKeys(login[1]);
				driver.findElement(By.cssSelector("#btnLogin")).click();
				Thread.sleep(2000);
				String expected ="dashboard";
				String actual =driver.getCurrentUrl();
				if(actual.contains(expected))
				{
					System.out.println("Login Success::"+expected+"      "+actual);
				}
				else
				{
					//take screen shot and store into one variable
					File screen =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					//copy scrren shot into local system
					FileUtils.copyFile(screen, new File("D://Screens/"+datef+"  "+"Loginpage.png"));
					System.out.println("Login Fail::"+expected+"      "+actual);
				}
				driver.close();
			}
		}
	}
 }


