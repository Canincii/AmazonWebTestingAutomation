package StepDefinitions;

import Pages.AmazonPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;


public class AmazonSteps {
    WebDriver driver = DriverFactory.getDriver();
    AmazonPages amazonPages = new AmazonPages(driver);

    @Given("Kullanici anasayfada olur")
    public void kullaniciAnasayfadaOlur(){
        AmazonPages.anasayfa();
    }

    @When("Popup kabul eder")
    public void popupKabulEder() {
        AmazonPages.popupKabul();
    }

    @When("Arama textine tiklar")
    public void aramaTextineTiklar() {
        AmazonPages.aramaTextineTikla();
    }

    @When("Urun adini girer")
    public void urunAdiniGirer() {
        AmazonPages.urunAdi();
    }

    @When("Arama butonuna tiklar")
    public void aramaButonunaTiklar() {
        AmazonPages.aramaButonu();

    }

    @When("Kargo secenegini butonuna tiklar")
    public void kargoSeceneginiButonunaTiklar() {
        AmazonPages.kargoSecenigi();
    }

    @When("Dört yildiz ve üzerini secer")
    public void dortYildizVeUzeriniSecer() {
        AmazonPages.dortYildizVeUzeri();
    }

    @When("Urune tiklar")
    public void uruneTiklar() {
        AmazonPages.uruneTikla();
    }

    @When("Olcü secilir")
    public void olcuSecilir() {
        AmazonPages.olcuSec();
    }

    @When("Sepete ekle butonuna tiklanir")
    public void sepeteEkleButonunaTiklanir() {
        AmazonPages.sepeteEkle();
    }

    @When("Sepete git butonuna tiklanir")
    public void sepeteGitButonunaTiklanir() {
        AmazonPages.sepeteGit();
    }

    @Then("Sepette ürün kontrol edilir")
    public void sepetteUrunKontrolEdilir() {
        AmazonPages.sepetKontrol();
    }


}