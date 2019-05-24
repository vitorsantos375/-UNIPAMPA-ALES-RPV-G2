/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConfiguracaoSelenium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Filipe Garcia
 */
public class TestCase_dados extends TestCase {
    
 public static String url = "http://localhost:8080/RPV-G2-Gamming2/";

    public TestCase_dados() {
     super();
    }
    

public void sleep() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Before
    public void beforeMethod() throws MalformedURLException {
        webDriver = new FirefoxDriver();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @After
    public void afterMethod() {
        webDriver.close();
    }

}
