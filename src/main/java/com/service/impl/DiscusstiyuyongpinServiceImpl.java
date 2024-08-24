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


import com.dao.DiscusstiyuyongpinDao;
import com.entity.DiscusstiyuyongpinEntity;
import com.service.DiscusstiyuyongpinService;
import com.entity.vo.DiscusstiyuyongpinVO;
import com.entity.view.DiscusstiyuyongpinView;

@Service("discusstiyuyongpinService")
public class DiscusstiyuyongpinServiceImpl extends ServiceImpl<DiscusstiyuyongpinDao, DiscusstiyuyongpinEntity> implements DiscusstiyuyongpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusstiyuyongpinEntity> page = this.selectPage(
                new Query<DiscusstiyuyongpinEntity>(params).getPage(),
                new EntityWrapper<DiscusstiyuyongpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusstiyuyongpinEntity> wrapper) {
		  Page<DiscusstiyuyongpinView> page =new Query<DiscusstiyuyongpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscusstiyuyongpinVO> selectListVO(Wrapper<DiscusstiyuyongpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusstiyuyongpinVO selectVO(Wrapper<DiscusstiyuyongpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusstiyuyongpinView> selectListView(Wrapper<DiscusstiyuyongpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusstiyuyongpinView selectView(Wrapper<DiscusstiyuyongpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
