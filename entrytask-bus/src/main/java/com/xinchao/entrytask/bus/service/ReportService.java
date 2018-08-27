package com.xinchao.entrytask.bus.service;

import com.xinchao.entrytask.bus.model.BriefingModel;

import java.util.List;

public interface ReportService {

    BriefingModel get(String supplierId);

    List<BriefingModel> get();
}
