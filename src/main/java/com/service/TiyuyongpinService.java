package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TiyuyongpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TiyuyongpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TiyuyongpinView;


/**
 * 体育用品
 *
 * @author 
 * @email 
 * @date 2024-04-29 21:34:09
 */
public interface TiyuyongpinService extends IService<TiyuyongpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TiyuyongpinVO> selectListVO(Wrapper<TiyuyongpinEntity> wrapper);
   	
   	TiyuyongpinVO selectVO(@Param("ew") Wrapper<TiyuyongpinEntity> wrapper);
   	
   	List<TiyuyongpinView> selectListView(Wrapper<TiyuyongpinEntity> wrapper);
   	
   	TiyuyongpinView selectView(@Param("ew") Wrapper<TiyuyongpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TiyuyongpinEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<TiyuyongpinEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<TiyuyongpinEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<TiyuyongpinEntity> wrapper);



}

