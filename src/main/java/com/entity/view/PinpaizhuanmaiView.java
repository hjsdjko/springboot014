package com.entity.view;

import com.entity.PinpaizhuanmaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 品牌专卖
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-29 21:34:09
 */
@TableName("pinpaizhuanmai")
public class PinpaizhuanmaiView  extends PinpaizhuanmaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PinpaizhuanmaiView(){
	}
 
 	public PinpaizhuanmaiView(PinpaizhuanmaiEntity pinpaizhuanmaiEntity){
 	try {
			BeanUtils.copyProperties(this, pinpaizhuanmaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
