package lab04.Utils;


import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonParser {
    private static final JsonParser ourInstance = new JsonParser();

    public static JsonParser getInstance() {
        return ourInstance;
    }

    private JsonParser() {
    }

    public static Object parseResponse(InputStream inputStream) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        return  jsonParser.parse(new InputStreamReader(inputStream,"UTF-8"));
    }
}
