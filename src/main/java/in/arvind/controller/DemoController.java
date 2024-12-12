package in.arvind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
	
	@GetMapping("/demo4")
	public String getMsg4() {
		return "index";
	}
	
	@GetMapping("/demo3")
	@ResponseBody
	public String getMsg3() {
		return "Java Developer";
	}
	
	@GetMapping("/demo2/{name}")
	public ModelAndView getMsg2(@PathVariable("name") String name) {
		String text="Good Morning.. "+name;
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg",text);
		mav.setViewName("index");
		return mav;
	}
	
	
	@GetMapping("/demo1")
	public ModelAndView getMsg1(@RequestParam("name") String name) {
		String text="Hello"+name;
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg",text);
		mav.setViewName("index");
		return mav;
	}

}
