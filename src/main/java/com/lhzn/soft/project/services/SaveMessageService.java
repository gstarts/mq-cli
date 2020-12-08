package com.lhzn.soft.project.services;

import com.lhzn.soft.project.domain.MessageHistory;

public interface SaveMessageService {
    /**
     * 保存消息
     */
    void insertMessage(MessageHistory messageHistory);
}
