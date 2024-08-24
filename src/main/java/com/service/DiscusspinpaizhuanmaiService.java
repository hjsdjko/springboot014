package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusspinpaizhuanmaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusspinpaizhuanmaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusspinpaizhuanmaiView;


/**
 * 品牌专卖评论表
 *
 * @author 
 * @email 
 * @date 2024-04-29 21:34:10
 */
public interface DiscusspinpaizhuanmaiService extends IService<DiscusspinpaizhuanmaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusspinpaizhuanmaiVO> selectListVO(Wrapper<DiscusspinpaizhuanmaiEntity> wrapper);
   	
   	DiscusspinpaizhuanmaiVO selectVO(@Param("ew") Wrapper<DiscusspinpaizhuanmaiEntity> wrapper);
   	
   	List<DiscusspinpaizhuanmaiView> selectListView(Wrapper<DiscusspinpaizhuanmaiEntity> wrapper);
   	
   	DiscusspinpaizhuanmaiView selectView(@Param("ew") Wrapper<DiscusspinpaizhuanmaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusspinpaizhuanmaiEntity> wrapper);

   	

}

