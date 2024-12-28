package com.sk.netty.channel.cup.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;
import org.jpos.iso.ISOUtil;

import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

@Slf4j
public class CUPChannelDecoderHandler extends LengthFieldBasedFrameDecoder {


    /**
     * 报文长度 占用字节数
     */
    private static final int MESSAGE_LENGTH_SIZE = 4;


    /**
     * @param lengthAdjustment
     *            修改帧数据长度字段中定义的值，可以为负数
     * @param initialBytesToStrip
     *            解析的时候需要跳过的字节数
     * @param failFast
     *            为true，当frame长度超过maxFrameLength时立即报TooLongFrameException异常，为false，读取完整个帧再报异常
     */
    public CUPChannelDecoderHandler() {

        super(Integer.MAX_VALUE, 0,
                MESSAGE_LENGTH_SIZE, 0, 0, false);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        Object decode = super.decode(ctx, in);

        if(decode == null){
            return null;
        }
        ByteBuf buf = (ByteBuf)decode;
        //记录日志
        byte[] logByte = new byte[buf.readableBytes()];
        buf.readBytes(logByte);
        String byte2hex = ISOUtil.byte2hex(logByte);

        ReferenceCountUtil.release(buf);
        return byte2hex;

    }


    /**
     * 获取实际的数据长度, 源码中 会将改长度 + 4个字节的
     */
    @Override
    protected long getUnadjustedFrameLength(ByteBuf buf, int offset, int length, ByteOrder order) {
        byte[] wholeLength = new byte[MESSAGE_LENGTH_SIZE];

        buf.markReaderIndex();
        buf.readBytes(wholeLength);
        buf.resetReaderIndex();

        return Integer.parseInt(new String(wholeLength, StandardCharsets.US_ASCII));
    }

}
