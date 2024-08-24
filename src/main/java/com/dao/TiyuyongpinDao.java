package com.dao;

import com.entity.TiyuyongpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TiyuyongpinVO;
import com.entity.view.TiyuyongpinView;


/**
 * 体育用品
 * 
 * @author 
 * @email 
 * @date 2024-04-29 21:34:09
 */
public interface TiyuyongpinDao extends BaseMapper<TiyuyongpinEntity> {
	
	List<TiyuyongpinVO> selectListVO(@Param("ew") Wrapper<TiyuyongpinEntity> wrapper);
	
	TiyuyongpinVO selectVO(@Param("ew") Wrapper<TiyuyongpinEntity> wrapper);
	
	List<TiyuyongpinView> selectListView(@Param("ew") Wrapper<TiyuyongpinEntity> wrapper);

	List<TiyuyongpinView> selectListView(Pagination page,@Param("ew") Wrapper<TiyuyongpinEntity> wrapper);

	
	TiyuyongpinView selectView(@Param("ew") Wrapper<TiyuyongpinEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<TiyuyongpinEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<TiyuyongpinEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<TiyuyongpinEntity> wrapper);



}
