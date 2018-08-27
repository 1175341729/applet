package com.xinchao.entrytask.bus.service;

import com.xinchao.entrytask.bus.model.SaleArea;

import java.util.List;

/***
 * 省市接口
 */
public interface AreaService {
    List<SaleArea> select(String level);
    List<SaleArea> select(String parentId,String level);
    SaleArea selectByCityName(String cityName);
}
