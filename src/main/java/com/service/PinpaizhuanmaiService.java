package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PinpaizhuanmaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PinpaizhuanmaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PinpaizhuanmaiView;


/**
 * 品牌专卖
 *
 * @author 
 * @email 
 * @date 2024-04-29 21:34:09
 */
public interface PinpaizhuanmaiService extends IService<PinpaizhuanmaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PinpaizhuanmaiVO> selectListVO(Wrapper<PinpaizhuanmaiEntity> wrapper);
   	
   	PinpaizhuanmaiVO selectVO(@Param("ew") Wrapper<PinpaizhuanmaiEntity> wrapper);
   	
   	List<PinpaizhuanmaiView> selectListView(Wrapper<PinpaizhuanmaiEntity> wrapper);
   	
   	PinpaizhuanmaiView selectView(@Param("ew") Wrapper<PinpaizhuanmaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PinpaizhuanmaiEntity> wrapper);

   	

}

