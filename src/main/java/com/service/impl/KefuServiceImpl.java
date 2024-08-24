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


import com.dao.KefuDao;
import com.entity.KefuEntity;
import com.service.KefuService;
import com.entity.vo.KefuVO;
import com.entity.view.KefuView;

@Service("kefuService")
public class KefuServiceImpl extends ServiceImpl<KefuDao, KefuEntity> implements KefuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KefuEntity> page = this.selectPage(
                new Query<KefuEntity>(params).getPage(),
                new EntityWrapper<KefuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KefuEntity> wrapper) {
		  Page<KefuView> page =new Query<KefuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<KefuVO> selectListVO(Wrapper<KefuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KefuVO selectVO(Wrapper<KefuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KefuView> selectListView(Wrapper<KefuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KefuView selectView(Wrapper<KefuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
