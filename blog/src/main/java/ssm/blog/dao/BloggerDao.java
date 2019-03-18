package ssm.blog.dao;

import org.apache.ibatis.annotations.Mapper;

import ssm.blog.entity.Blogger;
@Mapper
public interface BloggerDao {

	Blogger getBloggerData();
}
