package com.skse.utils;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 *  
 * 表:account_balance_info 
 * @author liurui 
 * @date 2022-06-07 
 */
public class AccountBalanceInfo {

    /**
     * 交易账户信息ID
     * 表字段:TRANSACTION_BALANCE_ID
     */
    private String transactionBalanceId;
    /**
     * 分键
     * 表字段:PARTITION_KEY
     */
    private Integer partitionKey;
    /**
     * 账户管理信息ID
     * 表字段:ACCOUNT_MANAGEMENT_ID
     */
    private String accountManagementId;

    /**
     * 交易类型
     * 表字段:TRANSACTION_TYPE_CODE
     */
    private String transactionTypeCode;

    /**
     * 机构号
     * 表字段:ORGANIZATION_NUMBER
     */
    private String organizationNumber;

    /**
     * 币种
     * 表字段:CURRENCY
     */
    private String currency;

    /**
     * 创建方式
     * 表字段:CREATE_METHOD
     */
    private String createMethod;

    /**
     * 创建日期
     * 表字段:CREATE_DATE
     */
    private Date createDate;

    /**
     * 交易发生金额
     * 表字段:AMOUNT
     */
    private BigDecimal amount;

    /**
     * 余额
     * 表字段:BALANCE
     */
    private BigDecimal balance;

    /**
     * 累积利息
     * 表字段:ACCRUE_INTEREST
     */
    private BigDecimal accrueInterest;

    /**
     * 累积基数
     * 表字段:AGGREGATE_AMOUNT
     */
    private BigDecimal aggregateAmount;

    /**
     * 利息累积日期
     * 表字段:INTEREST_ACCRUE_DATE
     */
    private Date interestAccrueDate;

    /**
     * 上一利息累积日期
     * 表字段:LAST_INTEREST_ACCRUE_DATE
     */
    private Date lastInterestAccrueDate;

    /**
     * 起息日
     * 表字段:INTEREST_START_DATE
     */
    private Date interestStartDate;

    /**
     * 上一结息日
     * 表字段:LAST_INTEREST_BILL_DATE
     */
    private Date lastInterestBillDate;

    /**
     * 表内/表外标志
     * 表字段:INTEREST_INDICATOR
     */
    private String interestIndicator;

    /**
     * 父级交易余额ID
     * 表字段:PARENT_TRANSACTION_BALANCE_ID
     */
    private String parentTransactionBalanceId;

    /**
     * 额度节点
     * 表字段:CREDIT_LIMIT_NODE_ID
     */
    private String creditLimitNodeId;

    /**
     * 分期订单号
     * 表字段:INSTALLMENT_ORDER_NUMBER
     */
    private String installmentOrderNumber;

    /**
     * 交易余额状态
     * 表字段:STATUS
     */
    private String status;

    /**
     * 创建日期
     * 表字段:CREATE_TIME
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     * 表字段:UPDATE_TIME
     */
    private LocalDateTime updateTime;

    /**
     * 更新用户
     * 表字段:UPDATE_BY
     */
    private String updateBy;

    /**
     * 版本号
     * 表字段:VERSION_NUMBER
     */
    private Long versionNumber;

    /**
     * 交易费用参数表ID
     * 表字段:TRANSACTION_FEE_TABLE_ID
     */
    private String transactionFeeTableId;

    /**
     * 最低还款比例参数表ID
     * 表字段:TRANSACTION_MINIMUM_PAYMENT_ID
     */
    private String transactionMinimumPaymentId;

    /**
     * 客户号
     * 表字段:CUSTOMER_ID
     */
    private String customerId;

    /**
     * 上个账单日入账利息
     * 表字段:LAST_CYCLE_BILL_INTEREST
     */
    private BigDecimal lastCycleBillInterest;

    /**
     * 资产出表状态
     * 表字段:ABS_STATUS
     */
    private String absStatus;

    /**
     * 资产包编号
     * 表字段:ABS_PRODUCT_CODE
     */
    private String absProductCode;

