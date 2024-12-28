## NioEventLoopGroup(Boss)
1. 专门负责接收客户端的链接
2. 包含多个 NioEventLoop , 数量默认为核心数 * 2;NioEventLoop 都包含一个selector, 用于监控绑定在上边的网络通讯, 其中有三步;
3. step1 轮询accept事件
4. step2 处理accept事件,与client建立链接后,生成NioSocketChannel, 并将其注册到某个Work NioEventLoop上的selector上

## NioEventLoopGroup(Worker)

1. 处理IO事件
2. 包含多个 NioEventLoop , 数量默认为核心数 * 2;
3. 每个NioEventLoop  轮询reader/writer 事件, 并在NioSockerChannel上进行处理;
4. 处理业务时, 会使用pipeline 处理, pipeline 中包含了channel, hanlder 任务链处理channel;



# Handler使用规范

## 1 ChannelInboudHadnler
      按照添加顺序正序执行
## 2 ChannelOutboundHandler
      按照添加顺序倒序执行
## 3 在使用Handler的过程中，需要注意：
      ① ChannelInboundHandler之间的传递,通过调用 ctx.fireChannelRead(msg) 实现;调用ctx.write(msg) 将传递到ChannelOutboundHandler。
      ②ctx.write()方法执行后，需要调用flush()方法才能令它立即执行。
      ③ChannelOutboundHandler 在注册的时候需要放在最后一个ChannelInboundHandler之前,否则将无法传递到ChannelOutboundHandler。
      ④Handler的消费处理放在最后一个处理。


# ByteToMessageDecoder

     1. LengthFieldBasedFrameDecoder 发送数据总长度 = 数据包长度 + lengthFieldOffset + lengthFieldLength + lengthAdjustment
     2. FixedLengthFrameDecoder  A BC DEFG HI -> FixedLengthFrameDecoder(3) -> ABC DEF GHI
     3. LineBasedFrameDecoder
     4. DelimiterBasedFrameDecoder 分隔符