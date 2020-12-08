package com.lhzn.soft.project.mapper;

import com.lhzn.soft.project.domain.DrRfid;

import java.util.List;

/**
 * 车辆通关司机卡信息Mapper接口
 * 
 * @author lanzhenyuan
 * @date 2020-06-18
 */
public interface DrRfidMapper 
{
    /**
     * 查询车辆通关司机卡信息
     * 
     * @param id 车辆通关司机卡信息ID
     * @return 车辆通关司机卡信息
     */
     DrRfid selectDrRfidById (Long id);

    /**
     * 查询车辆通关司机卡信息列表
     * 
     * @param drRfid 车辆通关司机卡信息
     * @return 车辆通关司机卡信息集合
     */
     List<DrRfid> selectDrRfidList (DrRfid drRfid);

    /**
     * 新增车辆通关司机卡信息
     * 
     * @param drRfid 车辆通关司机卡信息
     * @return 结果
     */
     int insertDrRfid (DrRfid drRfid);

    /**
     * 修改车辆通关司机卡信息
     * 
     * @param drRfid 车辆通关司机卡信息
     * @return 结果
     */
     int updateDrRfid (DrRfid drRfid);

    /**
     * 删除车辆通关司机卡信息
     * 
     * @param id 车辆通关司机卡信息ID
     * @return 结果
     */
     int deleteDrRfidById (Long id);

    /**
     * 批量删除车辆通关司机卡信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
     int deleteDrRfidByIds (Long[] ids);
}
