package ssm.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/blog")
public class BloggerController {

//	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("=========================================");
		return "/admin/menu/menu";
	}
}
