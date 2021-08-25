package steps;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

/*            //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            //take a quantity of PAID values Protocol Type in list of Subscription
            List<WebElement> quantityOfPaidTypeFinalAccountMS = getElementsByXpath(driver, "//*[text()='Paid']");
            quantityOfPaidTypeFinalAccountMSInt = quantityOfPaidTypeFinalAccountMS.size();*/

            //check
            if ((quantityOfTypeSubscriptionInt != quantityOfTypeFinalAccountMSInt)
                    & (quantityOfTypeFinalAccountCPInt + quantityOfPaidTypeFinalAccountMSInt != quantityOfTypeFinalAccountMSInt)) {
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

                //get values Protocol Type in list of Final Account Mounthly Subscription
                String PTMounthlySubscription = getElementByXpath(driver, "((//div/span[text()='Monthly Subscription']/parent::div)/following-sibling::div[3]//p[contains(text(),'FIX')])["+ p +"]").getText();

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

            //get values Protocol Type in list of Final Account Mounthly Subscription
            String PTMounthlySubscription = getElementByXpath(driver, "((//div/span[text()='Monthly Subscription']/parent::div)/following-sibling::div[3]//p[contains(text(),'FIX')])[" + i + "]").getText();

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
            return PTCurrentPayment;
        }
        return null;
    }


    //check Mounthly Subscription
    public void checkMounthlySubcriptionFinalAccount() throws Exception {
        totalAddPriceSessionsMS=0;
        totalPriceMS=0;
        for (int i = 1; i <= quantityOfTypeSubscriptionInt; i++) {
            //get values Price in list of Subscription
            String priceListSubscription = getElementByXpath(driver, "(((//input [@type='checkbox' and @value='false']/../../..)/following-sibling::div[2]/div/p[contains(text(),'FIX')])/../following-sibling::div[2]/p[contains(text(),'$')])["+i+"]").getText();
            String ePriceListSubscription = priceListSubscription.replaceAll("[^0-9]", "");
            int iPriceListSubscription = Integer.parseInt(ePriceListSubscription);
            totalPriceMS = iPriceListSubscription+totalPriceMS;

            //get values Price Sessions in list of Subscription
            String priceSessionsListSubscription = getElementByXpath(driver, "(//div/p[text()='Price: $'])["+i+"]").getText();
            String ePriceSessionsListSubscription = priceSessionsListSubscription.replaceAll("[^0-9]", "");
            int iPriceSessionsListSubscription = Integer.parseInt(ePriceSessionsListSubscription);
            totalPriceSessionsMS = iPriceSessionsListSubscription+totalPriceSessionsMS;

            try{
                //get values Additional Price Sessions in list of Subscription
                for (int p = 1; p <=1 ; p++) {
                    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                    waitForElementToAppear(driver, "((//div/p[text()='Price: $'])["+i+"]/following-sibling::div[2]/div[2])/span", 1);
                    String addPriceSessionsListSubscription = getElementByXpath(driver, "((//div/p[text()='Price: $'])["+i+"]/following-sibling::div[2]/div[2])/span").getText();
                    String eAddPriceSessionsListSubscription = addPriceSessionsListSubscription.replaceAll("[^0-9]", "");
                    //totalAddPriceSessionsMS=0;
                    int iAddPriceSessionsListSubscription = Integer.parseInt(eAddPriceSessionsListSubscription);
                    int totalTest = 0;
                    totalTest = (iAddPriceSessionsListSubscription * iPriceSessionsListSubscription);
                    totalAddPriceSessionsMS = totalTest+totalAddPriceSessionsMS;
                }

            } catch (Exception e){driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
        }


        try {
            int totalMSFromList = totalPriceMS + totalAddPriceSessionsMS;
            String getMS = getElementByXpath(driver, "//div/span[text()='Monthly Subscription']/following-sibling::*").getText();
            String eGetMS = getMS.replaceAll("[^0-9]", "");
            iGetMS= Integer.parseInt(eGetMS);

            if (totalMSFromList != iGetMS) {
                throw new Exception("Value of Mounthly Subscription is not correct");
            }
        }catch (Exception e){
            throw new Exception("Value of Mounthly Subscription is not correct / or Element \"Mounthly Subscription\" is not visible");
        }
    }


    //check Current Payment
    public void checkCurrentPaymentFinalAccount() throws Exception {
        Thread.sleep(2000);
        int totalPriceCP = 0;
        for (int i = 1; i <= quantityOfTypeSubscriptionInt; i++) {
            //get values Price in list of Subscription
            String CPListSubscription = getElementByXpath(driver, "(//div/p[text()='Current Payment']/../p[contains(text(),'$')])["+i+"]").getText();
            String eCPListSubscription = CPListSubscription.replaceAll("[^0-9]", "");
            int iCPListSubscription = Integer.parseInt(eCPListSubscription);
            totalPriceCP = iCPListSubscription+totalPriceCP;
        }

        try {
            String getCP = getElementByXpath(driver, "//div/span[text()='Current Payment']/following-sibling::*").getText();
            String eGetCP = getCP.replaceAll("[^0-9]", "");
            iGetCP = Integer.parseInt(eGetCP);

            if(totalPriceCP!=iGetCP){
                throw new Exception("Value of Current Payment is not correct");
            }
        }catch (Exception e){
            throw new Exception("Value of Current Payment is not correct / or Element \"Current Payment\" is not visible");
        }
    }




}
