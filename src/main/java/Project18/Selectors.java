package Project18;
import org.openqa.selenium.By;

public class Selectors {
    public static By username = By.cssSelector("input[data-placeholder=\"Username\"]");
    public static By password = By.cssSelector("input[data-placeholder=\"Password\"]");
    public static By loginbutton = By.cssSelector("button[aria-label='LOGIN'");

    public static By accountname=By.cssSelector("span.username");
    public static By loginalert=By.xpath("//div[@role='alertdialog']");
    public static By emailalert=By.xpath("//mat-error[text()=' Email is required ']");
    public static By passwordalert=By.xpath("//mat-error[text()=' Password is required ']");
    public static By addausername=By.cssSelector("a[href=\"addauser.php\"]");
    public static By inputusername=By.cssSelector("input[name='username']");
    public static By inputpassword=By.cssSelector("input[name='password']");
    public static By inputsave=By.cssSelector("input[type='button']");
    public static By theusername=By.cssSelector("blockquote:nth-child(1) > p");
    public static By loginausername=By.cssSelector("a[href=\"login.php\"]");
    public static By faillogin=By.xpath("//b[text()='**Failed Login**']");
    public static By successlogin=By.cssSelector("blockquote  b");


}
