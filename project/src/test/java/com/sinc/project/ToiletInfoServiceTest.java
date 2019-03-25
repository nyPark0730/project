package com.sinc.project;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sinc.project.model.vo.ToiletUseInfoVO;
import com.sinc.project.service.ToiletInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ToiletInfoServiceTest {

	
	  @Resource(name="toiletInfoService") 
	  private ToiletInfoService toiletInfoService;
	  
	  @Test
	  public void getTotalToiletUseInfoTest() {
		  List<Object> list = toiletInfoService.getTotalToiletUseInfo();
		  assertNotNull(list);
	  }
	  
	  @Test
	  public void getToiletUseInfoByGenderTest() {
		  List<Object> list = toiletInfoService.getToiletUseInfoByGender("F");
		  assertNotNull(list);
	  }

	  @Test
	  public void getToiletUseInfoTest() {
		  List<Object> list = toiletInfoService.getToiletUseInfo(9, "M");
		  assertNotNull(list);
	  }
	  
	  @Test
	  public void updateToiletUseInfoTest() {
		 int updateResult = toiletInfoService.updateToiletUseInfo(24, "N");
		 System.out.println("updateResult " + updateResult);
	  }

	  
}
