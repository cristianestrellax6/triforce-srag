package API;

import API.DataProviders.CurrentWeatherProvider;
import API.Request.RequestConstants.StatusCodes;
import API.Request.ValuesConstants.Values;
import API.Validators.CurrentWeatherValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

/**
 * Created by cristian on 5/28/18.
 */
public class RestAssured extends CurrentWeatherValidator {

  @Test(dataProviderClass = CurrentWeatherProvider.class, dataProvider = "getByCityProvider")
  public void getWeatherByCityTest (Response response){
    responseToPojo(response);
    validateStatusCode(StatusCodes.SUCCESS.getName());
    validateStringContains(Values.CITY_NAME.getName(),currentWeather.getName());
    validateStringParamIsNotNull(currentWeather.getWeather().get(0).getDescription());
    validateIntegerParamIsNotNull(currentWeather.getId());

    softAssert.assertAll();
  }

  @Test(dataProviderClass = CurrentWeatherProvider.class, dataProvider = "getByIDProvider")
  public void getWeatherByIDTest (Response response){
    responseToPojo(response);
    validateStatusCode(StatusCodes.SUCCESS.getName());
    validateStringContains(Values.CITY_NAME.getName(),currentWeather.getName());
    validateStringEquals(currentWeather.getId().toString(),Values.BY_ID.getName());

    softAssert.assertAll();
  }

}
