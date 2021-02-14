package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.annotations.DataProvider;

public class ProviderData {

  @DataProvider(name = "validEmailDataJson")
  public static Iterator<Object[]> validCandidatesFromJson() throws IOException {
    try (BufferedReader reader =
        new BufferedReader(
            new FileReader(new File("src/test/resources/testdata/email_creation.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<Email> email = gson.fromJson(json, new TypeToken<List<Email>>() {
      }.getType());
      return email.stream()
          .map((e) -> new Object[]{e})
          .collect(Collectors.toList())
          .iterator();
    }
  }


}
