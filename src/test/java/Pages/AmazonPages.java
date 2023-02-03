package Pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.util.List;

public class AmazonPages {
    static WebDriver driver;
    static ElementHelper elementHelper;
    static WebDriverWait wait;

    static By popupKabul = By.id("sp-cc-accept");
    static By aramaTexti = By.id("twotabsearchtextbox");
    static By aramaButonu = By.id("nav-search-submit-button");
    static By kargoSecenegi = By.cssSelector("[aria-label='150 TL Üzeri Kargo BEDAVA'] .a-icon");
    static By uruneTikla = By.cssSelector(".a-size-base-plus");
    static By yildizButonu = By.cssSelector(".a-star-medium-4");
    static By olcuSecimiButonu = By.id("native_dropdown_selected_size_name");
    static By sepeteEkleButonu = By.id("add-to-cart-button");
    static By sepeteGitButonu = By.cssSelector("[data-csa-c-content-id='sw-gtc_CONTENT']");
    static By sepetiKontrolEt = By.id("sc-active-C405d819e-19a0-4d2b-9fd1-e4cdfc7a8800");


    public AmazonPages(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        this.elementHelper = new ElementHelper(driver);
    }



    public static void anasayfa() {

    }
    public static void popupKabul() {
        elementHelper.click(popupKabul);
    }
    public static void aramaTextineTikla() {
        elementHelper.click(aramaTexti);
    }

    public static void urunAdi() {
        elementHelper.findElement(aramaTexti).sendKeys("Motorcu Eldiveni");
    }

    public static void aramaButonu() {
        elementHelper.findElement(aramaButonu).click();

    }

    public static void kargoSecenigi() {
        elementHelper.click(kargoSecenegi);

    }

    public static void dortYildizVeUzeri() {
        elementHelper.findElement(yildizButonu).click();
    }

    public static void uruneTikla() {
        elementHelper.click(uruneTikla);
    }

    public static void olcuSec() {
        elementHelper.findElement(olcuSecimiButonu).click();
    }

    public static void sepeteEkle() {
        elementHelper.click(sepeteEkleButonu);
    }

    public static void sepeteGit() {
        elementHelper.click(sepeteGitButonu);
    }

    public static void sepetKontrol() {
        elementHelper.checkVisible(sepetiKontrolEt);
    }
}
