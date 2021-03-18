package com.pages;

import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

import junit.framework.Assert;

public class HomePage extends TestBase {
	
	//labels
	@FindBy(id="lbl_val_1")
	private WebElement lblValue1;
	
	@FindBy(id="lbl_val_2")
	private WebElement lblValue2;
	
	@FindBy(id="lbl_val_3")
	private WebElement lblValue3;
	
	@FindBy(id="lbl_val_4")
	private WebElement lblValue4;
	
	@FindBy(id="lbl_val_5")
	private WebElement lblValue5;
	
	@FindBy(id="lbl_ttl_val")
	private WebElement lblTotalBal;
	
	//textboxes
	@FindBy(id="txt_val_1")
	private WebElement txtVal1;
	
	@FindBy(id="txt_val_2")
	private WebElement txtVal2;
	
	@FindBy(id="txt_val_4")
	private WebElement txtVal3;
	
	@FindBy(id="txt_val_5")
	private WebElement txtVal4;
	
	@FindBy(id="txt_val_6")
	private WebElement txtVal5;
	
	@FindBy(id="txt_ttl_val")
	private WebElement txtTotalBal;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@SuppressWarnings("deprecation")
	public void navigateToHomePage() {
		driver.get(prop.getProperty("url"));
		Assert.assertTrue(driver.getTitle()=="ValuesExcersize");
	}
	
	@SuppressWarnings("deprecation")
	public void  verifyValueFieldsCount() {
		Assert.assertTrue("Value 1 field value exists?", txtVal1.isDisplayed());
		Assert.assertTrue("Value 2 field value exists?", txtVal2.isDisplayed());
		Assert.assertTrue("Value 3 field value exists?", txtVal3.isDisplayed());
		Assert.assertTrue("Value 4 field value exists?", txtVal4.isDisplayed());
		Assert.assertTrue("Value 5 field value exists?", txtVal5.isDisplayed());
	}
	
	@SuppressWarnings("deprecation")
	public void verifyValuesGreaterThanZero() {
		Assert.assertTrue("Value 1 field value is Greater Than zero?",Integer.parseInt(txtVal1.getAttribute("value").replace("$", ""))>0);
		Assert.assertTrue("Value 1 field value is Greater Than zero?",Integer.parseInt(txtVal2.getAttribute("value").replace("$", ""))>0);
		Assert.assertTrue("Value 1 field value is Greater Than zero?",Integer.parseInt(txtVal3.getAttribute("value").replace("$", ""))>0);
		Assert.assertTrue("Value 1 field value is Greater Than zero?",Integer.parseInt(txtVal4.getAttribute("value").replace("$", ""))>0);
		Assert.assertTrue("Value 1 field value is Greater Than zero?",Integer.parseInt(txtVal5.getAttribute("value").replace("$", ""))>0);
	}
	
	@SuppressWarnings("deprecation")
	public void verifySumOfValues() {
		int actualTotal = Integer.parseInt(txtVal1.getAttribute("value"))+
				Integer.parseInt(txtVal2.getAttribute("value").replace("$", "")) +
				Integer.parseInt(txtVal3.getAttribute("value").replace("$", "")) +
				Integer.parseInt(txtVal4.getAttribute("value").replace("$", "")) +
				Integer.parseInt(txtVal5.getAttribute("value").replace("$", ""));
		int displayedTotal =  Integer.parseInt(txtTotalBal.getAttribute("value").replace("$", ""));
		Assert.assertEquals(actualTotal, displayedTotal);
	}
	
	@SuppressWarnings("deprecation")
	public void validateValueFormat() {
		String regExp = "(?:\\$)[1-9]*(?:\\,)[1-9]*(?:\\.)[0-9]*";

		Assert.assertTrue(Pattern.matches(regExp, txtVal1.getAttribute("value")));
		Assert.assertTrue(Pattern.matches(regExp, txtVal2.getAttribute("value")));
		Assert.assertTrue(Pattern.matches(regExp, txtVal3.getAttribute("value")));
		Assert.assertTrue(Pattern.matches(regExp, txtVal4.getAttribute("value")));
		Assert.assertTrue(Pattern.matches(regExp, txtVal5.getAttribute("value")));
		Assert.assertTrue(Pattern.matches(regExp, txtTotalBal.getAttribute("value")));
	}
	
}
