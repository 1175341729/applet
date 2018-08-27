package com.xinchao.entrytask.bus.service.Impl;

import com.xinchao.entrytask.bus.dao.TaskMapper;
import com.xinchao.entrytask.bus.model.BriefingModel;
import com.xinchao.entrytask.bus.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private TaskMapper taskMapper;

    /**
     * 根据供应商ID 统计简报
     * @param supplierId 供应商ID
     * @return 简报数据
     */
    @Override
    public BriefingModel get(String supplierId) {
        return taskMapper.getBriefing(supplierId);
    }

    /**
     * 根据供应商分组统计
     * @return 列表数据
     */
    @Override
    public List<BriefingModel> get() {
        return taskMapper.getBriefingGroupBySupplier();
    }
}