    /**
     * 交易手续费
     * 表字段:TRANSACTION_FEE_AMOUNT
     */
    private BigDecimal transactionFeeAmount;

    /**
     * 已出账单标志:0-未出账单、1-已出账单
     * 表字段:STATEMENT_INDICATOR
     */
    private String statementIndicator;

    /**
     * 超长免息期标志:0-非超长免息期、1-超长免息期
     * 表字段:LARGE_GRACE_INDICATOR
     */
    private String largeGraceIndicator;

    /**
     * 实际出账单日
     * 表字段:ACTUAL_STATEMENT_DATE
     */
    private Date actualStatementDate;

    /**
     * 实际免息结息日
     * 表字段:ACTUAL_INTEREST_BILLING_DATE
     */
    private Date actualInterestBillingDate;

    /**
     * 原始交易账户id
     * 表字段:ORIGINAL_TXN_BALANCE_ID
     */
    private String originalTxnBalanceId;

    /**
     * 管控单元编号
     * 表字段:LIMIT_UNIT_CODE
     */
    private String limitUnitCode;

    /**
     * 管控单元版本
     * 表字段:LIMIT_UNIT_VERSION
     */
    private String limitUnitVersion;

    /**
     * 卡产品编号
     * 表字段:CARD_PRODUCT_NUMBER
     */
    private String cardProductNumber;

    /**
     * 资产渠道ID
     * 表字段:CHANNEL_ID
     */
    private String channelId;

    /**
     * 资产子渠道
     * 表字段:SUB_CHANNEL_ID
     */
    private String subChannelId;

    /**
     * 资金源ID
     * 表字段:FUND_ID
     */
    private String fundId;

    /**
     * 商户编号
     * 表字段:MERCHANT_ID
     */
    private String merchantId;

    /**
     * 公司客户号
     * 表字段:CORPORATE_CUSTOMER_ID
     */
    private String corporateCustomerId;

    /**
     * 固定利率标识,0-利率固定、1-利率可变
     * 表字段:INTEREST_RATE_FLAG
     */
    private String interestRateFlag;

    /**
     * 计息参数表ID
     * 表字段:INTEREST_ACCRUAL_TABLE_ID
     */
    private String interestAccrualTableId;

    /**
     * 结息参数表ID
     * 表字段:INTEREST_SETTLE_TABLE_ID
     */
    private String interestSettleTableId;

    /**
     * 余额内转参数表ID
     * 表字段:BALANCE_NETOUT_TABLE_ID
     */
    private String balanceNetoutTableId;

    /**
     * 当前生效利率
     * 表字段:CURRENT_EFFECT_INTEREST_RATE
     */
    private BigDecimal currentEffectInterestRate;

    public String getTransactionBalanceId() {
        return transactionBalanceId;
    }

    public void setTransactionBalanceId(String transactionBalanceId) {
        this.transactionBalanceId = transactionBalanceId;
    }

    public Integer getPartitionKey() {
        return partitionKey;
    }

    public void setPartitionKey(Integer partitionKey) {
        this.partitionKey = partitionKey;
    }
    /**
     * 获取账户管理信息ID
     * @return accountManagementId String
     */
    public String getAccountManagementId() {
        return accountManagementId;
    }

    /**
     * 设置账户管理信息ID
     * @param accountManagementId 账户管理信息ID
     */
    public void setAccountManagementId(String accountManagementId) {
        this.accountManagementId = accountManagementId == null ? null : accountManagementId.trim();
    }

    /**
     * 获取交易类型
     * @return transactionTypeCode String
     */
    public String getTransactionTypeCode() {
        return transactionTypeCode;
    }

    /**
     * 设置交易类型
     * @param transactionTypeCode 交易类型
     */
    public void setTransactionTypeCode(String transactionTypeCode) {
        this.transactionTypeCode = transactionTypeCode == null ? null : transactionTypeCode.trim();
    }

    /**
     * 获取机构号
     * @return organizationNumber String
     */
    public String getOrganizationNumber() {
        return organizationNumber;
    }

