package com.xinchao.entrytask.bus.controller;

import com.alibaba.fastjson.JSON;
import com.xinchao.entrytask.api.common.CommonCode;
import com.xinchao.entrytask.api.common.JSONResponse;
import com.xinchao.entrytask.api.controller.IReportController;
import com.xinchao.entrytask.api.model.BriefingModel;
import com.xinchao.entrytask.bus.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 报表
 */
@RestController
@Slf4j
public class ReportController implements IReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 统计简报
     * @param supplierId 供应商ID
     * @return 统计数据
     */
    @Override
    @GetMapping("/report/{supplierId}")
    public JSONResponse<BriefingModel> get(@PathVariable("supplierId") String supplierId) {

        com.xinchao.entrytask.bus.model.BriefingModel briefingModel=reportService.get(supplierId);

        return new JSONResponse<>(true, CommonCode.SUCCESS.getCode(),CommonCode.SUCCESS.getMsg(), JSON.parseObject(JSON.toJSONString(briefingModel),BriefingModel.class));
    }

    /**
     * 任务数据统计
     * @return 供应商分组数据
     */
    @Override
    @GetMapping("/report")
    public JSONResponse<List<BriefingModel>> get() {
        List<com.xinchao.entrytask.bus.model.BriefingModel> briefingModelList = reportService.get();

        return new JSONResponse<>(true,CommonCode.SUCCESS.getCode(),CommonCode.SUCCESS.getMsg(),JSON.parseArray(JSON.toJSONString(briefingModelList),BriefingModel.class));
    }
}
