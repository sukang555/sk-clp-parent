package com;

import org.junit.Test;

import javax.script.*;
import java.util.Arrays;
import java.util.List;


/**
 * @author sukang  sukang on 2018/12/26.
 */
public class JsDemoTest {

    private final String js = "function toDo(vehiclePro, carType, frze, f117) {\n" +
            "\n" +
            "    //如果有担保费融资额不用乘1.01\n" +
            "    frze = (f117 != null && Number(f117) > 0) ? frze : Number(frze) * 1.01\n" +
            "\n" +
            "    //二手车：2万≤ LCV（03皮卡、03微卡、02轻卡）总融资额≤15万元;\n" +
            "    if (carType == 1 && (vehiclePro == 03 || vehiclePro == 02)) {\n" +
            "        return (Number(frze) >= 20000 && Number(frze) <= 150000);\n" +
            "    }\n" +
            "    //新车二手车都是2万≤乘用车总融资额≤30万元;\n" +
            "    return (Number(frze) >= 20000 && Number(frze) <= 300000);\n" +
            "}";


    @Test
    public void main1(){

        //1.创建引擎
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        try {

            String script = "function toDo(acllx,fckrze,fsfbl){\n" +
                    "\n" +
                    "    if (fckrze == null || fsfbl == null){\n" +
                    "        return '为空';\n" +
                    "    }\n" +
                    "\n" +
                    "    if (acllx == '1' && Number(fckrze) > 90000){\n" +
                    "        return Number(fsfbl) >= 30;\n" +
                    "    }\n" +
                    "    return '';\n" +
                    "}";

            /*SimpleBindings bindings = new SimpleBindings();
            bindings.put("acllx","1");
            bindings.put("fckrze","100000");
            bindings.put("fsfbl","30");
            Object eval = engine.eval(script,bindings);*/

            engine.eval(script);
            Invocable invocable = (Invocable) engine;


            List<Object> params = Arrays.asList("1","100000",null);

            Object result = (Object) invocable.invokeFunction("toDo", params);

            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
