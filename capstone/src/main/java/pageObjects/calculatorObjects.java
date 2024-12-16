package pageObjects;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class calculatorObjects extends BasePage {

	
	public calculatorObjects(AppiumDriver driver) {
        super(driver);
    }
	
	public By seven = By.xpath("//*[@text='7']");
	public By four = By.xpath("//*[@text='4']");
	public By plus = By.xpath("//*[@text='+']");
	public By equals = By.xpath("//*[@text='=']");
	public By eleven = By.xpath("//*[@text='=11']");
    
    
    
}