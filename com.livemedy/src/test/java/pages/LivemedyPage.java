package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver1;


public class LivemedyPage {
public LivemedyPage(){

    PageFactory.initElements(Driver1.getDriver(), this);
}
    @FindBy(xpath = "//a[text()='Giriş']")
    public static WebElement loginButton;

    @FindBy(xpath= "//*[@id='Email']")
    public static WebElement emailBox;

    @FindBy(xpath= "//*[@id='Password']")
    public static WebElement passwordBox;

    @FindBy(xpath="//button[@id='formSubmit'][1]")
    public static WebElement signInButton;

    @FindBy(xpath="//*[@class='swal2-html-container']")
    public static WebElement hataliGiris;

    @FindBy(xpath="//button[normalize-space()='TAMAM']")
    public static WebElement okButton;

    @FindBy(xpath = "//div[@class='d-flex justify-content-between w-100 my-4 pt-2 pb-4']//input[1]")
    public static WebElement smsKodAlani;

    @FindBy(xpath = "//button[@id='verifySmsCode']")
    public static WebElement girisButon;
    @FindBy(xpath = "//a[contains(@class, 'd-none') and @role='button']")
    public static WebElement kullaniciDropDown;
    @FindBy(xpath = "//a[@href='/tr/Patient/account/logout']")
    public static WebElement cikisButton;
}
