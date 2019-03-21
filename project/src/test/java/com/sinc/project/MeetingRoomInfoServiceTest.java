package com.sinc.project;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sinc.project.service.MeetingRoomInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MeetingRoomInfoServiceTest {

	
	  @Resource(name="meetingRoomInfoService") 
	  private MeetingRoomInfoService meetingRoomInfoService;
	  
	  @Test
	  public void getTotalMeetingRoomUseInfoTest() {
		  List<Object> list = meetingRoomInfoService.getTotalMeetingRoomUseInfo();
		  assertNotNull(list);
	  }
	  
	  @Test
	  public void getMeetingRoomUseInfoTest() {
		  List<Object> list = meetingRoomInfoService.getMeetingRoomUseInfo(9);
		  assertNotNull(list);
	  }
	  
	  @Test
	  public void updateToiletUseInfoTest() {
		 int updateResult = meetingRoomInfoService.updateMeetingRoomUseInfo(10, "N");
		 System.out.println("updateResult " + updateResult);
	  }

	  
}
