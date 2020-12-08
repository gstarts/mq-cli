package com.lhzn.soft.project.mapper;

import com.lhzn.soft.project.domain.GatherdataLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * qweMapper接口
 *
 * @author lanzhenyuan
 * @date 2020-06-18
 */
public interface GatherdataLogMapper {
    /**
     * 查询qwe
     *
     * @param sessionId qweID
     * @return qwe
     */
     GatherdataLog selectGatherdataLogById ( String sessionId );

    /**
     * 查询qwe列表
     *
     * @param gatherdataLog qwe
     * @return qwe集合
     */
     List<GatherdataLog> selectGatherdataLogList ( GatherdataLog gatherdataLog );

    /**
     * 新增qwe
     *
     * @param gatherdataLog qwe
     * @return 结果
     */
     int insertGatherdataLog ( GatherdataLog gatherdataLog );

    /**
     * 修改qwe
     *
     * @param gatherdataLog qwe
     * @return 结果
     */
     int updateGatherdataLog ( GatherdataLog gatherdataLog );

    /**
     * 删除qwe
     *
     * @param sessionId qweID
     * @return 结果
     */
     int deleteGatherdataLogById ( String sessionId );

    /**
     * 批量删除qwe
     *
     * @param sessionIds 需要删除的数据ID
     * @return 结果
     */
     int deleteGatherdataLogByIds ( String[] sessionIds );

    /**
     * 扫描需要上传的81报文
     *
     * @return 结果
     */
     List<GatherdataLog> selectXml81 ();

    /**
     * 程序异常更新
     *
     * @param sessionId key
     * @param flag      处理标识
     * @param led       信息
     * @return 结果
     */
     int updateGatherDataFag ( @Param("sessionId") String sessionId, @Param("flag") String flag, @Param("led") String led );

    /**
     * 程序异常更新
     *
     * @param sessionId key
     * @param flag      处理标识
     * @param led       信息
     * @return 结果
     */
    int updateGatherDataFagErr ( @Param("sessionId") String sessionId, @Param("flag") String flag, @Param("led") String led );

    /**
     * 更新报文
     *
     * @param stringXml 报文
     * @param sessionId key
     * @return 结果
     */

     int updateData81Command ( @Param("stringXml") String stringXml, @Param("sessionId") String sessionId );

    /**
     * 查询
     *
     * @return 结果
     */
     List<GatherdataLog> selectBySessionId ();
}
