
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class meetsMorefirst {

	public static void main(String[] args) throws InterruptedException {
	
		
		System.setProperty("webdriver.chrome.driver","./exe/chromedriver");
		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		
		driver.get("https://staging-meetsmore.com/");
		Thread.sleep(5000);

		WebElement searchBox = driver.findElement(By.cssSelector("#root > div.jss1 > div > div.jss60 > div.jss61 > div > div.jss64 > div.jss73 > input"));
		action.moveToElement(searchBox).click().sendKeys("確定申告の税理士").perform();
		
		/*クラス属性で探す
		 * MuiTypography-root MuiListItemText-primary MuiTypography-body1 MuiTypography-displayBlock
		 */
		Thread.sleep(1000);
		driver.findElement(By.className("jss77")).click();
		
		/*
		 * お近くの確定申告に強い税理士を探しています。
		 * 「次へ」ボタン。org.openqa.selenium.ElementClickInterceptedException:
		 * 修正。
		 */
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("body > div.MuiDialog-root.jss271 > div.MuiDialog-container.MuiDialog-scrollPaper > div > div > div.jss329 > button")).click();
		
		/*
		 * 確定申告をする年数を指定。+ボタンを２回クリックして3年分にする。
		 */
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/div[2]/div[2]/div/div/button[2]")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/div[2]/div[2]/div/div/button[2]")).click();
		
		/*
		 * assertで３年分になっていることを確認。
		 * assertで確認ができていないぽい。
		 */
		
		WebElement years = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/div[2]/div[2]/div/div/div[2]"));
		String actual = years.getText();
		String expected = "3";
		assertThat(actual,expected);
		
		driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/div[3]/div[2]/button/span[1]")).click();
		
		
	
		
		
		
		
		
		

		

	}

	private static void assertThat(String text, Object object) {
		// TODO Auto-generated method stub
		
	}

	private static Object is(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
