package steps;

import org.openqa.selenium.WebElement;

import java.util.List;

public class FinalAccount extends UICustomSteps {

    //check of values Protocol Type
    public void checkProtocolTypeFinalAccount() throws Exception {

        //check a quantity of values Protocol Type
        checkQuantityPT();

        //for Paid Exchange check Protocol Type
        checkPaidExchange();

        //for Unpaid Exchange check Protocol Type
        checkUnPaidExchange();
    }

    //check a quantity of values Protocol Type
    public void checkQuantityPT() throws Exception {
        try {
            //take a quantity of PAID values Protocol Type in list of Subscription
            List<WebElement> quantityOfPaidTypeFinalAccountMS = getElementsByXpath(driver, "//span[text()='Paid']");
            quantityOfPaidTypeFinalAccountMSInt = quantityOfPaidTypeFinalAccountMS.size();

            //take a quantity of values Protocol Type in list of Subscription
            List<WebElement> quantityOfTypeSubscription = getElementsByXpath(driver, "//input [@type='checkbox' and @value='false']");
            quantityOfTypeSubscriptionInt = quantityOfTypeSubscription.size();
            quantityOfTypeSubscriptionInt--;

            //take a quantity of values Protocol Type in list of Final Account Mounthly Subscription
            List<WebElement> quantityOfTypeFinalAccountMS = getElementsByXpath(driver, "(//div/span[text()='Monthly Subscription']/parent::div)[1]/following-sibling::div[3]//p[contains(text(),'FIX')]");
            int quantityOfTypeFinalAccountMSInt = quantityOfTypeFinalAccountMS.size();

            Thread.sleep(1000);
            //take a quantity of values Protocol Type in list of Final Account Current Payment
            List<WebElement> quantityOfTypeFinalAccountCP = getElementsByXpath(driver, "(//div/span[text()='Current Payment']/parent::div)[1]/following-sibling::div[3]//span[contains(text(),'FIX')]");
            quantityOfTypeFinalAccountCPInt = quantityOfTypeFinalAccountCP.size();

            //check
            if ((quantityOfTypeSubscriptionInt != quantityOfTypeFinalAccountMSInt)
                    & (quantityOfTypeFinalAccountCPInt - quantityOfPaidTypeFinalAccountMSInt != quantityOfTypeFinalAccountMSInt)) {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception("a quantity of values Protocol Type is not correct");
        }
    }

    //for Paid Exchange check Protocol Type
    public void checkPaidExchange() throws Exception {
        if(quantityOfPaidTypeFinalAccountMSInt!=0){
            for (int p = 1; p <= quantityOfPaidTypeFinalAccountMSInt; p++) {
                //get values Protocol Type in list of Subscription
                String PTListSubscription = getElementByXpath(driver, "((//input [@type='checkbox' and @value='false']/../../..)/following-sibling::div[2]/div/p[contains(text(),'FIX')])[" + p + "]").getText();
                System.out.println(PTListSubscription);

                //get values Protocol Type in list of Final Account Mounthly Subscription
                String PTMounthlySubscription = getElementByXpath(driver, "((//div/span[text()='Monthly Subscription']/parent::div)/following-sibling::div[3]//p[contains(text(),'FIX')])["+ p +"]").getText();
                System.out.println(PTMounthlySubscription);

                if(!PTListSubscription.equals(PTMounthlySubscription)){
                    throw new Exception("trouble with check of Paid Exchange");
                }
            }
        }
    }

    //for Unpaid Exchange check Protocol Type
    public void checkUnPaidExchange() throws Exception {
        for (int i = 1 + quantityOfPaidTypeFinalAccountMSInt; i <= quantityOfTypeSubscriptionInt; i++) {
            //get values Protocol Type in list of Subscription
            String PTListSubscription = getElementByXpath(driver, "((//input [@type='checkbox' and @value='false']/../../..)/following-sibling::div[2]/div/p[contains(text(),'FIX')])[" + i + "]").getText();
            System.out.println(PTListSubscription);

            //get values Protocol Type in list of Final Account Mounthly Subscription
            String PTMounthlySubscription = getElementByXpath(driver, "((//div/span[text()='Monthly Subscription']/parent::div)/following-sibling::div[3]//p[contains(text(),'FIX')])[" + i + "]").getText();
            System.out.println(PTMounthlySubscription);

            if ((!reversePTCurrentPayment().equals(PTMounthlySubscription))
                    && ((!PTListSubscription.equals(PTMounthlySubscription)))) {
                throw new Exception("trouble with check of Paid Exchange");
            }
        }
    }

    public String reversePTCurrentPayment() throws InterruptedException {
        for (int j = quantityOfTypeSubscriptionInt - quantityOfPaidTypeFinalAccountMSInt; j >= 1; j--) {
            //get values Protocol Type in list of Subscription
            String PTCurrentPayment = getElementByXpath(driver, "((//div/span[text()='Current Payment']/parent::div)/following-sibling::div[3]//span[contains(text(),'FIX')])[" + j + "]").getText();
            System.out.println(PTCurrentPayment);
            return PTCurrentPayment;
        }
        return null;
    }
}
