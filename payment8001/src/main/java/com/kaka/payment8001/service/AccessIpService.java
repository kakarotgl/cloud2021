package com.kaka.payment8001.service;

import javax.servlet.http.HttpServletRequest;

/**
 *  会员登录日志表(SysLoginRecords)表服务接口
 *
 * @author code generator
 */
public interface AccessIpService {
    /**
     * 获取访问ip
     * @param
     */
    String getAccessIp(HttpServletRequest request);
}
