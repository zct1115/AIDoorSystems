package com.ckkj.zct.baselibrary.data.protocol

/**
 * @author zct
 * Created by zct11 on 2018/1/19.
 * 能用响应对象
 *  @status:响应状态码
 *  @message:响应文字消息
 *  @data:具体响应业务对象
 */
data class BaseResp<out T>(val status: Int, val message: String, val data: T)
