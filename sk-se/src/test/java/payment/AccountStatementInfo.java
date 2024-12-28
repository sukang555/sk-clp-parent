package payment;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * null 
 * 表:ACCOUNT_STATEMENT_INFO 
 * @author dengguoqing 
 * @date 2018-11-13 
 */
public class AccountStatementInfo {


    public AccountStatementInfo(LocalDate statementDate, Short cycleDue) {
        this.statementDate = statementDate;
        this.cycleDue = cycleDue;
    }

    /**
     * 账户账单信息ID
     * 表字段:STATEMENT_ID
     */
    private String statementId;


    /**
     * 公司客户号
     * 表字段:CORPORATE_CUSTOMER_ID
     */
    private String corporateCustomerId;

    /**
     * 账户管理信息ID
     * 表字段:ACCOUNT_MANAGEMENT_ID
     */
    private String accountManagementId;

    /**
     * 客户ID
     * 表字段:CUSTOMER_ID
     */
    private String customerId;


    /**
     * 产品代码
     * 表字段:PRODUCT_NUMBER
     */
    private String productNumber;

    /**
     * 币种
     * 表字段:CURRENCY
     */
    private String currency;

    /**
     * 上一账单信息ID
     * 表字段:LAST_STATEMENT_ID
     */
    private String lastStatementId;

    /**
     * 账单日
     * 表字段:STATEMENT_DATE
     */
    private LocalDate statementDate;

    /**
     * 还款日
     * 表字段:PAYMENT_DUE_DATE
     */
    private LocalDate paymentDueDate;

    /**
     * 违约金收取日
     * 表字段:LATE_CHARGE_DATE
     */
    private LocalDate lateChargeDate;

    /**
     * 利息宽限日
     * 表字段:INTEREST_WAIVE_GRACE_DATE
     */
    private LocalDate interestWaiveGraceDate;

    /**
     * 应还款金额
     * 表字段:TOTAL_DUE_AMOUNT
     */
    private BigDecimal totalDueAmount;

    /**
     * 当期应还款金额
     * 表字段:CURRENT_DUE_AMOUNT
     */
    private BigDecimal currentDueAmount;

    /**
     * 延滞总金额
     * 表字段:TOTAL_OVER_DUE_AMOUNT
     */
    private BigDecimal totalOverDueAmount;

    /**
     * 超限记账金额
     * 表字段:OVERLIMIT_BILLED_AMOUNT
     */
    private BigDecimal overlimitBilledAmount;

    /**
     * 本期还款金额
     * 表字段:PAYMENT_AMOUNT
     */
    private BigDecimal paymentAmount;

    /**
     * 封锁码
     * 表字段:BLOCK_CODE
     */
    private String blockCode;

    /**
     * 期初余额
     * 表字段:BEGIN_BALANCE
     */
    private BigDecimal beginBalance;

    /**
     * 期末余额
     * 表字段:CLOSE_BALANCE
     */
    private BigDecimal closeBalance;

    /**
     * 本期借记交易金额
     * 表字段:DEBIT_AMOUNT
     */
    private BigDecimal debitAmount;

    /**
     * 本期借记交易笔数
     * 表字段:DEBIT_COUNT
     */
    private Long debitCount;

    /**
     * 本期贷记记交易金额
     * 表字段:CREDIT_AMOUNT
     */
    private BigDecimal creditAmount;

    /**
     * 本期贷记交易笔数
     * 表字段:CREDIT_COUNT
     */
    private Long creditCount;

    /**
     * 本期争议交易金额
     * 表字段:DISPUTE_AMOUNT
     */
    private BigDecimal disputeAmount;

    /**
     * 本期争议交易笔数
     * 表字段:DISPUTE_COUNT
     */
    private Long disputeCount;


    /**
     * 本周期利息汇总
     * 表字段:CURRENT_CYCLE_INTEREST_AMOUNT
     */
    private BigDecimal currentCycleInterestAmount;

    /**
     * 分区键值
     * 表字段:PARTITION_KEY
     */
    private Integer partitionKey;

