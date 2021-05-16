package com.kaka.payment8001.service;

import com.kaka.payment8001.utils.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Service
public class AccessIpServiceImpl implements AccessIpService {


    @Override
    public String getAccessIp(HttpServletRequest request) {

        return IpUtils.getIp(request);
    }
}
