package ssm.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ssm.blog.entity.BlogType;

@Mapper
public interface BlogTypeDao {

	/**
	 * 添加博客类别信息
	 * @param blogType
	 * @return
	 */
	Integer addBlogType(BlogType blogType);
	
	/**
	 *  删除博客类别信息
	 * @param id
	 * @return
	 */
	Integer deleteBlogType(Integer id);
	
	/**
	 * 更新博客类别信息
	 * @param blogType
	 * @return
	 */
	Integer updateBlogType(BlogType blogType);
	
	/**
	 * 根据id查询博客类别信息
	 * @param id
	 * @return
	 */
	BlogType getBlogTypeById(Integer id);
	
	/**
	 * 分页查询博客类别信息
	 * @param start
	 * @param end
	 * @return
	 */
	List<BlogType> listBlogType(@Param("start") Integer start,@Param("end") Integer end);
	
	/**
	 * 查询总记录数
	 * @return
	 */
	Long getTotal();
}
