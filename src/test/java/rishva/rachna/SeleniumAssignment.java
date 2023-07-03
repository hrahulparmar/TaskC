package rishva.rachna;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumAssignment {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://amazon.in");

		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("Wrist Watches");
		searchBox.submit();

		WebElement analoqueCheckBox = driver.findElement(By
				.xpath("//div[@id='filters']//span[@class='a-size-base a-color-base'][normalize-space()='Analogue']"));
		Actions act = new Actions(driver);
		act.moveToElement(analoqueCheckBox).perform();
		Thread.sleep(3000);
		analoqueCheckBox.click();

		WebElement leatherCheckBox = driver
				.findElement(By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='Leather']"));
		act.moveToElement(leatherCheckBox).perform();
		Thread.sleep(3000);
		leatherCheckBox.click();

		WebElement titanCheckBox = driver
				.findElement(By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='Titan']"));
		act.moveToElement(titanCheckBox).perform();
		Thread.sleep(3000);
		titanCheckBox.click();

		WebElement discount = driver.findElement(By.xpath("//span[contains(text(),'25% Off or more')]"));
		act.moveToElement(discount).perform();
		Thread.sleep(3000);
		discount.click();

		List<WebElement> searchResults = driver
				.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		WebElement fifthResult = searchResults.get(4);
		System.out.println(fifthResult.getText());
		fifthResult.click();

	}

}
