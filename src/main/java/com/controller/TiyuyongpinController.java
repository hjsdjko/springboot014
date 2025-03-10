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
import com.entity.OrdersEntity;
import com.service.OrdersService;
import com.utils.UserBasedCollaborativeFiltering;

import com.entity.TiyuyongpinEntity;
import com.entity.view.TiyuyongpinView;

import com.service.TiyuyongpinService;
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
 * 体育用品
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-29 21:34:09
 */
@RestController
@RequestMapping("/tiyuyongpin")
public class TiyuyongpinController {
    @Autowired
    private TiyuyongpinService tiyuyongpinService;
    @Autowired
    private JavaSparkContext javaSparkContext;

    @Autowired
    private StoreupService storeupService;

    @Autowired
    private OrdersService ordersService;


    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TiyuyongpinEntity tiyuyongpin,
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<TiyuyongpinEntity> ew = new EntityWrapper<TiyuyongpinEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = tiyuyongpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tiyuyongpin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TiyuyongpinEntity tiyuyongpin, 
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<TiyuyongpinEntity> ew = new EntityWrapper<TiyuyongpinEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = tiyuyongpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tiyuyongpin), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TiyuyongpinEntity tiyuyongpin){
       	EntityWrapper<TiyuyongpinEntity> ew = new EntityWrapper<TiyuyongpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tiyuyongpin, "tiyuyongpin")); 
        return R.ok().put("data", tiyuyongpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TiyuyongpinEntity tiyuyongpin){
        EntityWrapper< TiyuyongpinEntity> ew = new EntityWrapper< TiyuyongpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tiyuyongpin, "tiyuyongpin")); 
		TiyuyongpinView tiyuyongpinView =  tiyuyongpinService.selectView(ew);
		return R.ok("查询体育用品成功").put("data", tiyuyongpinView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TiyuyongpinEntity tiyuyongpin = tiyuyongpinService.selectById(id);
		tiyuyongpin.setClicknum(tiyuyongpin.getClicknum()+1);
		tiyuyongpinService.updateById(tiyuyongpin);
        tiyuyongpin = tiyuyongpinService.selectView(new EntityWrapper<TiyuyongpinEntity>().eq("id", id));
        return R.ok().put("data", tiyuyongpin);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TiyuyongpinEntity tiyuyongpin = tiyuyongpinService.selectById(id);
		tiyuyongpin.setClicknum(tiyuyongpin.getClicknum()+1);
		tiyuyongpinService.updateById(tiyuyongpin);
        tiyuyongpin = tiyuyongpinService.selectView(new EntityWrapper<TiyuyongpinEntity>().eq("id", id));
        return R.ok().put("data", tiyuyongpin);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TiyuyongpinEntity tiyuyongpin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(tiyuyongpin);
        tiyuyongpinService.insert(tiyuyongpin);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TiyuyongpinEntity tiyuyongpin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(tiyuyongpin);
        tiyuyongpinService.insert(tiyuyongpin);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TiyuyongpinEntity tiyuyongpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tiyuyongpin);
        tiyuyongpinService.updateById(tiyuyongpin);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tiyuyongpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,TiyuyongpinEntity tiyuyongpin, HttpServletRequest request,String pre){
        EntityWrapper<TiyuyongpinEntity> ew = new EntityWrapper<TiyuyongpinEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = tiyuyongpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tiyuyongpin), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（基于用户的协同算法）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,TiyuyongpinEntity tiyuyongpin, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<OrdersEntity> orders = ordersService.selectList(new EntityWrapper<OrdersEntity>());
        Map<String, Map<String, Double>> ratings = new HashMap<>();
        if(orders!=null && orders.size()>0) {
            for(OrdersEntity o : orders) {
                Map<String, Double> userRatings = null;
                if(ratings.containsKey(o.getUserid().toString())) {
                    userRatings = ratings.get(o.getUserid().toString());
                } else {
                    userRatings = new HashMap<>();
                    ratings.put(o.getUserid().toString(), userRatings);
                }
                if(userRatings.containsKey(o.getGoodid().toString())) {
                    userRatings.put(o.getGoodid().toString(), userRatings.get(o.getGoodid().toString())+1.0);
                } else {
                    userRatings.put(o.getGoodid().toString(), 1.0);
                }

            }
        }
        // 创建协同过滤对象
        UserBasedCollaborativeFiltering filter = new UserBasedCollaborativeFiltering(ratings);

        // 为指定用户推荐物品
        String targetUser = userId;
        int numRecommendations = limit;
        List<String> recommendations = filter.recommendItems(targetUser, numRecommendations);

        // 输出推荐结果
        System.out.println("Recommendations for " + targetUser + ":");
        for (String item : recommendations) {
            System.out.println(item);
        }

        EntityWrapper<TiyuyongpinEntity> ew = new EntityWrapper<TiyuyongpinEntity>();
        ew.in("id", recommendations);
        if(recommendations!=null && recommendations.size()>0) {
            ew.last("order by FIELD(id, "+String.join(",", recommendations)+")");
        }

        PageUtils page = tiyuyongpinService.queryPage(params, ew);
        List<TiyuyongpinEntity> pageList = (List<TiyuyongpinEntity>)page.getList();
        if(pageList.size()<limit) {
            int toAddNum = limit-pageList.size();
            ew = new EntityWrapper<TiyuyongpinEntity>();
            ew.notIn("id", recommendations);
            ew.orderBy("id", false);
            ew.last("limit "+toAddNum);
            pageList.addAll(tiyuyongpinService.selectList(ew));
        } else if(pageList.size()>limit) {
            pageList = pageList.subList(0, limit);
        }
        page.setList(pageList);

        return R.ok().put("data", page);
    }




    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<TiyuyongpinEntity> ew = new EntityWrapper<TiyuyongpinEntity>();
        List<Map<String, Object>> result = tiyuyongpinService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        List<Map<String, Object>> result2 = new ArrayList<Map<String,Object>>();
        for(Map<String, Object> m : result) {
            List<Tuple2<String, Object>> data = new ArrayList<>();
            for(String s : m.keySet()) {
                data.add(new Tuple2<>(s, m.get(s)));
            }
            JavaPairRDD<String, Object> originRDD = javaSparkContext.parallelizePairs(data);
            result2.add(originRDD.collectAsMap());
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<TiyuyongpinEntity> ew = new EntityWrapper<TiyuyongpinEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = tiyuyongpinService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<TiyuyongpinEntity> ew = new EntityWrapper<TiyuyongpinEntity>();
        List<Map<String, Object>> result = tiyuyongpinService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        List<Map<String, Object>> result2 = new ArrayList<Map<String,Object>>();
        for(Map<String, Object> m : result) {
            List<Tuple2<String, Object>> data = new ArrayList<>();
            for(String s : m.keySet()) {
                data.add(new Tuple2<>(s, m.get(s)));
            }
            JavaPairRDD<String, Object> originRDD = javaSparkContext.parallelizePairs(data);
            result2.add(originRDD.collectAsMap());
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<TiyuyongpinEntity> ew = new EntityWrapper<TiyuyongpinEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = tiyuyongpinService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<TiyuyongpinEntity> ew = new EntityWrapper<TiyuyongpinEntity>();
        List<Map<String, Object>> result = tiyuyongpinService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        List<Map<String, Object>> result2 = new ArrayList<Map<String,Object>>();
        for(Map<String, Object> m : result) {
            List<Tuple2<String, Object>> data = new ArrayList<>();
            for(String s : m.keySet()) {
                data.add(new Tuple2<>(s, m.get(s)));
            }
            JavaPairRDD<String, Object> originRDD = javaSparkContext.parallelizePairs(data);
            result2.add(originRDD.collectAsMap());
        }
        return R.ok().put("data", result2);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,TiyuyongpinEntity tiyuyongpin, HttpServletRequest request){
        EntityWrapper<TiyuyongpinEntity> ew = new EntityWrapper<TiyuyongpinEntity>();
        int count = tiyuyongpinService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tiyuyongpin), params), params));
        return R.ok().put("data", count);
    }



}
