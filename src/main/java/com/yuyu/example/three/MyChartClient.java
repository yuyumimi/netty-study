package com.yuyu.example.three;

import com.yuyu.example.two.MyClientInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyChartClient {
    public static void main(String[] args) throws InterruptedException, IOException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap client = new Bootstrap();
            client.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .handler(new MyChartClientInitializer());
            Channel ch = client.connect("localhost", 9000).channel();
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            for(;;){
                ch.writeAndFlush(reader.readLine()+"\r\n");
            }

        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
