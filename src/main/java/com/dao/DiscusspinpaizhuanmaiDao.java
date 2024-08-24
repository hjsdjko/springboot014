package com.dao;

import com.entity.DiscusspinpaizhuanmaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusspinpaizhuanmaiVO;
import com.entity.view.DiscusspinpaizhuanmaiView;


/**
 * 品牌专卖评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-29 21:34:10
 */
public interface DiscusspinpaizhuanmaiDao extends BaseMapper<DiscusspinpaizhuanmaiEntity> {
	
	List<DiscusspinpaizhuanmaiVO> selectListVO(@Param("ew") Wrapper<DiscusspinpaizhuanmaiEntity> wrapper);
	
	DiscusspinpaizhuanmaiVO selectVO(@Param("ew") Wrapper<DiscusspinpaizhuanmaiEntity> wrapper);
	
	List<DiscusspinpaizhuanmaiView> selectListView(@Param("ew") Wrapper<DiscusspinpaizhuanmaiEntity> wrapper);

	List<DiscusspinpaizhuanmaiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusspinpaizhuanmaiEntity> wrapper);

	
	DiscusspinpaizhuanmaiView selectView(@Param("ew") Wrapper<DiscusspinpaizhuanmaiEntity> wrapper);
	

}
