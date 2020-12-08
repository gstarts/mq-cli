package com.lhzn.soft.project.services.impl;

import com.lhzn.soft.project.domain.*;
import com.lhzn.soft.project.mapper.*;
import com.lhzn.soft.project.services.BusinessHandleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class BusinessServiceImpl implements BusinessHandleService {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private GatherdataLogMapper glMapper;
    @Resource
    private ContaRecognitionMapper contaRecognitionMapper;
    @Resource
    private DrRfidMapper drRfidMapper;
    @Resource
    private ExtendMapper extendMapper;
    @Resource
    private FormInfoMapper formInfoMapper;
    @Resource
    private IcInfoMapper icInfoMapper;
    @Resource
    private PhotoMapper photoMapper;
    @Resource
    private VeLicenseRecognitionMapper veLicenseRecognitionMapper;
    @Resource
    private GVeRfidMapper gVeRfidMapper;

    private final static String dataFlg = "31";

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void XmlUpdate(Map<String, Object> map, String xml) {
        logger.info("开始更新");
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        GatherdataLog gatherdataLog = (GatherdataLog) map.get("gl");
        // xml 82 回执以后更新
        gatherdataLog.setGatheralldataFlg(dataFlg);
        gatherdataLog.setX82Command(xml);
        String sessionId = gatherdataLog.getSessionId();
        for (Map.Entry<String, Object> entity : entries) {
            if (entity.getKey().contains("cr")) {
                ContaRecognition contaRecognition = (ContaRecognition) entity.getValue();
                contaRecognition.setSessionId(sessionId);
                contaRecognitionMapper.updateContaRecognition(contaRecognition);
            } else if (entity.getKey().contains("gl")) {
                glMapper.updateGatherdataLog(gatherdataLog);

            } else if (entity.getKey().contains("dr")) {
                DrRfid drRfid = (DrRfid) entity.getValue();
                drRfid.setSessionId(sessionId);
                drRfidMapper.updateDrRfid(drRfid);

            } else if (entity.getKey().contains("extend")) {
                Extend extend = (Extend) entity.getValue();
                extend.setSessionId(sessionId);
                extendMapper.updateExtend(extend);

            } else if (entity.getKey().contains("fi")) {
                FormInfo formInfo = (FormInfo) entity.getValue();
                formInfo.setSessionId(sessionId);
                formInfoMapper.updateFormInfo(formInfo);

            } else if (entity.getKey().contains("ic")) {
                IcInfo icInfo = (IcInfo) entity.getValue();
                icInfo.setSessionId(sessionId);
                icInfo.setSessionId(sessionId);
                icInfoMapper.updateIcInfo(icInfo);

            } else if (entity.getKey().contains("photo")) {
                Photo photo = (Photo) entity.getValue();
                photo.setSessionId(sessionId);
                photoMapper.updatePhoto(photo);

            } else if (entity.getKey().contains("vr")) {
                VeLicenseRecognition veLicenseRecognition = (VeLicenseRecognition) entity.getValue();
                veLicenseRecognition.setSessionId(sessionId);
                veLicenseRecognitionMapper.updateVeLicenseRecognition(veLicenseRecognition);
            } else if (entity.getKey().contains("veRfid")) {
                VeRfid veRfid = (VeRfid) entity.getValue();
                veRfid.setSessionId(sessionId);
                gVeRfidMapper.updateGVeRfid(veRfid);
            }
        }
        logger.info("更新结束");
    }

    @Override
    public int updateXml81BySessionId(String id, String flag, String led) {
        return glMapper.updateGatherDataFag(id, flag, led);
    }


    @Override
    public List<GatherdataLog> selectBySessionId() {
        return glMapper.selectBySessionId();
    }

    @Override
    public void updateData81Command(String stringXml, String sessionId) {
        glMapper.updateData81Command(stringXml, sessionId);
    }

}
