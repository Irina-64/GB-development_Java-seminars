// метод, который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSONParserExample {
    public static void main(String[] args) {
        String jsonString = readJsonFromFile("data.json");
        parseJsonAndPrintResults(jsonString);
    }

    public static String readJsonFromFile(String filename) {
        StringBuilder jsonContent = new StringBuilder();
        try (FileReader reader = new FileReader(filename)) {
            int character;
            while ((character = reader.read()) != -1) {
                jsonContent.append((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonContent.toString();
    }

    public static void parseJsonAndPrintResults(String jsonString) {
        JSONParser parser = new JSONParser();
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(jsonString);

            StringBuilder resultBuilder = new StringBuilder();
            for (Object obj : jsonArray) {
                JSONObject studentObject = (JSONObject) obj;
                String surname = (String) studentObject.get("фамилия");
                String grade = (String) studentObject.get("оценка");
                String subject = (String) studentObject.get("предмет");

                resultBuilder.append("Студент ")
                        .append(surname)
                        .append(" получил ")
                        .append(grade)
                        .append(" по предмету ")
                        .append(subject)
                        .append(". ")
                        .append(System.lineSeparator());
            }

            System.out.println(resultBuilder.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

