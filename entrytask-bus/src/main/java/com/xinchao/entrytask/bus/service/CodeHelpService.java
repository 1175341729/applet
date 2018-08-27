package com.xinchao.entrytask.bus.service;

import com.xinchao.entrytask.bus.model.CodeHelp;

import java.util.List;

public interface CodeHelpService {
    /**
     * 获取帮助中心所有问题列表
     * @return 问题列表
     */
    List<CodeHelp> get();
}
