package gson;
import com.google.gson.Gson;

public class GeoResponseParser {
    Gson gson = new Gson();
    public GeoResponse parse(String responseStr) {
    	return gson.fromJson(responseStr, GeoResponse.class);
    }
}