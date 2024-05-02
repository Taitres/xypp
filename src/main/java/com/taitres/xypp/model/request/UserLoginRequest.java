package com.taitres.xypp.model.request;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户登录请求体
 *
 */
@Data
public class UserLoginRequest implements Serializable {


    @Serial
    private static final long serialVersionUID = -3326099456672149110L;

    private String userAccount;

    private String userPassword;
}
