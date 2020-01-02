package ecps.model;

import java.math.BigDecimal;
import java.util.Date;

public class EbConsoleLog {
    private BigDecimal consoleLogId;

    private String entityName;

    private BigDecimal eneieyId;

    private BigDecimal userId;

    private String opType;

    private Date opTime;

    private String nottes;

    private String tableName;

    public BigDecimal getConsoleLogId() {
        return consoleLogId;
    }

    public void setConsoleLogId(BigDecimal consoleLogId) {
        this.consoleLogId = consoleLogId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public BigDecimal getEneieyId() {
        return eneieyId;
    }

    public void setEneieyId(BigDecimal eneieyId) {
        this.eneieyId = eneieyId;
    }

    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public String getNottes() {
        return nottes;
    }

    public void setNottes(String nottes) {
        this.nottes = nottes;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}