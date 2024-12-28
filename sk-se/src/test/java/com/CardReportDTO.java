package com;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: sukang
 * @Date: 2020/9/14 13:25
 */
@Setter
@Getter
@ToString
public class CardReportDTO {

    private String applyNo;

    private String cardNumber;

    private String idType;

    private String idCardNo;

    private String productCode;

    private String errorMsg;
}
