package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Base;
import utils.Driver;

public class Hooks extends Base {
@Before
    public void setup(){
    Driver.getDriver();
    Base.waitImplicit();
    Driver.getDriver().manage().window().maximize();
}


@After
    public void kill(Scenario scenario){
    if(scenario.isFailed()){
        byte[] data= ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
   scenario.attach(data,"image/png",scenario.getName());
    }
    Driver.closeDriver();
}

}
