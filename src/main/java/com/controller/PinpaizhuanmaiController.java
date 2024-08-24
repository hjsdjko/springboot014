package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.PinpaizhuanmaiEntity;
import com.entity.view.PinpaizhuanmaiView;

import com.service.PinpaizhuanmaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import scala.Tuple2;

/**
 * 品牌专卖
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-29 21:34:09
 */
@RestController
@RequestMapping("/pinpaizhuanmai")
public class PinpaizhuanmaiController {
    @Autowired
    private PinpaizhuanmaiService pinpaizhuanmaiService;
    @Autowired
    private JavaSparkContext javaSparkContext;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PinpaizhuanmaiEntity pinpaizhuanmai,
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<PinpaizhuanmaiEntity> ew = new EntityWrapper<PinpaizhuanmaiEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = pinpaizhuanmaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pinpaizhuanmai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PinpaizhuanmaiEntity pinpaizhuanmai, 
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<PinpaizhuanmaiEntity> ew = new EntityWrapper<PinpaizhuanmaiEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = pinpaizhuanmaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pinpaizhuanmai), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PinpaizhuanmaiEntity pinpaizhuanmai){
       	EntityWrapper<PinpaizhuanmaiEntity> ew = new EntityWrapper<PinpaizhuanmaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( pinpaizhuanmai, "pinpaizhuanmai")); 
        return R.ok().put("data", pinpaizhuanmaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PinpaizhuanmaiEntity pinpaizhuanmai){
        EntityWrapper< PinpaizhuanmaiEntity> ew = new EntityWrapper< PinpaizhuanmaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( pinpaizhuanmai, "pinpaizhuanmai")); 
		PinpaizhuanmaiView pinpaizhuanmaiView =  pinpaizhuanmaiService.selectView(ew);
		return R.ok("查询品牌专卖成功").put("data", pinpaizhuanmaiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PinpaizhuanmaiEntity pinpaizhuanmai = pinpaizhuanmaiService.selectById(id);
        return R.ok().put("data", pinpaizhuanmai);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PinpaizhuanmaiEntity pinpaizhuanmai = pinpaizhuanmaiService.selectById(id);
        return R.ok().put("data", pinpaizhuanmai);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PinpaizhuanmaiEntity pinpaizhuanmai, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(pinpaizhuanmai);
        pinpaizhuanmaiService.insert(pinpaizhuanmai);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PinpaizhuanmaiEntity pinpaizhuanmai, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(pinpaizhuanmai);
        pinpaizhuanmaiService.insert(pinpaizhuanmai);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PinpaizhuanmaiEntity pinpaizhuanmai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(pinpaizhuanmai);
        pinpaizhuanmaiService.updateById(pinpaizhuanmai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        pinpaizhuanmaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
