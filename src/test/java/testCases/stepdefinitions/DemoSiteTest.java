	package testCases.stepdefinitions;

import Utils.PropertyFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractions;
import pages.demosite.DemoLoginScreen;

public class DemoSiteTest extends UIInteractions {
    PropertyFileReader prop=new PropertyFileReader("src/test/resources/config.properties");
    @Steps
    DemoLoginScreen loginScreen;


    @Given("User is on Login Screen")
    public void userIsOnLoginScreen() {
        loginScreen.openApplication();
    }
    @When("User enters  username and password and clicks on login button")
    public void userEntersAndAndClicksOnLoginButton() {
        loginScreen.login(prop.getProperty("username"), prop.getProperty("password"));
    }
    @Then("User selects {} from the list")
    public void userSelectstheProduct(String product) {
        loginScreen.selectProduct(product);
    }

    @And("^User verify the product price is equal to the (.*)")
    public void userVerifyTheProductPriceIsEqualToThe(String price) {
        loginScreen.verifyPriceofElement(price);
    }

   /* @When("User enters  {string} and {} and clicks on login button")
    public void userEntersAndAndClicksOnLoginButton(String sheetname, int rownumber) throws IOException, InvalidFormatException {
        ExcelReader reader=new ExcelReader();
        String ExcelPath="D:\\Neha\\serenity_bdd\\src\\test\\resources\\TestData\\ExcelData.xlsx";
        List<Map<String,String>> testdata=reader.getData(ExcelPath,sheetname);
        String username = testdata.get(rownumber).get("username");
        String password = testdata.get(rownumber).get("password");
        String  product = testdata.get(rownumber).get("productName");
        System.out.println("User Enter username as \" " + username + " \"and Password as \" " + password + "\" ");

        if (username != null || password != null)
            loginScreen.login(username,password);
    }*/
   @Then("User should land on home page")
    public void userShouldLandOnHomePage() {
    }



}


