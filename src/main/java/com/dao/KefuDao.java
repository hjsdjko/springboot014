package com.dao;

import com.entity.KefuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KefuVO;
import com.entity.view.KefuView;


/**
 * 客服
 * 
 * @author 
 * @email 
 * @date 2024-04-29 21:34:09
 */
public interface KefuDao extends BaseMapper<KefuEntity> {
	
	List<KefuVO> selectListVO(@Param("ew") Wrapper<KefuEntity> wrapper);
	
	KefuVO selectVO(@Param("ew") Wrapper<KefuEntity> wrapper);
	
	List<KefuView> selectListView(@Param("ew") Wrapper<KefuEntity> wrapper);

	List<KefuView> selectListView(Pagination page,@Param("ew") Wrapper<KefuEntity> wrapper);

	
	KefuView selectView(@Param("ew") Wrapper<KefuEntity> wrapper);
	

}
