package worktest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.skse.utils.JacksonUtil;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: sukang
 * @Date: 2021/4/27 11:40
 */
public class JacksonUtils {

    @Test
    public void main4(){
        System.out.println(DateTimeFormatter.ofPattern("HHmmss")
                .format(LocalDateTime.now()));
    }




    @Test
    public void  main3(){

        String json = "{\"tableId\":\"T0041\"}";

        JsonNode jsonNode = JacksonUtil.fromStrToObj(json, JsonNode.class);

        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();

        objectNode.put("key","11");

        System.out.println(objectNode.get("key").asText());




        /*Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();

        while (fields.hasNext()){
            Map.Entry<String, JsonNode> next = fields.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }*/


    }











    @Test
    public void main2() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readValue("[1]", JsonNode.class);
        System.out.println(jsonNode.toString());

    }






    @Test
    public void main1() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readTree("[1,2,3]");

        JsonNode jsonNode2 = objectMapper.readTree("[1,2,4]");

        System.out.println(jsonNode.equals(jsonNode2));
    }

}
