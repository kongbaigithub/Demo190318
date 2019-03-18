package ssm.blog.controller.admin;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import ssm.blog.entity.BlogType;
import ssm.blog.entity.PageBean;
import ssm.blog.service.BlogTypeService;
import ssm.blog.utils.ResponseUtil;

@Controller
@RequestMapping("/admin/blogType")
public class BlogTypeController {

	@Autowired
	private BlogTypeService blogTypeService;
	
	// 分页查询博客类别
	@RequestMapping("/list")
	public String listBlogType(
			@RequestParam("page") String page,
			@RequestParam("rows") String rows,HttpServletResponse response) throws Exception {
		//定义分页bean
		PageBean<BlogType> pageBean = new PageBean<>(Integer.parseInt(page), Integer.parseInt(rows));
		//拿到分页结果已经记录总数的pageBean
		pageBean = blogTypeService.listByPage(pageBean);
		//使用阿里巴巴的fastJson创建JSONObject
		JSONObject result = new JSONObject();
		//通过fastJson序列化list为jsonArray
		String jsonArray = JSON.toJSONString(pageBean.getResult());
		JSONArray array = JSONArray.parseArray(jsonArray);
		//将序列化结果放入json对象中
		result.put("rows", array);
		result.put("total", pageBean.getTotal());
		//使用自定义工具类向response中写入数据
		ResponseUtil.write(response, result);	
		return null;
	}
	
	// 添加和更新博客类别
	@RequestMapping("/save")
	public String save(BlogType blogType,HttpServletResponse response) throws Exception {
		
		int resultTotal = 0;//接收返回结果记录数
		if(blogType.getId() == null) { // 说明是第一次插入
			resultTotal = blogTypeService.addBlogType(blogType);
		}else {
			resultTotal = blogTypeService.updateBlogType(blogType);
		}
		
		JSONObject json = new JSONObject();
		if(resultTotal > 0) {
			json.put("success", true);
		}else {
			json.put("success", false);
		}
		
		//使用自定义工具类向response中写入数据
		ResponseUtil.write(response, json);	
		return null;
	}
	
	//博客类别信息删除
	@RequestMapping("/delete")
	public String deleteBlogType(@RequestParam(value="ids",required=false) String ids,HttpServletResponse response) throws Exception {
		
		//分割字符串得到id数组
		String[] idsStr = ids.split(",");
		JSONObject result = new JSONObject();
		for(int i=0;i<idsStr.length;i++) {
			Integer id = Integer.parseInt(idsStr[i]);
			//其实在这里我们要判断该博客类别下面是否有博客 如果有就禁止删除博客类别 ，等我们完成博客对应的操作再来完善
			blogTypeService.deleteBlogType(id);
		}
		
		result.put("success", true);
	    ResponseUtil.write(response, result);

		return null;
	}
}
