package API.Validators;

import API.Pojos.CurrentWeather;
import API.Request.RequestConstants.StatusCodes;
import io.restassured.response.Response;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.asserts.SoftAssert;

/**
 * Created by cristian on 5/31/18.
 */
public class CurrentWeatherValidator {

  protected static final Logger LOGGER = Logger.getLogger( CurrentWeatherValidator.class.getName() );

  protected CurrentWeather currentWeather;
  protected SoftAssert softAssert = new SoftAssert();
  protected Response response;

  protected CurrentWeatherValidator responseToPojo (Response response) {
    LOGGER.log(Level.INFO,response.asString());
    if (response.statusCode() == StatusCodes.SUCCESS.getName()) {
      this.response = response;
      currentWeather =  response.as(CurrentWeather.class);
    }
    return this;
  }

  protected  CurrentWeatherValidator validateStatusCode(int statusCode){
    softAssert.assertTrue
        (response.getStatusCode() == statusCode,"StatusCode not match");
    return this;
  }

  protected CurrentWeatherValidator validateStringContains(String sentence, String contains){
    softAssert.assertTrue(sentence.contains(contains),"Expecting: "+sentence+" to contain: "+contains);
    return this;
  }

  protected CurrentWeatherValidator validateStringParamIsNotNull(String param){
    softAssert.assertTrue(param.length() > 0,"Param is null");
    return this;
  }

  protected CurrentWeatherValidator validateIntegerParamIsNotNull(int param){
    softAssert.assertTrue(param >= 0,"param is null");
    return this;
  }

  protected CurrentWeatherValidator validateStringEquals(String param1, String param2){
    softAssert.assertTrue(param1.equals(param2),param1+" do not match: "+param2);
    return this;
  }

}
