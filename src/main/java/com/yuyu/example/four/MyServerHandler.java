package com.yuyu.example.four;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @ClassName MyServerHandler
 * @Description TODO
 * @Author yuyu
 * @Date 2019/5/27 15:40
 * @Version 1.0
 **/
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idle = (IdleStateEvent) evt;
            String state=null;
            switch (idle.state()) {
                case WRITER_IDLE:
                    state="写空闲";
                    break;
                case READER_IDLE:
                    state="读空闲";
                    break;
                case ALL_IDLE:
                    state="读写空闲";
                    break;
                default:
                    break;
            }
            System.out.println(state);
            ctx.channel().close();
        }
    }
}
