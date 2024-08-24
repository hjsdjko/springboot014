package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.PinpaizhuanmaiDao;
import com.entity.PinpaizhuanmaiEntity;
import com.service.PinpaizhuanmaiService;
import com.entity.vo.PinpaizhuanmaiVO;
import com.entity.view.PinpaizhuanmaiView;

@Service("pinpaizhuanmaiService")
public class PinpaizhuanmaiServiceImpl extends ServiceImpl<PinpaizhuanmaiDao, PinpaizhuanmaiEntity> implements PinpaizhuanmaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PinpaizhuanmaiEntity> page = this.selectPage(
                new Query<PinpaizhuanmaiEntity>(params).getPage(),
                new EntityWrapper<PinpaizhuanmaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PinpaizhuanmaiEntity> wrapper) {
		  Page<PinpaizhuanmaiView> page =new Query<PinpaizhuanmaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<PinpaizhuanmaiVO> selectListVO(Wrapper<PinpaizhuanmaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PinpaizhuanmaiVO selectVO(Wrapper<PinpaizhuanmaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PinpaizhuanmaiView> selectListView(Wrapper<PinpaizhuanmaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PinpaizhuanmaiView selectView(Wrapper<PinpaizhuanmaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