    /**
     * 设置机构号
     * @param organizationNumber 机构号
     */
    public void setOrganizationNumber(String organizationNumber) {
        this.organizationNumber = organizationNumber == null ? null : organizationNumber.trim();
    }

    /**
     * 获取币种
     * @return currency String
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 设置币种
     * @param currency 币种
     */
    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    /**
     * 获取创建方式
     * @return createMethod String
     */
    public String getCreateMethod() {
        return createMethod;
    }

    /**
     * 设置创建方式
     * @param createMethod 创建方式
     */
    public void setCreateMethod(String createMethod) {
        this.createMethod = createMethod == null ? null : createMethod.trim();
    }

    /**
     * 获取创建日期
     * @return createDate Date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 获取创建日期
     * @return createDate Date
     */
    public LocalDate getCreateDateLocalDate() {

        if(createDate ==null){
            return LocalDate.now();
        }
        Instant instant = createDate.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();

        return localDate;
    }

    /**
     * 设置创建日期
     * @param createDate 创建日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取交易发生金额
     * @return amount BigDecimal
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置交易发生金额
     * @param amount 交易发生金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取余额
     * @return balance BigDecimal
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 设置余额
     * @param balance 余额
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 获取累积利息
     * @return accrueInterest BigDecimal
     */
    public BigDecimal getAccrueInterest() {
        return accrueInterest;
    }

    /**
     * 设置累积利息
     * @param accrueInterest 累积利息
     */
    public void setAccrueInterest(BigDecimal accrueInterest) {
        this.accrueInterest = accrueInterest;
    }

    /**
     * 获取累积基数
     * @return aggregateAmount BigDecimal
     */
    public BigDecimal getAggregateAmount() {
        return aggregateAmount;
    }

    /**
     * 设置累积基数
     * @param aggregateAmount 累积基数
     */
    public void setAggregateAmount(BigDecimal aggregateAmount) {
        this.aggregateAmount = aggregateAmount;
    }

    /**
     * 获取利息累积日期
     * @return interestAccrueDate Date
     */
    public Date getInterestAccrueDate() {
        return interestAccrueDate;
    }

    /**
     * 设置利息累积日期
     * @param interestAccrueDate 利息累积日期
     */
    public void setInterestAccrueDate(Date interestAccrueDate) {
        this.interestAccrueDate = interestAccrueDate;
    }

    /**
     * 获取上一利息累积日期
     * @return lastInterestAccrueDate Date
     */
    public Date getLastInterestAccrueDate() {
        return lastInterestAccrueDate;
    }

    /**
     * 设置上一利息累积日期
     * @param lastInterestAccrueDate 上一利息累积日期
     */
    public void setLastInterestAccrueDate(Date lastInterestAccrueDate) {
        this.lastInterestAccrueDate = lastInterestAccrueDate;
    }

    /**
     * 获取起息日
     * @return interestStartDate Date
     */
    public Date getInterestStartDate() {
        return interestStartDate;
    }

    /**
     * 设置起息日
     * @param interestStartDate 起息日
     */
    public void setInterestStartDate(Date interestStartDate) {
        this.interestStartDate = interestStartDate;
    }

    /**
     * 获取上一结息日
     * @return lastInterestBillDate Date
     */
    public Date getLastInterestBillDate() {
        return lastInterestBillDate;
    }

    /**
     * 设置上一结息日
     * @param lastInterestBillDate 上一结息日
     */
    public void setLastInterestBillDate(Date lastInterestBillDate) {
        this.lastInterestBillDate = lastInterestBillDate;
    }

    /**
     * 获取表内/表外标志
     * @return interestIndicator String
     */
    public String getInterestIndicator() {
        return interestIndicator;
    }

    /**
     * 设置表内/表外标志
     * @param interestIndicator 表内/表外标志
     */
    public void setInterestIndicator(String interestIndicator) {
        this.interestIndicator = interestIndicator == null ? null : interestIndicator.trim();
    }

    /**
     * 获取父级交易余额ID
     * @return parentTransactionBalanceId String
     */
    public String getParentTransactionBalanceId() {
        return parentTransactionBalanceId;
    }

