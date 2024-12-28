package com.exception;

import com.exception.function.ThrowExceptionFunction;
import com.exception.function.ThrowStringExceptionFunction;

/**
 * @Author: sukang
 * @Date: 2021/12/13 11:04
 */
public class ClpExceptionUtils {


    public static ThrowExceptionFunction throwException(){
        return (errorMessage, args) -> {
            throw new ClpException(errorMessage,args);
        };
    }


    public static ThrowStringExceptionFunction throwStringException(){
        return (errorMessage, args) -> {
            throw new ClpException(errorMessage,args);
        };
    }

}
