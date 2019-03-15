package com.hsy.platform.controller;

import com.hsy.platform.entity.Page;
import com.hsy.platform.entity.PageData;
import com.hsy.platform.util.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseRestController {

    public static final String SAVE_SUCCESS = "保存成功";
    public static final String SAVE_FAILURE = "保存失败";
    public static final String UPDATE_SUCCESS = "更新成功";
    public static final String UPDATE_FAILURE = "更新失败";
    public static final String DELETE_SUCCESS = "删除成功";
    public static final String DELETE_FAILURE = "删除失败";

    protected Logger log = LoggerFactory.getLogger(getClass());

    public BaseRestController() {
        Logger log = LoggerFactory.getLogger(BaseRestController.class);
        log.debug("controller:" + getClass().getSimpleName() + "Controller已加载");
    }

    public Map<String, Object> getResultMap(boolean res, String msg) {
        HashMap<String, Object> map = new HashMap();
        map.put("res", Boolean.valueOf(res));
        map.put("msg", msg);
        return map;
    }


    public Map<String, Object> getDataMap(boolean res, Object data, Page page) {
        HashMap<String, Object> map = new HashMap();
        if(res){
            map.put("code",0);
        }
        map.put("res",res);
        if(page != null){
            map.put("count",page.getTotal());
        }
        map.put("data", data);
        return map;
    }

    public Map<String, Object> getDataMap(boolean res, Object data) {
        HashMap<String, Object> map = new HashMap();
        if(res){
            map.put("code",0);
        }
        map.put("res",res);
        map.put("data", data);
        return map;
    }

    /**
     * 得到PageData
     */
    public PageData getPageData(){
        return new PageData(this.getRequest());
    }

    /**
     * 得到request对象
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    public HttpServletResponse getResponse() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        return response;
    }

    /**
     * 得到32位的uuid
     * @return
     */
    public String get32UUID(){

        return UuidUtil.get32UUID();
    }

    /**
     * 得到分页列表的信息
     */
    public Page getPage(){

        return new Page();
    }

}