    /**
     * 设置父级交易余额ID
     * @param parentTransactionBalanceId 父级交易余额ID
     */
    public void setParentTransactionBalanceId(String parentTransactionBalanceId) {
        this.parentTransactionBalanceId = parentTransactionBalanceId == null ? null : parentTransactionBalanceId.trim();
    }

    /**
     * 获取额度节点
     * @return creditLimitNodeId String
     */
    public String getCreditLimitNodeId() {
        return creditLimitNodeId;
    }

    /**
     * 设置额度节点
     * @param creditLimitNodeId 额度节点
     */
    public void setCreditLimitNodeId(String creditLimitNodeId) {
        this.creditLimitNodeId = creditLimitNodeId == null ? null : creditLimitNodeId.trim();
    }

    /**
     * 获取分期订单号
     * @return installmentOrderNumber String
     */
    public String getInstallmentOrderNumber() {
        return installmentOrderNumber;
    }

    /**
     * 设置分期订单号
     * @param installmentOrderNumber 分期订单号
     */
    public void setInstallmentOrderNumber(String installmentOrderNumber) {
        this.installmentOrderNumber = installmentOrderNumber == null ? null : installmentOrderNumber.trim();
    }

    /**
     * 获取交易余额状态
     * @return status String
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置交易余额状态
     * @param status 交易余额状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取创建日期
     * @return createTime LocalDateTime
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建日期
     * @param createTime 创建日期
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     * @return updateTime LocalDateTime
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取更新用户
     * @return updateBy String
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新用户
     * @param updateBy 更新用户
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 获取版本号
     * @return versionNumber Long
     */
    public Long getVersionNumber() {
        return versionNumber;
    }

    /**
     * 设置版本号
     * @param versionNumber 版本号
     */
    public void setVersionNumber(Long versionNumber) {
        this.versionNumber = versionNumber;
    }

    /**
     * 获取交易费用参数表ID
     * @return transactionFeeTableId String
     */
    public String getTransactionFeeTableId() {
        return transactionFeeTableId;
    }

    /**
     * 设置交易费用参数表ID
     * @param transactionFeeTableId 交易费用参数表ID
     */
    public void setTransactionFeeTableId(String transactionFeeTableId) {
        this.transactionFeeTableId = transactionFeeTableId == null ? null : transactionFeeTableId.trim();
    }

    /**
     * 获取最低还款比例参数表ID
     * @return transactionMinimumPaymentId String
     */
    public String getTransactionMinimumPaymentId() {
        return transactionMinimumPaymentId;
    }

    /**
     * 设置最低还款比例参数表ID
     * @param transactionMinimumPaymentId 最低还款比例参数表ID
     */
    public void setTransactionMinimumPaymentId(String transactionMinimumPaymentId) {
        this.transactionMinimumPaymentId = transactionMinimumPaymentId == null ? null : transactionMinimumPaymentId.trim();
    }

    /**
     * 获取客户号
     * @return customerId String
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * 设置客户号
     * @param customerId 客户号
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    /**
     * 获取上个账单日入账利息
     * @return lastCycleBillInterest BigDecimal
     */
    public BigDecimal getLastCycleBillInterest() {
        return lastCycleBillInterest;
    }

    /**
     * 设置上个账单日入账利息
     * @param lastCycleBillInterest 上个账单日入账利息
     */
    public void setLastCycleBillInterest(BigDecimal lastCycleBillInterest) {
        this.lastCycleBillInterest = lastCycleBillInterest;
    }

    /**
     * 获取资产出表状态
     * @return absStatus String
     */
    public String getAbsStatus() {
        return absStatus;
    }

    /**
     * 设置资产出表状态
     * @param absStatus 资产出表状态
     */
    public void setAbsStatus(String absStatus) {
        this.absStatus = absStatus == null ? null : absStatus.trim();
    }

    /**
     * 获取资产包编号
     * @return absProductCode String
     */
    public String getAbsProductCode() {
        return absProductCode;
    }

