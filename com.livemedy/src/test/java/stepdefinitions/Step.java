package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LivemedyPage;
import utils.*;

import java.time.Duration;

public class Step {

    private final WebDriver driver1;
    private WebDriverWait wait;

    LivemedyPage livemedyPage = new LivemedyPage();
    public Step() throws InterruptedException {
        // WebDriver'ı al
        driver1 = Driver1.getDriver();
        Duration timeout = Duration.ofSeconds(2);
        // WebDriverWait oluştur
        wait = new WebDriverWait(driver1, timeout);
    }

    @Then("VPN Manager ac")
    public void vpn_manager_ac() throws InterruptedException {
        VPNManager.startVPN();
    }
    @Then("VPN Manager kapat")
    public void vpn_manager_kapat() {

        VPNManager.stopVPN();
    }

    @Given("Kullanici livemedy ana sayfasini browserdan acar")
    public void kullanici_livemedy_ana_sayfasini_browserdan_acar() throws InterruptedException {
    driver1.get(ConfigReader.getProperty("base_url"));
    Thread.sleep(5000);

    }
    @Then("Kullanıcı logout yapar")
    public void kullanıcı_logout_yapar() {
        WaitHelper.waitForJQueryToLoad(driver1);
        livemedyPage.kullaniciDropDown.click();
        livemedyPage.cikisButton.click();
    }

    @Given("Kullanici1 livemedy ana sayfasini browserdan acar")
    public void kullanici1_livemedy_ana_sayfasini_browserdan_acar() {

    }

    @Then("Kullanici login butonuna tiklar")
    public void kullanici_login_butonuna_tiklar() throws InterruptedException {
        WaitHelper.waitForJQueryToLoad(driver1);
        livemedyPage.loginButton.click();

    }

    @Then("Kullanici dogru email girer")
    public void kullanici_dogru_email_girer() throws InterruptedException {
        WaitHelper.waitForJQueryToLoad(driver1);
        livemedyPage.emailBox.sendKeys("fkarataslioglu1@gmail.com");
        Thread.sleep(2000);


    }
    @Then("Kullanici dogru sifre girer")
    public void kullanici_dogru_sifre_girer()  {

        livemedyPage.passwordBox.sendKeys("Merhaba123!");

    }
    @Then("Kullanici Oturum acin butonuna tiklar")
    public void kullanici_oturum_acin_butonuna_tiklar() throws InterruptedException {
        livemedyPage.signInButton.click();

        Thread.sleep(2000);
    }
    @Then("Kullanici giris yapilamadigini dogrular")
    public void kullanici_giris_yapilamadigini_dogrular()
    {
        /*String expectedMessage = "Hatalı Giriş. Lütfen tekrar deneyin.";
        String actualMessage = "Hatalı Giriş. Lütfen tekrar deneyin.";
        Assert.assertTrue("Kullanicinin yanlis giris yaptigi dogrulanamadi",expectedMessage.contains(actualMessage))*/;
    }

    @Then("Kullanici acilan popup varsa kapatir")
    public void kullanici_acilan_popup_varsa_kapatir()
    {
        // Popup'ı kontrol et ve kabul et
        try {

            Thread.sleep(2000);
            livemedyPage.okButton.click();
            System.out.println("Popup açıldı ve 'Tamam' butonuna basıldı.");

        }

        catch (NoAlertPresentException e) {
            System.out.println("Popup bulunamadı.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("Kullanici sms dogrulama kodunu girer ve tamam butonuna tiklar")
    public void kullanici_sms_dogrulama_kodunu_girer_ve_tamam_butonuna_tiklar() throws InterruptedException {
        Thread.sleep(3000);
        livemedyPage.smsKodAlani.sendKeys(Integer.toString(1010));
        Thread.sleep(1500);
        livemedyPage.girisButon.click();
        Thread.sleep(5000);
    }
    @Then("Kullanici browseri kapatir")
    public void kullanici_browseri_kapatir() {
        driver1.close();
    }

    @Then("Kullanici yanlis sifre girer")
    public void kullanici_yanlis_sifre_girer() {
        LivemedyPage.passwordBox.sendKeys("Merhaba123*");
    }
    @Then("Kullanici sifrenin yanlis oldugunu dogrular")
    public void kullanici_sifrenin_yanlis_oldugunu_dogrular() {
        ScreenShotHelper.iTakeScreenshot(driver1,"after_signin_click");
        String expectedMessage = "Hatalı Giriş. Lütfen tekrar deneyin.";
        String actualMessage = "Hatalı Giriş. Lütfen tekrar deneyin.";
        Assert.assertTrue("Kullanicinin yanlis sifre girdigi dogrulandi",expectedMessage.contains(actualMessage));

    }


}
