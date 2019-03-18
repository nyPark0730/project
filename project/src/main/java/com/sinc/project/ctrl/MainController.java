package com.sinc.project.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.project.service.ToiletInfoService;

@Controller
public class MainController {

	@Resource(name="toiletInfoService")
	private ToiletInfoService toiletInfoService;
	
	
	@RequestMapping(value="/getTotalToiletUseInfo.do", method=RequestMethod.POST)
	@ResponseBody
	public List<Object> getTotalToiletUseInfo () {
		
		System.out.println("getTotalToiletUseInfo Controller");
		List<Object> result = toiletInfoService.getTotalToiletUseInfo();
  		System.out.println(result);
  		
		return result;
	}
	
	@RequestMapping(value="/getToiletUseInfo.do", method=RequestMethod.POST)
	@ResponseBody
	public List<Object> getToiletUseInfo (int floor) {
		
		System.out.println("getToiletUseInfo Controller");
		System.out.println("floor "+ floor);
		List<Object> result = toiletInfoService.getToiletUseInfo(floor);
		System.out.println(result);
		return result;
	}
	
	@RequestMapping(value="/updateToiletUseInfo.do", method=RequestMethod.POST)
	@ResponseBody
	public int updateToiletUseInfo (int code, String useyn) {
		
		System.out.println("updateToiletUseInfo Controller");
		System.out.println("code "+ code);
		System.out.println("useyn "+ useyn);
		
		return toiletInfoService.updateToiletUseInfo(code, useyn);
	}
}
