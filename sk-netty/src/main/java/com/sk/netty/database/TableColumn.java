package com.sk.netty.database;

import java.time.LocalDateTime;

/**
 * @Author: sukang
 * @Date: 2023-9-20 11:00
 * @Description:
 */
public class TableColumn implements DatabaseTables{


    private LocalDateTime createDateTime;

    private LocalDateTime updateDateTime;


    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
