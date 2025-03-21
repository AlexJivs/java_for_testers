package generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import tests.TestBase;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static common.CommonFunctions.randomStr;

public class Generator {

    @Parameter (names={"--type", "-t"})
    String type;

    @Parameter (names={"--output", "-o"})
    String output;

    @Parameter (names={"--format", "-f"})
    String format;

    @Parameter (names={"--count", "-n"})
    int count;

    public static void main(String[] args) throws IOException  {
        var generator = new Generator();
        JCommander.newBuilder()
                        .addObject(generator)
                                .build()
                                        .parse(args);
        generator.run();

    }

    private void run() throws IOException {
        var data = generate();
        save(data);
    }



    private Object generate() {
        if ("groups".equals(type)) {
            return  generateGroups();
        } else if ("contacts".equals(type)) {
            return  generateContacts();
        } else  {
            throw new IllegalArgumentException("неизвестный тип данных" + type);
        }

    }

    private Object generateGroups() {
        var result = new ArrayList<GroupData>();
        for (int i = 0; i < count; i++) {
            result.add(new GroupData()
                    .withName(CommonFunctions.randomStr(i * 10))
                    .withHeader(CommonFunctions.randomStr(i * 10))
                    .withFooter(CommonFunctions.randomStr(i * 10)));
        }
        return result;

    }

    private Object generateContacts() {
        var result = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            result.add(new ContactData()
                    //.withIdCntct(CommonFunctions.randomStr(i * 5))
                    .withFirstname(CommonFunctions.randomStr(i * 5))
                    .withLastname(CommonFunctions.randomStr(i * 5))
                    .withAddress(CommonFunctions.randomStr(i * 5)));
                   // .withHome(CommonFunctions.randomStr(i * 5))
                   // .withEmail(CommonFunctions.randomStr(i * 5))
                  //  .withPhoto(CommonFunctions.randomFile("src/test/resources/images"))); //"src/test/resources/images/avatar.png"));
        }
        return result;
    }

    private void save(Object data) throws IOException {
        if ("json".equals(format)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
          var json = mapper.writeValueAsString(data);

          try (var writer= new FileWriter(output)) {
              writer.write(json);
          }
        } else {
            throw  new IllegalArgumentException("неизвестный формат данных" + format);
        }


    }
}
