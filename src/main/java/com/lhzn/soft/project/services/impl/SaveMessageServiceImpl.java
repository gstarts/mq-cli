package com.lhzn.soft.project.services.impl;

import com.lhzn.soft.project.domain.MessageHistory;
import com.lhzn.soft.project.mapper.SaveMessageMapper;
import com.lhzn.soft.project.services.SaveMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SaveMessageServiceImpl implements SaveMessageService {
    @Resource
    private SaveMessageMapper saveMessageMapper;

    @Override
    public void insertMessage(MessageHistory messageHistory) {
        saveMessageMapper.insertMessageHistory(messageHistory);
    }
}
