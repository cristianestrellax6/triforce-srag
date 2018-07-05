package API.Request;

/**
 * Created by cristian on 5/28/18.
 */
public enum  RequestConstants {

  RequestConstants(){};

  public enum StatusCodes {
    SUCCESS(200),
    BAD_REQUEST(400),
    ERROR(500);

    private int name;

    public int getName() {return name;}

    StatusCodes(int name){this.name = name;}
  }

  public enum EndpointPaths {
    WEATHER_PATH("http://samples.openweathermap.org/data/2.5/weather");

    private String name;

    public String getName() {return name;}

    EndpointPaths(String name){this.name = name;}
  }

  public enum WeatherParams {
    SEARCH_PARAM("q"),
    APPID_PARAM("appid");

    private String name;

    public String getName() {return name;}

    WeatherParams(String name){this.name = name;}
  }




}
