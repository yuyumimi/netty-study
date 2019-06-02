package com.yuyu.example.three;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class MyCharServer {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup boosGroup = null;
        EventLoopGroup workGroup =null;
        try {
             boosGroup = new NioEventLoopGroup();
             workGroup = new NioEventLoopGroup();

            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boosGroup, workGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new MyCharServerInitializer());
            ChannelFuture future = bootstrap.bind(9000).sync();
            future.channel().closeFuture().sync();
        }finally {
            boosGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }
}
