package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KefuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KefuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KefuView;


/**
 * 客服
 *
 * @author 
 * @email 
 * @date 2024-04-29 21:34:09
 */
public interface KefuService extends IService<KefuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KefuVO> selectListVO(Wrapper<KefuEntity> wrapper);
   	
   	KefuVO selectVO(@Param("ew") Wrapper<KefuEntity> wrapper);
   	
   	List<KefuView> selectListView(Wrapper<KefuEntity> wrapper);
   	
   	KefuView selectView(@Param("ew") Wrapper<KefuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KefuEntity> wrapper);

   	

}