    /**
     * 设置资产包编号
     * @param absProductCode 资产包编号
     */
    public void setAbsProductCode(String absProductCode) {
        this.absProductCode = absProductCode == null ? null : absProductCode.trim();
    }

    /**
     * 获取交易手续费
     * @return transactionFeeAmount BigDecimal
     */
    public BigDecimal getTransactionFeeAmount() {
        return transactionFeeAmount;
    }

    /**
     * 设置交易手续费
     * @param transactionFeeAmount 交易手续费
     */
    public void setTransactionFeeAmount(BigDecimal transactionFeeAmount) {
        this.transactionFeeAmount = transactionFeeAmount;
    }

    /**
     * 获取已出账单标志:0-未出账单、1-已出账单
     * @return statementIndicator String
     */
    public String getStatementIndicator() {
        return statementIndicator;
    }

    /**
     * 设置已出账单标志:0-未出账单、1-已出账单
     * @param statementIndicator 已出账单标志:0-未出账单、1-已出账单
     */
    public void setStatementIndicator(String statementIndicator) {
        this.statementIndicator = statementIndicator == null ? null : statementIndicator.trim();
    }

    /**
     * 获取超长免息期标志:0-非超长免息期、1-超长免息期
     * @return largeGraceIndicator String
     */
    public String getLargeGraceIndicator() {
        return largeGraceIndicator;
    }

    /**
     * 设置超长免息期标志:0-非超长免息期、1-超长免息期
     * @param largeGraceIndicator 超长免息期标志:0-非超长免息期、1-超长免息期
     */
    public void setLargeGraceIndicator(String largeGraceIndicator) {
        this.largeGraceIndicator = largeGraceIndicator == null ? null : largeGraceIndicator.trim();
    }

    /**
     * 获取实际出账单日
     * @return actualStatementDate Date
     */
    public Date getActualStatementDate() {
        return actualStatementDate;
    }

    /**
     * 设置实际出账单日
     * @param actualStatementDate 实际出账单日
     */
    public void setActualStatementDate(Date actualStatementDate) {
        this.actualStatementDate = actualStatementDate;
    }

    /**
     * 获取实际免息结息日
     * @return actualInterestBillingDate Date
     */
    public Date getActualInterestBillingDate() {
        return actualInterestBillingDate;
    }

    /**
     * 设置实际免息结息日
     * @param actualInterestBillingDate 实际免息结息日
     */
    public void setActualInterestBillingDate(Date actualInterestBillingDate) {
        this.actualInterestBillingDate = actualInterestBillingDate;
    }

    /**
     * 获取原始交易账户id
     * @return originalTxnBalanceId String
     */
    public String getOriginalTxnBalanceId() {
        return originalTxnBalanceId;
    }

    /**
     * 设置原始交易账户id
     * @param originalTxnBalanceId 原始交易账户id
     */
    public void setOriginalTxnBalanceId(String originalTxnBalanceId) {
        this.originalTxnBalanceId = originalTxnBalanceId == null ? null : originalTxnBalanceId.trim();
    }

    /**
     * 获取管控单元编号
     * @return limitUnitCode String
     */
    public String getLimitUnitCode() {
        return limitUnitCode;
    }

    /**
     * 设置管控单元编号
     * @param limitUnitCode 管控单元编号
     */
    public void setLimitUnitCode(String limitUnitCode) {
        this.limitUnitCode = limitUnitCode == null ? null : limitUnitCode.trim();
    }

    /**
     * 获取管控单元版本
     * @return limitUnitVersion String
     */
    public String getLimitUnitVersion() {
        return limitUnitVersion;
    }

    /**
     * 设置管控单元版本
     * @param limitUnitVersion 管控单元版本
     */
    public void setLimitUnitVersion(String limitUnitVersion) {
        this.limitUnitVersion = limitUnitVersion == null ? null : limitUnitVersion.trim();
    }

    /**
     * 获取卡产品编号
     * @return cardProductNumber String
     */
    public String getCardProductNumber() {
        return cardProductNumber;
    }

