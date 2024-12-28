package com;


import org.apache.commons.lang3.StringUtils;
import org.junit.Test;


import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


/**
 * @author sukang on 2019/10/18 16:13
 */

public class DemoTest {

    //报表时间
    private static final String REPORT_TIME = "reportCreateTime";
    //处理日期
    private static final String DEAL_TIME = "dealDate";

    @Test
    public void main4() throws IOException {
        String encode = URLEncoder.encode("https://1234567.restlets.api.netsuite.com/rest/requesttoken", "UTF-8");

        System.out.println(encode);

    }


    @Test
    public void main2(){
        System.out.println(Arrays.toString("RFRC>XD>AN>253>RZ>001>001>36154067060163>22.10>220327>TS>420>Cabcharge Asia Pte Ltd>SINGAPORE>702>081>TI>0007ONW5>328378>366200000294518>SGD>0000000000022.10>>383 Sin Ming Drive>>575717>>>4121>>>0007ONW5>0007ONW5>>>>>>9>0>1>>>192075081973016>1>>>528>S".split(">",5)));
    }


    @Test
    public void main1(){

        Map<String, Object> parameters = new HashMap<>(2);
        parameters.put(REPORT_TIME, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        parameters.put(DEAL_TIME, LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));


        try {

            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public List<CardReportDTO>  getDataList(){
        return new ArrayList<CardReportDTO>(2) {{
            CardReportDTO cardReportDTO = new CardReportDTO();

            cardReportDTO.setApplyNo("322432");
            cardReportDTO.setCardNumber("werewtre");
            cardReportDTO.setIdCardNo("350501199008080741");
            cardReportDTO.setIdType("1");
            cardReportDTO.setProductCode("P001:");
            cardReportDTO.setErrorMsg("3232");
            add(cardReportDTO);

            cardReportDTO.setApplyNo("322432");
            cardReportDTO.setCardNumber("werewtre");
            cardReportDTO.setIdCardNo("350501199008080741");
            cardReportDTO.setIdType("1");
            cardReportDTO.setProductCode("P001:");
            cardReportDTO.setErrorMsg("3232");
            add(cardReportDTO);

            cardReportDTO.setApplyNo("322432");
            cardReportDTO.setCardNumber("werewtre");
            cardReportDTO.setIdCardNo("350501199008080741");
            cardReportDTO.setIdType("1");
            cardReportDTO.setProductCode("P001:");
            cardReportDTO.setErrorMsg("3232");
            add(cardReportDTO);

            cardReportDTO.setApplyNo("322432");
            cardReportDTO.setCardNumber("werewtre");
            cardReportDTO.setIdCardNo("350501199008080741");
            cardReportDTO.setIdType("1");
            cardReportDTO.setProductCode("P001:");
            cardReportDTO.setErrorMsg("3232");
            add(cardReportDTO);

        }};
    }




}

