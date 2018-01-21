package com.ckkj.zct.door.data.protocol;

import java.io.Serializable;

/**
 * Created by zct11 on 2018/1/21.
 */

public class RegisterReq_java implements Serializable{

    private String mobile;
    private String pwd;
    private String verifyCode;

    public RegisterReq_java(String mobile, String pwd, String verifyCode) {
        this.mobile = mobile;
        this.pwd = pwd;
        this.verifyCode = verifyCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}