    /**
     * 创建日期
     * 表字段:CREATE_TIME
     */
    private LocalDateTime createTime;

    /**
     * 更新日期
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

    private BigDecimal openBonusPoints;

    private BigDecimal closeBonusPoints;

    private BigDecimal rewardsPointsEarned;

    public Short getCycleDue() {
        return cycleDue;
    }

    public void setCycleDue(Short cycleDue) {
        this.cycleDue = cycleDue;
    }

    private BigDecimal rewardsPointsRedeemed;
    /**
     * 延滞状态
     * 表字段:CYCLE_DUE
     */
    private Short cycleDue;

    /**
     * 获取账户账单利息汇总
     * @return currentCycleInterestAmount BigDecimal
     */
    public BigDecimal getCurrentCycleInterestAmount() {
        return currentCycleInterestAmount;
    }
    /**
     * 设置账户账单利息汇总
     * @param currentCycleInterestAmount 账户账单利息汇总
     */
    public void setCurrentCycleInterestAmount(BigDecimal currentCycleInterestAmount) {
        this.currentCycleInterestAmount = currentCycleInterestAmount;
    }

    /**
     * 获取账户账单信息ID
     * @return statementId String
     */
    public String getStatementId() {
        return statementId;
    }

    /**
     * 设置账户账单信息ID
     * @param statementId 账户账单信息ID
     */
    public void setStatementId(String statementId) {
        this.statementId = statementId == null ? null : statementId.trim();
    }

    public String getCorporateCustomerId() {
        return corporateCustomerId;
    }

    public void setCorporateCustomerId(String corporateCustomerId) {
        this.corporateCustomerId = corporateCustomerId;
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
     * 获取客户ID
     * @return customerId String
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * 设置客户ID
     * @param customerId 客户ID
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }


    /**
     * 获取产品代码
     * @return productNumber String
     */
    public String getProductNumber() {
        return productNumber;
    }

    /**
     * 设置产品代码
     * @param productNumber 产品代码
     */
    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber == null ? null : productNumber.trim();
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
     * 获取上一账单信息ID
     * @return lastStatementId String
     */
    public String getLastStatementId() {
        return lastStatementId;
    }

    /**
     * 设置上一账单信息ID
     * @param lastStatementId 上一账单信息ID
     */
    public void setLastStatementId(String lastStatementId) {
        this.lastStatementId = lastStatementId == null ? null : lastStatementId.trim();
    }

    /**
     * 获取账单日
     * @return statementDate LocalDate
     */
    public LocalDate getStatementDate() {
        return statementDate;
    }

    /**
     * 设置账单日
     * @param statementDate 账单日
     */
    public void setStatementDate(LocalDate statementDate) {
        this.statementDate = statementDate;
    }

    /**
     * 获取还款日
     * @return paymentDueDate LocalDate
     */
    public LocalDate getPaymentDueDate() {
        return paymentDueDate;
    }

