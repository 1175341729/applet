package com.xinchao.entrytask.bus.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.xinchao.entrytask.api.common.CommonCode;
import com.xinchao.entrytask.api.common.JSONResponse;
import com.xinchao.entrytask.api.controller.IAreaController;
import com.xinchao.entrytask.api.model.Area;
import com.xinchao.entrytask.bus.model.SaleArea;
import com.xinchao.entrytask.bus.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 地市
 */
@RestController
@Slf4j
public class AreaController implements IAreaController {

    @Autowired
    AreaService areaService;
    /**
     * 获取所有省份
     * @return
     */
    @Override
    @GetMapping("/area/province")
    public JSONResponse<List<Area>> get() {
        List<SaleArea> saleAreas = areaService.select("1");
        List<Area> areas = JSONArray.parseArray(JSON.toJSONString(saleAreas), Area.class);
        return new JSONResponse<>(true, CommonCode.SUCCESS.getCode(),CommonCode.SUCCESS.getMsg(),areas);
    }

    /**
     * 根据省份ID 获取市
     * @param parentId
     * @return
     */
    @Override
    @GetMapping("/area/city")
    public JSONResponse<List<Area>> get(String parentId) {
        List<SaleArea> saleAreas = areaService.select(parentId,"2");
        List<Area> areas = JSONArray.parseArray(JSON.toJSONString(saleAreas), Area.class);
        return new JSONResponse<>(true, CommonCode.SUCCESS.getCode(),CommonCode.SUCCESS.getMsg(),areas);
    }
}
