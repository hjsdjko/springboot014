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


import com.dao.TiyuyongpinDao;
import com.entity.TiyuyongpinEntity;
import com.service.TiyuyongpinService;
import com.entity.vo.TiyuyongpinVO;
import com.entity.view.TiyuyongpinView;

@Service("tiyuyongpinService")
public class TiyuyongpinServiceImpl extends ServiceImpl<TiyuyongpinDao, TiyuyongpinEntity> implements TiyuyongpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TiyuyongpinEntity> page = this.selectPage(
                new Query<TiyuyongpinEntity>(params).getPage(),
                new EntityWrapper<TiyuyongpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TiyuyongpinEntity> wrapper) {
		  Page<TiyuyongpinView> page =new Query<TiyuyongpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<TiyuyongpinVO> selectListVO(Wrapper<TiyuyongpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TiyuyongpinVO selectVO(Wrapper<TiyuyongpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TiyuyongpinView> selectListView(Wrapper<TiyuyongpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TiyuyongpinView selectView(Wrapper<TiyuyongpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<TiyuyongpinEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<TiyuyongpinEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<TiyuyongpinEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
