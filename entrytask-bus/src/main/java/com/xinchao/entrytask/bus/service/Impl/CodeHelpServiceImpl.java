package com.xinchao.entrytask.bus.service.Impl;

import com.xinchao.entrytask.bus.dao.CodeHelpMapper;
import com.xinchao.entrytask.bus.model.CodeHelp;
import com.xinchao.entrytask.bus.service.CodeHelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeHelpServiceImpl implements CodeHelpService {

    @Autowired
    private CodeHelpMapper codeHelpMapper;
    @Override
    public List<CodeHelp> get() {

        return codeHelpMapper.get();
    }
}
