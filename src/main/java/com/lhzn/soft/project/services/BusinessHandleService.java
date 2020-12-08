package com.lhzn.soft.project.services;

import com.lhzn.soft.project.domain.GatherdataLog;

import java.util.List;
import java.util.Map;

/**
 * 业务接口
 * @author gstarqs
 */
public interface BusinessHandleService{


    /**
     * 更新数据
     * @param map 数据
     * @param xml 报文
     */
    void XmlUpdate (Map<String, Object> map, String xml );
    /**
     * 更新上传完场的报文状态
     */
    int updateXml81BySessionId ( String id, String flag, String led );

    /**
     * 根据sessionId取数据做报文
     *
     * @return 结果
     */
    List<GatherdataLog> selectBySessionId ();


    /**
     * 更新81报文
     *
     * @param stringXml 报文
     * @param sessionId key
     */
    void updateData81Command (String stringXml, String sessionId );

}
