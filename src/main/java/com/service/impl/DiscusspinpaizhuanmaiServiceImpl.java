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


import com.dao.DiscusspinpaizhuanmaiDao;
import com.entity.DiscusspinpaizhuanmaiEntity;
import com.service.DiscusspinpaizhuanmaiService;
import com.entity.vo.DiscusspinpaizhuanmaiVO;
import com.entity.view.DiscusspinpaizhuanmaiView;

@Service("discusspinpaizhuanmaiService")
public class DiscusspinpaizhuanmaiServiceImpl extends ServiceImpl<DiscusspinpaizhuanmaiDao, DiscusspinpaizhuanmaiEntity> implements DiscusspinpaizhuanmaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusspinpaizhuanmaiEntity> page = this.selectPage(
                new Query<DiscusspinpaizhuanmaiEntity>(params).getPage(),
                new EntityWrapper<DiscusspinpaizhuanmaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusspinpaizhuanmaiEntity> wrapper) {
		  Page<DiscusspinpaizhuanmaiView> page =new Query<DiscusspinpaizhuanmaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscusspinpaizhuanmaiVO> selectListVO(Wrapper<DiscusspinpaizhuanmaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusspinpaizhuanmaiVO selectVO(Wrapper<DiscusspinpaizhuanmaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusspinpaizhuanmaiView> selectListView(Wrapper<DiscusspinpaizhuanmaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusspinpaizhuanmaiView selectView(Wrapper<DiscusspinpaizhuanmaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
