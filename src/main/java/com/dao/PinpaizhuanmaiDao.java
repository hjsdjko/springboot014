package com.dao;

import com.entity.PinpaizhuanmaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PinpaizhuanmaiVO;
import com.entity.view.PinpaizhuanmaiView;


/**
 * 品牌专卖
 * 
 * @author 
 * @email 
 * @date 2024-04-29 21:34:09
 */
public interface PinpaizhuanmaiDao extends BaseMapper<PinpaizhuanmaiEntity> {
	
	List<PinpaizhuanmaiVO> selectListVO(@Param("ew") Wrapper<PinpaizhuanmaiEntity> wrapper);
	
	PinpaizhuanmaiVO selectVO(@Param("ew") Wrapper<PinpaizhuanmaiEntity> wrapper);
	
	List<PinpaizhuanmaiView> selectListView(@Param("ew") Wrapper<PinpaizhuanmaiEntity> wrapper);

	List<PinpaizhuanmaiView> selectListView(Pagination page,@Param("ew") Wrapper<PinpaizhuanmaiEntity> wrapper);

	
	PinpaizhuanmaiView selectView(@Param("ew") Wrapper<PinpaizhuanmaiEntity> wrapper);
	

}
