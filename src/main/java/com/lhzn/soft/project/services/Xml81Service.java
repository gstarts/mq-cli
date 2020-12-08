package com.lhzn.soft.project.services;

import com.lhzn.soft.project.domain.GatherdataLog;

/**
 * 华东报文接口
 */
public interface Xml81Service {

    /**
     * 转发采集数据报文
     */
    String create81Xml (GatherdataLog gatherdataLog);
}