    /**
     * 设置卡产品编号
     * @param cardProductNumber 卡产品编号
     */
    public void setCardProductNumber(String cardProductNumber) {
        this.cardProductNumber = cardProductNumber == null ? null : cardProductNumber.trim();
    }

    /**
     * 获取资产渠道ID
     * @return channelId String
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 设置资产渠道ID
     * @param channelId 资产渠道ID
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    /**
     * 获取资产子渠道
     * @return subChannelId String
     */
    public String getSubChannelId() {
        return subChannelId;
    }

    /**
     * 设置资产子渠道
     * @param subChannelId 资产子渠道
     */
    public void setSubChannelId(String subChannelId) {
        this.subChannelId = subChannelId == null ? null : subChannelId.trim();
    }

    /**
     * 获取资金源ID
     * @return fundId String
     */
    public String getFundId() {
        return fundId;
    }

    /**
     * 设置资金源ID
     * @param fundId 资金源ID
     */
    public void setFundId(String fundId) {
        this.fundId = fundId == null ? null : fundId.trim();
    }

    /**
     * 获取商户编号
     * @return merchantId String
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * 设置商户编号
     * @param merchantId 商户编号
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    /**
     * 获取公司客户号
     * @return corporateCustomerId String
     */
    public String getCorporateCustomerId() {
        return corporateCustomerId;
    }

    /**
     * 设置公司客户号
     * @param corporateCustomerId 公司客户号
     */
    public void setCorporateCustomerId(String corporateCustomerId) {
        this.corporateCustomerId = corporateCustomerId == null ? null : corporateCustomerId.trim();
    }

    /**
     * 获取固定利率标识,0-利率固定、1-利率可变
     * @return interestRateFlag String
     */
    public String getInterestRateFlag() {
        return interestRateFlag;
    }

    /**
     * 设置固定利率标识,0-利率固定、1-利率可变
     * @param interestRateFlag 固定利率标识,0-利率固定、1-利率可变
     */
    public void setInterestRateFlag(String interestRateFlag) {
        this.interestRateFlag = interestRateFlag == null ? null : interestRateFlag.trim();
    }

    /**
     * 获取计息参数表ID
     * @return interestAccrualTableId String
     */
    public String getInterestAccrualTableId() {
        return interestAccrualTableId;
    }

    /**
     * 设置计息参数表ID
     * @param interestAccrualTableId 计息参数表ID
     */
    public void setInterestAccrualTableId(String interestAccrualTableId) {
        this.interestAccrualTableId = interestAccrualTableId == null ? null : interestAccrualTableId.trim();
    }

    /**
     * 获取结息参数表ID
     * @return interestSettleTableId String
     */
    public String getInterestSettleTableId() {
        return interestSettleTableId;
    }

    /**
     * 设置结息参数表ID
     * @param interestSettleTableId 结息参数表ID
     */
    public void setInterestSettleTableId(String interestSettleTableId) {
        this.interestSettleTableId = interestSettleTableId == null ? null : interestSettleTableId.trim();
    }

    /**
     * 获取余额内转参数表ID
     * @return balanceNetoutTableId String
     */
    public String getBalanceNetoutTableId() {
        return balanceNetoutTableId;
    }

    /**
     * 设置余额内转参数表ID
     * @param balanceNetoutTableId 余额内转参数表ID
     */
    public void setBalanceNetoutTableId(String balanceNetoutTableId) {
        this.balanceNetoutTableId = balanceNetoutTableId == null ? null : balanceNetoutTableId.trim();
    }

    /**
     * 获取当前生效利率
     * @return currentEffectInterestRate BigDecimal
     */
    public BigDecimal getCurrentEffectInterestRate() {
        return currentEffectInterestRate;
    }

    /**
     * 设置当前生效利率
     * @param currentEffectInterestRate 当前生效利率
     */
    public void setCurrentEffectInterestRate(BigDecimal currentEffectInterestRate) {
        this.currentEffectInterestRate = currentEffectInterestRate;
    }
}