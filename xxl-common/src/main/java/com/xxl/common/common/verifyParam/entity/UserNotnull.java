package com.xxl.common.common.verifyParam.entity;

public class UserNotnull {

    String name;

    String idCardNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserNotnull{" +
                "name='" + name + '\'' +
                ", idCardNo='" + idCardNo + '\'' +
                '}';
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }
}
