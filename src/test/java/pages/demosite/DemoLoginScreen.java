package pages.demosite;

import org.junit.jupiter.api.Assertions;

import net.serenitybdd.annotations.Step;


public class DemoLoginScreen {

        DemoLoginPage loginScreenPage;

        @Step
        public void openApplication()  {
        loginScreenPage.open();
        long maxWaitTime = 5000; // maximum wait 5Sec time
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < maxWaitTime) {
            if (loginScreenPage.getDriver().getCurrentUrl().equals(DemoLoginPage.getDefaultUrl())) {
                break;
            }
            try {
                Thread.sleep(2000); // 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Step
    public void login(String username, String password) {
        loginScreenPage.setuser(username);
        loginScreenPage.setpassword(password);
        loginScreenPage.clickloginbtn();
        loginScreenPage.verifyLogin();

    }

    @Step
    public void selectProduct(String product)
    {
       loginScreenPage.selectProduct(product);
    }

    @Step
    public void verifyPriceofElement(String price)
    {
        System.out.println(loginScreenPage.getProductPrice());
        Assertions.assertEquals("$"+price, loginScreenPage.getProductPrice(),"Actual Product price is not equal to :$"+price);

    }

}
