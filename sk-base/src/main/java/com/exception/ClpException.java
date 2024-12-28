package com.exception;

import com.exception.impl.ClpDetailRespMessage;
import org.slf4j.helpers.MessageFormatter;

/**
 * @Author: sukang
 * @Date: 2021/12/2 10:42
 */
public class ClpException extends RuntimeException {


    public ClpException(String format, Object[] args,Throwable throwable) {
        super(MessageFormatter.arrayFormat(format, args).getMessage(),throwable);
    }


    public ClpException(IExceptionMsgDetail format, Object[] args,Throwable throwable) {
        super(MessageFormatter.arrayFormat(format.getDetailMessage(), args).getMessage(),throwable);

    }


    public ClpException(String format, Object... args) {
        this(ClpDetailRespMessage.SYSTEM_ERROR.getCode() + ":" + format, args, (args == null || args.length == 0) ? null :
                args[args.length - 1] instanceof Throwable ? (Throwable) args[args.length  -1 ] : null);

    }


    public ClpException(IExceptionMsgDetail format, Object... args) {
        this(format.getDetailMessage(), args, (args == null || args.length == 0) ? null :
                args[args.length - 1] instanceof Throwable ? (Throwable) args[args.length  -1 ] : null);

    }

}
