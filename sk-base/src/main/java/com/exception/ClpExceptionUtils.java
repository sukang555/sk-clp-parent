package com.exception;


import java.util.function.BooleanSupplier;

/**
 * @Author: sukang
 * @Date: 2021/12/13 11:04
 */
public class ClpExceptionUtils {


    public static void trowsException(IExceptionMsgDetail msgDetail,Object... args){
        throw new ClpException(msgDetail, args);
    }

    public static void trowsException(IExceptionMsgDetail msgDetail){
        throw new ClpException(msgDetail, "");
    }

    public static void assertParam(BooleanSupplier booleanSupplier, IExceptionMsgDetail msgDetail) {
        assertParam(booleanSupplier, msgDetail,"");
    }

    public static void assertParam(BooleanSupplier booleanSupplier, IExceptionMsgDetail msgDetail, Object... args) {
        if (booleanSupplier.getAsBoolean()) {
            throw new ClpException(msgDetail, args);
        }
    }

}
