package com.xinchao.entrytask.bus.service.Impl;

import com.xinchao.entrytask.bus.dao.SaleAreaMapper;
import com.xinchao.entrytask.bus.model.SaleArea;
import com.xinchao.entrytask.bus.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class AreaServiceImpl implements AreaService{
    @Autowired
    SaleAreaMapper saleAreasMapper;
    @Override
    public List<SaleArea> select(String level) {
        SaleArea saleAreas=new SaleArea();
        saleAreas.setLevelType(level);
        return saleAreasMapper.selectByCondition(saleAreas);
    }

    @Override
    public List<SaleArea> select(String parentId, String level) {
        SaleArea saleAreas=new SaleArea();
        saleAreas.setLevelType(level);
        saleAreas.setParentId(parentId+"");
        return saleAreasMapper.selectByCondition(saleAreas);
    }

    @Override
    public SaleArea selectByCityName(String cityName) {
        return saleAreasMapper.selectByCityName(cityName);
    }
}
