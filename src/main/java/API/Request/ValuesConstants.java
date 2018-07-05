package API.Request;

/**
 * Created by cristian on 5/28/18.
 */
public enum ValuesConstants {

  ValuesConstants(){};

  public enum Values {
    APPID("b6907d289e10d714a6e88b30761fae22"),
    CITY_NAME("London,uk"),
    BY_ID("2643743");

    private String name;

    public String getName() {return name;}

    Values(String name){this.name = name;}
  }




}
