package testcases;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ComposeEmailSteps {
   public static WebDriver driver = null;

    @Given("I am logged into Gmail")
    public void i_am_logged_into_gmail() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mail.google.com/mail/u/0/#inbox");
        driver.findElement(By.id("identifierId")).sendKeys("Email ID");
        driver.findElement(By.id("identifierNext")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
        driver.findElement(By.name("password")).sendKeys("Password");
        driver.findElement(By.id("passwordNext")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("I click on \"Compose\"")
    public void i_click_on_compose() {
        WebElement composeButton = driver.findElement(By.cssSelector(".T-I.T-I-KE.L3"));
        composeButton.click();
    }

    @When("I enter the recipient email")
    public void i_enter_the_recipient_email() {
        WebElement toField = driver.findElement(By.name("to"));
        toField.sendKeys("sahdh22@gmail.com");
    }

    @When("I enter the subject \"Incubyte\"")
    public void i_enter_the_subject_incubyte() {
        WebElement subjectField = driver.findElement(By.name("subjectbox"));
        subjectField.sendKeys("Incubyte");
    }

    @When("I enter the email body \"Automation QA test for Incubyte\"")
    public void i_enter_the_email_body_automation_qa_test_for_incubyte() {
        WebElement bodyField = driver.findElement(By.cssSelector(".Am.Al.editable.LW-avf"));
        bodyField.sendKeys("Automation QA test for Incubyte");
    }

    @When("I click on \"Send\"")
    public void i_click_on_send() {
        WebElement sendButton = driver.findElement(By.cssSelector(".T-I.J-J5-Ji.aoO.v7.T-I-atl.L3"));
        sendButton.click();
    }

    @Then("the email should be sent successfully")
    public void the_email_should_be_sent_successfully() {
        WebElement sentMessage = driver.findElement(By.xpath("//*[contains(text(),'Message sent.')]"));
        assert(sentMessage.isDisplayed());
    }

    @Then("the email should appear in the \"Sent\" folder with subject \"Incubyte\"")
    public void the_email_should_appear_in_the_sent_folder_with_subject_incubyte() {
        WebElement sentFolder = driver.findElement(By.linkText("Sent"));
        sentFolder.click();
        WebElement sentEmail = driver.findElement(By.xpath("//*[contains(text(),'Incubyte')]"));
        assert(sentEmail.isDisplayed());
    }

    @When("I leave the recipient email blank")
    public void i_leave_the_recipient_email_blank() {
        // Do nothing
    }

    @Then("I should see an error message indicating recipient is required")
    public void i_should_see_an_error_message_indicating_recipient_is_required() {
        WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(),'Please specify at least one recipient.')]"));
        assert(errorMessage.isDisplayed());
    }

    @When("I leave the subject blank")
    public void i_leave_the_subject_blank() {
        // Do nothing 
    }

    @Then("I should see a warning prompt asking to confirm sending without subject")
    public void i_should_see_a_warning_prompt_asking_to_confirm_sending_without_subject() {
        WebElement warningPrompt = driver.findElement(By.xpath("//*[contains(text(),'Send this message without a subject')]"));
        assert(warningPrompt.isDisplayed());
    }

    @When("I leave the email body blank")
    public void i_leave_the_email_body_blank() {
        // Do nothing 
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
