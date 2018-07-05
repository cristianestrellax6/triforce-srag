package API.DataProviders;


import API.Request.RequestConstants.EndpointPaths;
import API.Request.RequestConstants.WeatherParams;
import API.Request.ValuesConstants.Values;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;

/**
 * Created by cristian on 5/28/18.
 */
public class CurrentWeatherProvider {

  @DataProvider(name = "getByCityProvider")
  public static Object[][]  getByCityProvider (){
    Response response = RestAssured.given()
        .queryParam(WeatherParams.SEARCH_PARAM.getName(), Values.CITY_NAME.getName())
        .queryParam(WeatherParams.APPID_PARAM.getName(),Values.APPID.getName())
        .get(EndpointPaths.WEATHER_PATH.getName());

    return new Object[][]{{response}};
  }
  @DataProvider(name = "getByIDProvider")
  public static Object[][]  getByIDProvider (){
    Response response = RestAssured.given()
        .queryParam(WeatherParams.SEARCH_PARAM.getName(), Values.BY_ID.getName())
        .queryParam(WeatherParams.APPID_PARAM.getName(),Values.APPID.getName())
        .get(EndpointPaths.WEATHER_PATH.getName());

    return new Object[][]{{response}};
  }

}
