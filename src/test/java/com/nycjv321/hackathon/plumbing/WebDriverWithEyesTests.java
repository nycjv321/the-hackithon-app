package com.nycjv321.hackathon.plumbing;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebElement;
import org.testng.IInvokedMethod;
import org.testng.IMethodInstance;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.xml.XmlTest;

import java.lang.reflect.Method;

public abstract class WebDriverWithEyesTests extends WebDriverTests {

    protected Eyes eyes;
    private Method testMethod;

    @BeforeClass(alwaysRun = true)
    public void setupSuite(ITestContext tc) {
        eyes = new Eyes();
        eyes.setApiKey("z2bCs8WdvvNpR110G2Ze1XLHFNRYGiHKy1yPtlOnoXv6M110");
        eyes.setBatch(new BatchInfo(tc.getName()));
    }

    @BeforeMethod
    public void setup(Method method) {
        super.setup();
        this.testMethod = method;
    }


    @AfterMethod
    public void teardown() {
        super.teardown();
        eyes.abortIfNotClosed();
    }

    private String getMethodName() {
        return Thread.currentThread().getStackTrace()[4].getMethodName();
    }

    protected void validateWindow(MatchLevel matchLevel) {
        eyes.setMatchLevel(matchLevel);
        eyes.open(getWebDriver(), "ACME demo app", getMethodName());
        eyes.checkWindow();
        eyes.setForceFullPageScreenshot(true);
        eyes.close();
    }

    protected void validateElement(MatchLevel matchLevel, WebElement element) {
        eyes.setMatchLevel(matchLevel);
        eyes.open(getWebDriver(), "ACME demo app", getMethodName());
        eyes.checkElement(element);
        eyes.close();
    }

    protected void validateElementRegion(MatchLevel matchLevel, WebElement element) {
        eyes.setMatchLevel(matchLevel);
        eyes.open(getWebDriver(), "ACME demo app", getMethodName());
        eyes.checkRegion(element);
        eyes.close();
    }


    protected void validateWindowStrictly() {
        validateWindow(MatchLevel.STRICT);
    }

    protected void validateWindowContent() {
        validateWindow(MatchLevel.CONTENT);
    }

    protected void validateWindowLayout() {
        validateWindow(MatchLevel.LAYOUT);
    }

    protected void validateElementStrict(WebElement element) {
        validateElement(MatchLevel.STRICT, element);
    }

    protected void validateElementContent(WebElement element) {
        validateElement(MatchLevel.CONTENT, element);
    }

    protected void validateElementLayout(WebElement element) {
        validateElement(MatchLevel.LAYOUT, element);
    }

    protected void validateElementRegionLayout(WebElement element) {
        validateElementRegion(MatchLevel.LAYOUT, element);
    }





}