package com.hsy.platform.service;



import com.hsy.platform.dao.DaoSupport;
import com.hsy.platform.entity.Page;
import com.hsy.platform.entity.PageData;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public abstract class BaseService {

    @Resource(name = "DaoSupport")
    private DaoSupport dao;

    /**
     * 新增记录
     * @param pageData
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void save(PageData pageData)throws Exception {
        dao.save(getMapperName()+".save", pageData);
    }

    /**
     * 批量新增
     * @param pdList
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void batchSave(List<PageData> pdList)throws Exception {
        dao.batchSave(getMapperName()+".batchSave", pdList);
    }

    /**
     * 更新记录
     * @param pd
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void update(PageData pd)throws Exception {
        dao.update(getMapperName()+".update", pd);
    }


    /**
     * 通过id获取单个数据
     * @param pd
     * @return
     * @throws Exception
     */
    public PageData getById(PageData pd) throws Exception {
        return (PageData) dao.queryPageDataByKey(getMapperName()+".getById", pd);
    }

    /**
     * 获取分页数据
     * @param page
     * @return
     * @throws Exception
     */
    public Page listPage(Page page) throws Exception {
        PageData pd = page.getPd();
        pd.setPage(page);
        List<PageData>  dataList = dao.queryPageDataListByKey(getMapperName()+".listPage", pd);
        page.setRows(dataList);
        page.setTotal(pd.getPage().getTotal());
        return page;
    }


    /**
     * 获取分页数据
     * @param page
     * @return
     * @throws Exception
     */
    public Page listPageByKey(Page page, String key) throws Exception {
        PageData pd = page.getPd();
        pd.setPage(page);
        List<PageData> dataList = dao.queryPageDataListByKey(key, pd);
        page.setRows(dataList);
        page.setTotal(pd.getPage().getTotal());
        return page;
    }

    /**
     * 获取查询数据
     * @param pd
     * @return
     * @throws Exception
     */
    public List<PageData> getPageDataList(PageData pd) throws Exception {
        return  dao.queryPageDataListByKey(getMapperName()+".getList", pd);
    }

    /**
     * 查询数量
     * @param pd
     * @return
     * @throws Exception
     */
    public PageData findCount(PageData pd) throws Exception {
        return (PageData) dao.queryPageDataByKey(getMapperName()+".findCount", pd);
    }

    /**
     * 删除记录
     * @param pd
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void delete(PageData pd) throws Exception {
        dao.delete(getMapperName()+".delete", pd);
    }

    /**
     * 批量删除
     * @param pdList
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void batchDelete(List<PageData> pdList) throws Exception {
        dao.batchDelete(getMapperName()+".delete", pdList);
    }

    /**
     * 获取mapList
     * @param pd
     * @return
     * @throws Exception
     */
    public List<Map<String, Object>> getMapList(PageData pd) throws Exception {
        return dao.queryMapListByKey(getMapperName()+".getList",pd);
    }

    /**
     * 获取mybatis 命名空间
     * @return
     */
     public  abstract String getMapperName();

    public DaoSupport getDao() {
        return dao;
    }
}