    /**
     * 设置还款日
     * @param paymentDueDate 还款日
     */
    public void setPaymentDueDate(LocalDate paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    /**
     * 获取违约金收取日
     * @return lateChargeDate LocalDate
     */
    public LocalDate getLateChargeDate() {
        return lateChargeDate;
    }

    /**
     * 设置违约金收取日
     * @param lateChargeDate 违约金收取日
     */
    public void setLateChargeDate(LocalDate lateChargeDate) {
        this.lateChargeDate = lateChargeDate;
    }

    /**
     * 获取利息宽限日
     * @return interestWaiveGraceDate LocalDate
     */
    public LocalDate getInterestWaiveGraceDate() {
        return interestWaiveGraceDate;
    }

    /**
     * 设置利息宽限日
     * @param interestWaiveGraceDate 利息宽限日
     */
    public void setInterestWaiveGraceDate(LocalDate interestWaiveGraceDate) {
        this.interestWaiveGraceDate = interestWaiveGraceDate;
    }

    /**
     * 获取应还款金额
     * @return totalDueAmount BigDecimal
     */
    public BigDecimal getTotalDueAmount() {
        return totalDueAmount;
    }

    /**
     * 设置应还款金额
     * @param totalDueAmount 应还款金额
     */
    public void setTotalDueAmount(BigDecimal totalDueAmount) {
        this.totalDueAmount = totalDueAmount;
    }

    /**
     * 获取当期应还款金额
     * @return currentDueAmount BigDecimal
     */
    public BigDecimal getCurrentDueAmount() {
        return currentDueAmount;
    }

    /**
     * 设置当期应还款金额
     * @param currentDueAmount 当期应还款金额
     */
    public void setCurrentDueAmount(BigDecimal currentDueAmount) {
        this.currentDueAmount = currentDueAmount;
    }

    /**
     * 获取延滞总金额
     * @return totalOverDueAmount BigDecimal
     */
    public BigDecimal getTotalOverDueAmount() {
        return totalOverDueAmount;
    }

    /**
     * 设置延滞总金额
     * @param totalOverDueAmount 延滞总金额
     */
    public void setTotalOverDueAmount(BigDecimal totalOverDueAmount) {
        this.totalOverDueAmount = totalOverDueAmount;
    }

    /**
     * 获取超限记账金额
     * @return overlimitBilledAmount BigDecimal
     */
    public BigDecimal getOverlimitBilledAmount() {
        return overlimitBilledAmount;
    }

    /**
     * 设置超限记账金额
     * @param overlimitBilledAmount 超限记账金额
     */
    public void setOverlimitBilledAmount(BigDecimal overlimitBilledAmount) {
        this.overlimitBilledAmount = overlimitBilledAmount;
    }

    /**
     * 获取本期还款金额
     * @return paymentAmount BigDecimal
     */
    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * 设置本期还款金额
     * @param paymentAmount 本期还款金额
     */
    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    /**
     * 获取封锁码
     * @return blockCode String
     */
    public String getBlockCode() {
        return blockCode;
    }

    /**
     * 设置封锁码
     * @param blockCode 封锁码
     */
    public void setBlockCode(String blockCode) {
        this.blockCode = blockCode == null ? null : blockCode.trim();
    }

    /**
     * 获取期初余额
     * @return beginBalance BigDecimal
     */
    public BigDecimal getBeginBalance() {
        return beginBalance;
    }

    /**
     * 设置期初余额
     * @param beginBalance 期初余额
     */
    public void setBeginBalance(BigDecimal beginBalance) {
        this.beginBalance = beginBalance;
    }

    /**
     * 获取期末余额
     * @return closeBalance BigDecimal
     */
    public BigDecimal getCloseBalance() {
        return closeBalance;
    }

    /**
     * 设置期末余额
     * @param closeBalance 期末余额
     */
    public void setCloseBalance(BigDecimal closeBalance) {
        this.closeBalance = closeBalance;
    }

    /**
     * 获取本期借记交易金额
     * @return debitAmount BigDecimal
     */
    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    /**
     * 设置本期借记交易金额
     * @param debitAmount 本期借记交易金额
     */
    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    /**
     * 获取本期借记交易笔数
     * @return debitCount Long
     */
    public Long getDebitCount() {
        return debitCount;
    }

    /**
     * 设置本期借记交易笔数
     * @param debitCount 本期借记交易笔数
     */
    public void setDebitCount(Long debitCount) {
        this.debitCount = debitCount;
    }

    /**
     * 获取本期贷记记交易金额
     * @return creditAmount BigDecimal
     */
    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    /**
     * 设置本期贷记记交易金额
     * @param creditAmount 本期贷记记交易金额
     */
    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    /**
     * 获取本期贷记交易笔数
     * @return creditCount Long
     */
    public Long getCreditCount() {
        return creditCount;
    }

    /**
     * 设置本期贷记交易笔数
     * @param creditCount 本期贷记交易笔数
     */
    public void setCreditCount(Long creditCount) {
        this.creditCount = creditCount;
    }

    /**
     * 获取本期争议交易金额
     * @return disputeAmount BigDecimal
     */
    public BigDecimal getDisputeAmount() {
        return disputeAmount;
    }

    /**
     * 设置本期争议交易金额
     * @param disputeAmount 本期争议交易金额
     */
    public void setDisputeAmount(BigDecimal disputeAmount) {
        this.disputeAmount = disputeAmount;
    }

    /**
     * 获取本期争议交易笔数
     * @return disputeCount Long
     */
    public Long getDisputeCount() {
        return disputeCount;
    }

    /**
     * 设置本期争议交易笔数
     * @param disputeCount 本期争议交易笔数
     */
    public void setDisputeCount(Long disputeCount) {
        this.disputeCount = disputeCount;
    }

    /**
     * 获取分区键值
     * @return partitionKey String
     */
    public Integer getPartitionKey() {
        return partitionKey;
    }

    /**
     * 设置分区键值
     * @param partitionKey 分区键值
     */
    public void setPartitionKey(Integer partitionKey) {
        this.partitionKey = partitionKey;
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
     * 获取更新日期
     * @return updateTime LocalDateTime
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新日期
     * @param updateTime 更新日期
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

    public BigDecimal getOpenBonusPoints() {
        return openBonusPoints;
    }

    public void setOpenBonusPoints(BigDecimal openBonusPoints) {
        this.openBonusPoints = openBonusPoints;
    }

    public BigDecimal getCloseBonusPoints() {
        return closeBonusPoints;
    }

    public void setCloseBonusPoints(BigDecimal closeBonusPoints) {
        this.closeBonusPoints = closeBonusPoints;
    }

    public BigDecimal getRewardsPointsEarned() {
        return rewardsPointsEarned;
    }

    public void setRewardsPointsEarned(BigDecimal rewardsPointsEarned) {
        this.rewardsPointsEarned = rewardsPointsEarned;
    }

    public BigDecimal getRewardsPointsRedeemed() {
        return rewardsPointsRedeemed;
    }

    public void setRewardsPointsRedeemed(BigDecimal rewardsPointsRedeemed) {
        this.rewardsPointsRedeemed = rewardsPointsRedeemed;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountStatementInfo{");
        sb.append("statementId='").append(statementId).append('\'');
        sb.append(", accountManagementId='").append(accountManagementId).append('\'');
        sb.append(", customerId='").append(customerId).append('\'');
        sb.append(", productNumber='").append(productNumber).append('\'');
        sb.append(", currency='").append(currency).append('\'');
        sb.append(", lastStatementId='").append(lastStatementId).append('\'');
        sb.append(", statementDate=").append(statementDate);
        sb.append(", paymentDueDate=").append(paymentDueDate);
        sb.append(", lateChargeDate=").append(lateChargeDate);
        sb.append(", interestWaiveGraceDate=").append(interestWaiveGraceDate);
        sb.append(", totalDueAmount=").append(totalDueAmount);
        sb.append(", currentDueAmount=").append(currentDueAmount);
        sb.append(", totalOverDueAmount=").append(totalOverDueAmount);
        sb.append(", overlimitBilledAmount=").append(overlimitBilledAmount);
        sb.append(", paymentAmount=").append(paymentAmount);
        sb.append(", blockCode='").append(blockCode).append('\'');
        sb.append(", beginBalance=").append(beginBalance);
        sb.append(", closeBalance=").append(closeBalance);
        sb.append(", debitAmount=").append(debitAmount);
        sb.append(", debitCount=").append(debitCount);
        sb.append(", creditAmount=").append(creditAmount);
        sb.append(", creditCount=").append(creditCount);
        sb.append(", disputeAmount=").append(disputeAmount);
        sb.append(", disputeCount=").append(disputeCount);
        sb.append(", currentCycleInterestAmount=").append(currentCycleInterestAmount);
        sb.append(", partitionKey='").append(partitionKey).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy='").append(updateBy).append('\'');
        sb.append(", versionNumber=").append(versionNumber);
        sb.append('}');
        return sb.toString();
    }
}