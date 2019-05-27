package com.yuyu.example.five;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.EventExecutorGroup;

import java.time.LocalDateTime;

/**
 * @ClassName MyWebSockethandler
 * @Description TODO
 * @Author yuyu
 * @Date 2019/5/27 16:27
 * @Version 1.0
 **/
public class MyWebSockethandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("收到客户端消息：" + msg.text());
        TextWebSocketFrame text = new TextWebSocketFrame("客户端时间" + LocalDateTime.now());
        channel.writeAndFlush(text);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handler add "+ctx.channel().id());
    }
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handler removed "+ctx.channel().id());
    }
}
