package com.sinc.project.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.ognl.Token;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.sinc.project.model.sql.MailDao;
import com.sinc.project.model.vo.KeywordVO;
import com.sinc.project.model.vo.MailVO;
import com.sinc.project.model.vo.TokenVO;

@Service("mailService")
public class MailServiceImpl implements MailService {

	@Resource(name="mailDao")
	private MailDao mailDao;

	/**
	 * 키워드 추가
	 */
	@Override
	public int addKeyword(String memberSeq, String keyword) {
		KeywordVO keywordVo = new KeywordVO();
		keywordVo.setMemberseq(memberSeq);
		keywordVo.setKeyword(keyword);
		return mailDao.addKeyword(keywordVo);
	}

	/**
	 * 키워드 조회
	 */
	@Override
	public List<Object> getKeyword(String memberSeq) {
		KeywordVO keywordVo = new KeywordVO();
		keywordVo.setMemberseq(memberSeq);
		return mailDao.getKeyword(keywordVo);
	}

	/**
	 * 메일 INSERT
	 */
	@Override
	public int addMail(MailVO mail) {
		return mailDao.addMail(mail);
	}

	/**
	 * 멤버별 토큰 추가/수정
	 */
	@Override
	public int mergeToken(String memberSeq, String token) {
		TokenVO tokenVo = new TokenVO();
		tokenVo.setMemberseq(memberSeq);
		tokenVo.setToken(token);
		return mailDao.mergeToken(tokenVo);
	}

	@Override
	public TokenVO getTokenInfo(String memberSeq) {
		TokenVO tokenVo = new TokenVO();
		tokenVo.setMemberseq(memberSeq);
		
		return mailDao.getTokenInfo(tokenVo);
	}

	@Override
	public void sendFCM(String recipient) {
		TokenVO memberTokenVo = getTokenInfo(recipient);
		String memberSeq = memberTokenVo.getMemberseq();
		String memberToken = memberTokenVo.getToken();
         
		JSONObject pushJobj = new JSONObject();
		JSONObject jObj = new JSONObject();
		jObj.put("title", "mailTestTitle");
		jObj.put("body", "mailTestContents");
		pushJobj.put("notification", jObj);
		pushJobj.put("to", memberToken);

		String pushInfo = pushJobj.toString();
		System.out.println(pushInfo);
		// 이렇게 보내면 주제를 ALL로 지정해놓은 모든 사람들한테 알림을 날려준다.
		//String input = "{\"notification\" : {\"title\" : \"여기다 제목 넣기 \", \"body\" : \"여기다 내용 넣기\"}, \"to\":\"/topics/ALL\"}";
         
		// 이걸로 보내면 특정 토큰을 가지고있는 어플에만 알림을 날려준다  위에 둘중에 한개 골라서 날려주자
		String input = "{\"notification\" : {\"title\" : \" aa \", \"body\" : \"ww\"}, \"to\":\""+memberToken+"\"}";
		System.out.println(input);
		try {
			final String apiKey = "AIzaSyDZ1-PtQzXbAF4Gysyivf684CcGRGIsqbI";
			URL url = new URL("https://fcm.googleapis.com/fcm/send");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "key=" + apiKey);


			conn.setDoOutput(true);
			
			OutputStream os = conn.getOutputStream();
			os.write(pushJobj.toString().getBytes("UTF-8"));
	        os.flush();
	        os.close();
	        
	        // 서버에서 날려서 한글 깨지는 사람은 아래처럼  UTF-8로 인코딩해서 날려주자
	        int responseCode = conn.getResponseCode();
	        System.out.println("\nSending 'POST' request to URL : " + url);
	        System.out.println("Post parameters : " + input);
	        System.out.println("Response Code : " + responseCode);
	         
	        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();

	        while ((inputLine = in.readLine()) != null) {
	        	response.append(inputLine);
	        }
	        in.close();
	        System.out.println(response.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	public boolean compareKeyword(String recipient, String title) {
		boolean flag = false;
		List<Object> keywordList = getKeyword(recipient);
		System.out.println("keywordList" + keywordList);
		
		for (Object keyword : keywordList) {
			
		}
		return flag;
	}
}