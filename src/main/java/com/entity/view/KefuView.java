package com.entity.view;

import com.entity.KefuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 客服
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-29 21:34:09
 */
@TableName("kefu")
public class KefuView  extends KefuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KefuView(){
	}
 
 	public KefuView(KefuEntity kefuEntity){
 	try {
			BeanUtils.copyProperties(this, kefuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
