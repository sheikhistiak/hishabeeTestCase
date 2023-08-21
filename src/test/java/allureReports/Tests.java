package allureReports;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class Tests {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://web.hishabee.business/sign-in"); 
		driver.manage().window().maximize();
		
	}
	

	@Test(priority=1, description="Verify Logo prsence on Page")
	@Description("Verify Logo presence on Page........")
	@Epic("EP001")
	@Feature("Feature1: Logo")
	@Story("Story: Logo Prsence")
	@Step("Verify logo Presence")
	@Severity (SeverityLevel.MINOR)
	public void logoPresence()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("img[src='assets/images/dashboard/business_manager_banner.png']")));
        Assert.assertTrue(logo.isDisplayed());
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// boolean disstatus = driver.findElement(By.cssSelector("img[src='assets/images/dashboard/business_manager_banner.png']")).isDisplayed();
		// Assert.assertEquals(disstatus, true);
	}
	
	@Test(priority=2, description="Verify user login........")
	@Description("Verify user login........")
	@Epic("EP002")
	@Feature("Feature2: Login")
	@Story("Story: Verify user login")
	@Step("Verify user login")
	@Severity (SeverityLevel.BLOCKER)
	public void loginTest() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.className("form-control")).sendKeys("01937733017", Keys.RETURN);
		driver.findElement(By.cssSelector("input[placeholder='00xxx']")).sendKeys("12345", Keys.RETURN);
		//driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		
		// Wait for the page heading element to be visible
		// Introduce a delay of 3 seconds
        // Thread.sleep(3000);
        
        WebElement addShopbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[normalize-space()='+ Add Shop']")));
        
		WebElement pageHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//p[@class='text-center']")));
        Assert.assertEquals(pageHeading.getText(), "Select your shop");
        
        addShopbtn.click();
        Thread.sleep(3000);
        
        // Navigate back to the previous page
        driver.navigate().back();
        Thread.sleep(3000);
	}
	
	
	@Test(priority=3, description="Verify user can add New Shop ........")
	@Description("Verify user can add New Shop ........")
	@Epic("EP003")
	@Feature("Feature3: Create Shop")
	@Story("Story: Verify user can Create Shop")
	@Step("Verify user can Create Shop")
	@Severity (SeverityLevel.NORMAL)
	public void addnewShop() throws InterruptedException
	{
		// throw new SkipException("Skipping this test");
		// Some condition to decide whether to skip the test
		// throw new SkipException("Skipping this test due to some condition- I can not add multiple shop again and again.");
		
		// Rest of your test code
		
		///*
		 
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    
		WebElement addShopbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[normalize-space()='+ Add Shop']")));
		addShopbtn.click();
		
		WebElement ShopName = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//input[@placeholder='Shop name'])[1]")));
		ShopName.sendKeys("MyShop001");
		
		WebElement dropdownElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//option[text()='পোশাক- কাপড়ের']")));
		
		dropdownElement1.click(); // Selects "পোশাক- কাপড়ের"
		
		WebElement dropdownElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//option[text()='Chittagong']")));
		
		dropdownElement2.click(); // Selects "Chittagong"
        
		WebElement dropdownElement3 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//option[text()='Chandpur']")));
		
		dropdownElement3.click(); // Selects "Chandpur"
        
		WebElement dropdownElement4 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//option[text()='Chandpur Sadar']")));
		
		dropdownElement4.click(); // Selects "Chandpur Sadar"
        
		WebElement dropdownElement5 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("input[placeholder='Address']")));
		
		dropdownElement5.sendKeys("Chandpur Sadar 333"); // Selects "Chandpur Sadar"
		
		
        
		// Scroll down using JavaScript
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, document.body.scrollHeight)"); // Adjust the scroll distance as needed
        Thread.sleep(3000);
        
		WebElement creatShopbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.className("btn-primary")));
		creatShopbtn.click();
		
		Thread.sleep(3000);
		// Scroll down using JavaScript
        JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
        jsExecutor2.executeScript("window.scrollBy(0, document.body.scrollHeight)"); // Adjust the scroll distance as needed
        Thread.sleep(3000);
		
		WebElement onlineButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//p[contains(text(), 'For online sell')]")));
				
				// driver.findElement(By.xpath("//p[contains(text(), 'For online sell')]"));
        onlineButton.click();
		
        // Scroll down using JavaScript
        JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
        jsExecutor3.executeScript("window.scrollBy(0, document.body.scrollHeight)"); // Adjust the scroll distance as needed
        Thread.sleep(3000);
        
		WebElement Continuebtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[normalize-space()='Continue']")));
		Continuebtn.click();
        
		WebElement ShopTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//h5[normalize-space()='MyShop001']")));
	    Assert.assertEquals(ShopTitle.getText(), "MyShop001");
		
		//*/
		
	}
	
	
	@Test(priority=4, description="Verify shop information appear correctly........")
	@Description("Verify shop information appear ........")
	@Epic("EP004")
	@Feature("Feature4: Shop Information")
	@Story("Story: Verify shop information")
	@Step("Verify shop information")
	@Severity (SeverityLevel.NORMAL)
	public void ShopInfo() throws InterruptedException
	{
		driver.get("https://web.hishabee.business/select/shop"); //https://web.hishabee.business/select/shop
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement SelectShop = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//button[@type='button'][normalize-space()='Select Shop'])[1]")));
		SelectShop.click();
		
		WebElement ShopExpence = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//h5[normalize-space()=\"Today's Expenses\"])[1]")));
		
		Assert.assertEquals(ShopExpence.getText(), "Today's Expenses");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=5, description="Verify Transaction List appear correctly........")
	@Description("Verify Transaction List appear ........")
	@Epic("EP005")
	@Feature("Feature5: Transaction List")
	@Story("Story: Verify shop Transaction List")
	@Step("Verify Transaction List")
	@Severity (SeverityLevel.NORMAL)
	public void TransactionList() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement SelectTransactionList = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("a[href='/transaction']")));
		SelectTransactionList.click();
		
		WebElement MonthInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("div[class='col-6'] p")));
		
		// Get the current month
        Month currentMonth = LocalDate.now().getMonth();
        String currentMonthText = currentMonth.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        System.out.println(currentMonthText + " The month text matches the current month.");
		
        Assert.assertEquals(MonthInfo.getText(), currentMonthText);
        
        Thread.sleep(3000);
        
		WebElement DayButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[normalize-space()='Day']")));
		DayButton.click();
		
		// Get the current day of the month (e.g., "20")
        int currentDay = LocalDate.now().getDayOfMonth();

        // Combine the current month and day into the expected format ("August 20")
        String expectedText = currentMonthText + " " + currentDay;
        
        
        Thread.sleep(3000);
        
        WebElement RightArrBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
        		By.xpath("//i[@class='fas fa-chevron-right']")));
        RightArrBtn.click();
        
        WebElement LeftArrBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
        		By.xpath("//i[@class='fas fa-chevron-left']")));
        LeftArrBtn.click();
        
        Thread.sleep(3000);
        
        // Now check day info
        WebElement DayInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("div[class='col-6'] p")));
        
        
        Assert.assertEquals(DayInfo.getText(), expectedText);
	}
	
	
	@Test(priority=6, description="Verify Sell Tab working correctly........")
	@Description("Verify Sell Tab appear correctly ........")
	@Epic("EP006")
	@Feature("Feature6: Verify Sell Tab")
	@Story("Story: Verify Sell Tab")
	@Step("Verify Sell Tab")
	@Severity (SeverityLevel.NORMAL)
	public void SellTab() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement SelectSellTab = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("a[href='/create/sale/stop/one']")));
		SelectSellTab.click();
		
		WebElement CashInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("input[placeholder='Got cash']")));
		CashInput.sendKeys("70+5");
		
		Thread.sleep(3000);
		
		WebElement selectEqualButton = driver.findElement(By.xpath(".//button[text()='=']"));
        selectEqualButton.click();
        
        Thread.sleep(3000);
        
		WebElement SellProfit = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("input[placeholder='Profit']")));
		SellProfit.sendKeys("5");
		
		// Scroll down using JavaScript
        JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
        jsExecutor2.executeScript("window.scrollBy(0, document.body.scrollHeight)"); // Adjust the scroll distance as needed
        Thread.sleep(3000);
		
		WebElement ReceivedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//button[text()='Amount Received']")));
				
				// driver.findElement(By.xpath(".//button[text()='Amount Received']"));
        ReceivedButton.click();
		
        WebElement SelectTransactionList = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("a[href='/transaction']")));
		SelectTransactionList.click();
        
		WebElement AmountInfo1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//p[contains(text(),'৳ 75')])[1]")));
		
        Assert.assertEquals(AmountInfo1.getText(), "৳ 75"); //change value accordingly
        
        
	}
	
	
	@Test(priority=7, description="Check Tally Button working correctly........")
	@Description("Check Tally Button working correctly........")
	@Epic("EP007")
	@Feature("Feature7: Check Tally Button")
	@Story("Story: Check Tally Button")
	@Step("Check Tally Button")
	@Severity (SeverityLevel.NORMAL)
	public void CheckTallyBtn() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement ClickOnTally = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//i[@class='fas fa-angle-down iq-arrow-right arrow-hover'])[1]")));
        ClickOnTally.click();
        Thread.sleep(3000);
        
        
        
        WebElement ClickOnTallyr = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//i[@class='fas fa-angle-right iq-arrow-right arrow-active'])[1]")));
        
        ClickOnTallyr.click();
        
        Thread.sleep(3000);
        WebElement SelectPurchaseTab = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("a[href='/purchase']")));
        
        Assert.assertTrue(SelectPurchaseTab.isDisplayed());
        
	}
	
	
	@Test(priority=8, description="Check Purchase Tab working correctly........")
	@Description("Check Purchase Tab working correctly........")
	@Epic("EP008")
	@Feature("Feature8: Check Purchase Tab")
	@Story("Story: Check Purchase Tab")
	@Step("Check Purchase Tab")
	@Severity (SeverityLevel.NORMAL)
	public void CheckPurchaseTab() throws InterruptedException
	{
		// driver.get("https://web.hishabee.business/purchase");
		
		
		Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		WebElement SelectPurchaseTab = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("a[href='/purchase']")));
		
		SelectPurchaseTab.click();
		
		WebElement ProductDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//th[normalize-space()='Product Details']")));
		
        
		Assert.assertEquals(ProductDetails.getText(), "Product Details"); //change value accordingly
        

        Thread.sleep(3000);
        WebElement AddNewProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("a[href='/products/create']")));
        
        Assert.assertTrue(AddNewProduct.isDisplayed());
        AddNewProduct.click();
        
        WebElement ProdDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//p[@class='product_create_title filter'])[1]")));
		
        
		Assert.assertEquals(ProdDetails.getText(), "Product Details*"); //change value accordingly
        
	}
	
	@AfterClass
	public void tearDown() 
	{
		//driver.quit();
		try {
            // Add a time delay of 10 seconds (10000 milliseconds)
            Thread.sleep(10000); // Adjust the time in milliseconds as needed

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Quit the driver after the time delay
            driver.quit();
        }
	}
	
}
