package com.service.impl;
/**
 * 
 */
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.NewsDao;
import com.entity.NewsEntity;
import com.service.NewsService;
import com.entity.vo.NewsVO;
import com.entity.view.NewsView;

/**
 * 服务类
 * 提供了对新闻数据的查询和操作服务
 */
@Service("newsService")
public class NewsServiceImpl extends ServiceImpl<NewsDao, NewsEntity> implements NewsService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
    	/**
    	 * 用于查询新闻数据并进行分页处理
    	 * 使用了MyBatis-Plus提供的selectPage方法进行新闻数据的查询和分页处理
    	 * Query类用于从请求参数中获取分页信息，并将其封装到Page对象中
    	 * EntityWrapper类用于设置查询条件和排序方式
    	 * 然后，将查询结果封装到PageUtils对象中，并返回给调用方
    	 */
        Page<NewsEntity> page = this.selectPage(
                new Query<NewsEntity>(params).getPage(),
                new EntityWrapper<NewsEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NewsEntity> wrapper) {
		  Page<NewsView> page =new Query<NewsView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    
    /**
     * 这些方法用于查询新闻数据并返回相应的视图对象或值对象
     */
    @Override
	public List<NewsVO> selectListVO(Wrapper<NewsEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public NewsVO selectVO(Wrapper<NewsEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<NewsView> selectListView(Wrapper<NewsEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NewsView selectView(Wrapper<NewsEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
