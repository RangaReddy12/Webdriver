package aug8;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class WebTable {
public static void main(String[] args) throws Throwable {
		String expectedcountry="canada";
		boolean flag=false;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		Thread.sleep(5000);
		WebElement table = driver.findElement(By.id("customers"));
		//get collection of rows
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println("No of rows are::"+rows.size());
		Thread.sleep(5000);
		for(int i=1;i<rows.size();i++) {
			//get collection of cells in aeach row
			List<WebElement> cols =rows.get(i).findElements(By.tagName("td"));
			for (int j=0;j<cols.size();j++) {
				String actualcelldata=cols.get(j).getText();
				Thread.sleep(2000);
				System.out.print("\n"+actualcelldata);
				if(actualcelldata.equalsIgnoreCase(expectedcountry))
				{
					flag=true;
					System.out.println("Row No."+i+"  "+"Found in cell::"+(j+1));
					break;
				}
				}
			System.out.println();
			System.out.println("==============================================");
		}
		if(flag)
		{
			System.out.println(expectedcountry+"  "+"Country found in table");
		}
		else
		{
			System.out.println(expectedcountry+"  "+"Country Not found in table");
		}
		Thread.sleep(5000);
		driver.close();

	}
}
