package com.entity.view;

import com.entity.DiscusspinpaizhuanmaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 品牌专卖评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-29 21:34:10
 */
@TableName("discusspinpaizhuanmai")
public class DiscusspinpaizhuanmaiView  extends DiscusspinpaizhuanmaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusspinpaizhuanmaiView(){
	}
 
 	public DiscusspinpaizhuanmaiView(DiscusspinpaizhuanmaiEntity discusspinpaizhuanmaiEntity){
 	try {
			BeanUtils.copyProperties(this, discusspinpaizhuanmaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
