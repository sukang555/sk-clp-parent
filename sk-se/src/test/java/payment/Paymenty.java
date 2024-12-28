package payment;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: sukang
 * @Date: 2022/12/8 23:53
 */
@Slf4j
public class Paymenty {

    public static void main(String[] args) {
        PaymentHistoryDTO paymentHistoryDTO = new PaymentHistoryDTO();
        String accountManagementId = "00000000000000004443";

        String original = "ZZZZZ Z Z Z Z Z Z Z Z Z Z Z Z 1312111009 1010";

        String payHis = original.trim();
        payHis = payHis.replace("109 ","1009");
        payHis = payHis.replaceAll("Z","0");
        payHis = payHis.replaceAll("B","0");
        StringBuffer sb = new StringBuffer();
        if (accountManagementId.startsWith("00")){

            List<AccountStatementInfo> list = new ArrayList<AccountStatementInfo>(){{
                add(new AccountStatementInfo(LocalDate.of(2022,12,1), (short) 0));
                add(new AccountStatementInfo(LocalDate.of(2022,11,1), (short) 0));
                add(new AccountStatementInfo(LocalDate.of(2022,10,1), (short) 0));
                add(new AccountStatementInfo(LocalDate.of(2022,9,1), (short) 0));
                add(new AccountStatementInfo(LocalDate.of(2022,7,31), (short) 0));
            }};




            list = list.stream()
                    .filter(x->x.getStatementDate()
                            .isAfter(LocalDate.of(2022,8,1)))
            .collect(Collectors.toList());


            for (AccountStatementInfo ste: list){
                if (ste.getCycleDue()<10){
                    String compareStr = payHis.substring(0,1);
                    if (compareStr.equals(ste.getCycleDue().toString())){
                        sb.append("0"+compareStr);
                    }
                    payHis = payHis.substring(1);
                }else {
                    String compareStr = payHis.substring(0,2);
                    if (compareStr.equals(ste.getCycleDue().toString())){
                        sb.append(compareStr);
                    }
                    payHis = payHis.substring(2);
                }

            }
            payHis=payHis.replaceAll(" ","0");

            if (sb.length()+payHis.length()<48){
                sb.append("0"+payHis);
            }else if ((sb.length()+payHis.length()==48)){
                sb.append(payHis);
            }else {
                log.info("acctId:{},sb:{},payHis:{}",accountManagementId,sb,payHis);
                throw new RuntimeException("00wrong");
            }
        }else if (accountManagementId.startsWith("16")) {
            String replaceStr = payHis.substring(0,payHis.indexOf("X"));
            String strX =payHis.substring(payHis.indexOf("X"));
            char[] arr = replaceStr.toCharArray();
            for (Character c:arr){
                sb.append('0'+c);
            }
            if (sb.length()+strX.length()==48){
                sb.append(strX);
            }else {
                log.info("acctId:{},sb:{},payHis:{}",accountManagementId,sb,payHis);
                throw new IllegalArgumentException("16Wrong");
            }
        }
        paymentHistoryDTO.setAccountManagementId(accountManagementId);
        paymentHistoryDTO.setOldPaymentHistory(original);
        paymentHistoryDTO.setNewPaymentHistory(sb.toString());

        System.out.println(paymentHistoryDTO);
    }
}
