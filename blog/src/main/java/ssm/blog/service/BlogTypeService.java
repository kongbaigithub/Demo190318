package ssm.blog.service;

import ssm.blog.entity.BlogType;
import ssm.blog.entity.PageBean;

public interface BlogTypeService {

	//分页查询
	PageBean<BlogType> listByPage(PageBean<BlogType> pageBean);
	
	//新增博客类别
	public Integer addBlogType(BlogType blogType);
	//更新博客类别
	public Integer updateBlogType(BlogType blogType);
	//删除博客
	public void deleteBlogType(Integer id);
}
