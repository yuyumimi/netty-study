package com.yuyu.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

public class Test {
    public static void main(String[] args) {
        DataInfo.Student.Builder builder = DataInfo.Student.newBuilder();
        builder.setName("yuyu");
        builder.setAge(18);
        builder.setAddress("bejing");
        DataInfo.Student build = builder.build();
        System.out.println(build);
        byte[] bytes=build.toByteArray();

        System.out.println(bytes.length);
        try {
            DataInfo.Student student=DataInfo.Student.parseFrom(bytes);
            System.out.println(student);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

    }
}
