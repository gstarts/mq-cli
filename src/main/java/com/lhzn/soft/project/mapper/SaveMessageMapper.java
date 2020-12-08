package com.lhzn.soft.project.mapper;

import com.lhzn.soft.project.domain.MessageHistory;

public interface SaveMessageMapper {
    /**
     * 插入消息
     */
    int insertMessageHistory(MessageHistory messageHistory);

}
