package com.nycjv321.hackathon.traditional.pages;

import com.nycjv321.hackathon.traditional.components.CompareExpenses;
import com.nycjv321.hackathon.traditional.components.Document;
import com.nycjv321.hackathon.traditional.components.RecentTransactionsComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard extends Document {
    private Dashboard(WebDriver driver) {
        super(driver);
    }

    public static Dashboard create(WebDriver driver) {
        return new Dashboard(driver);
    }

    public RecentTransactionsComponent getRecentTransactions() {
        return new RecentTransactionsComponent(driver);
    }

    public CompareExpenses compareExpenses() {
        find(By.id("showExpensesChart")).click();
        return new CompareExpenses(driver);
    }

    public WebElement getAdOne() {
        return find(By.id("flashSale img"));
    }
    public WebElement getAdTwo() {
        return find(By.cssSelector("#flashSale2 img"));
    }
}
