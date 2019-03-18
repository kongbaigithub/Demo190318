package ssm.blog.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ssm.blog.entity.BlogType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-beans.xml"})
public class BlogTypeDaoTest {

	@Autowired
	private BlogTypeDao blogTypeDao;
	
	@Test
	public void testAddBlogType() {
		for(int i=0;i<100;i++) {
			
			BlogType blogType = new BlogType("Mysql"+i,i);
			int result = blogTypeDao.addBlogType(blogType);
			System.out.println(result);
		}

	}

	@Test
	public void testDeleteBlogType() {
		int result = blogTypeDao.deleteBlogType(16);
		System.out.println(result);
	}

	@Test
	public void testUpdateBlogType() {
		BlogType blogType = new BlogType(17,"Orcle",12);
        int result = blogTypeDao.updateBlogType(blogType);
        System.out.println(result);
	}

	@Test
	public void testGetBlogTypeById() {
		BlogType blogType = blogTypeDao.getBlogTypeById(50);
		System.out.println(blogType);
	}

	@Test
	public void testListBlogType() {
		List<BlogType> blogTypes = blogTypeDao.listBlogType(20, 30);
		System.out.println(blogTypes);
	}

	@Test
	public void testGetTotal() {
		Long l = blogTypeDao.getTotal();
		System.out.println(l);
	}

}
