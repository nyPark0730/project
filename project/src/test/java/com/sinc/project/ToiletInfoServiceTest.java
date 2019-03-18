package com.sinc.project;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
	  public void getToiletUseInfoTest() {
		  List<Object> list = toiletInfoService.getToiletUseInfo(9);
		  assertNotNull(list);
	  }
	  
	  @Test
	  public void updateToiletUseInfoTest() {
		 int updateResult = toiletInfoService.updateToiletUseInfo(25, "Y");
		 System.out.println("updateResult " + updateResult);
	  }

	  
}
