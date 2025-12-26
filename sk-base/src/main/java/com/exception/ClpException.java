package com.exception;

import org.slf4j.helpers.MessageFormatter;

/**
 * @Author: sukang
 * @Date: 2021/12/2 10:42
 */
public class ClpException extends RuntimeException {


    public ClpException(IExceptionMsgDetail format, Object... args) {
        this(format, args, (args == null || args.length == 0) ? null :
                args[args.length - 1] instanceof Throwable ? (Throwable) args[args.length - 1] : null);
    }


    private ClpException(IExceptionMsgDetail format, Object[] args, Throwable throwable) {
        super((args != null && args.length > 0) ?
                MessageFormatter.arrayFormat(format.getDetailMessage(), args).getMessage() :
                format.getDetailMessage(), throwable);
    }

}
