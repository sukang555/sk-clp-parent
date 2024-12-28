package com.skse.se.javagrammar.java8;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**用户额度信息--包含授信信息和用信信息
 * @author sumingyue
 * @version 3.0
 * @date 2020/4/17
 */
@Setter
@Getter
@ToString
public class CustomerLimitInfoDTO {



    private String limitTypeCode;

    private String accountProductCode;

    public CustomerLimitInfoDTO() {
    }

    public CustomerLimitInfoDTO(String limitTypeCode, String accountProductCode) {
        this.limitTypeCode = limitTypeCode;
        this.accountProductCode = accountProductCode;
    }
}
