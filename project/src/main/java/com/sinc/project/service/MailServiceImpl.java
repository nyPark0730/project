package com.sinc.project.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.sinc.project.model.sql.MailDao;
import com.sinc.project.model.vo.KeywordVO;
import com.sinc.project.model.vo.MailVO;
import com.sinc.project.model.vo.MemberVO;
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
	 * 키워드 삭제 후 조회
	 */
	@Override
	public int deleteKeyword(String memberSeq, String keyword) {
		KeywordVO keywordVo = new KeywordVO();
		keywordVo.setMemberseq(memberSeq);
		keywordVo.setKeyword(keyword);
		return mailDao.deleteKeyword(keywordVo);
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
	public void sendFCM(MemberVO senderInfo, String recipient, String title, int mailSeq) {
		TokenVO memberTokenVo = getTokenInfo(recipient);
		String memberSeq = memberTokenVo.getMemberseq();
		String memberToken = memberTokenVo.getToken();
         
		JSONObject pushJobj = new JSONObject();
		JSONObject jObjNotification = new JSONObject();
		jObjNotification.put("title", mailSeq + "/" + senderInfo.getMembername() + "담당 (" + senderInfo.getTeam() + "팀)");
		jObjNotification.put("body", title);
		
		JSONObject jObjData = new JSONObject();
		jObjData.put("mailseq", mailSeq);
		jObjData.put("title", senderInfo.getMembername() + " 담당 (" + senderInfo.getTeam() + "팀)");
		jObjData.put("body", title);
		jObjData.put("clickAction", "MAILDETAILACTIVITY");
		pushJobj.put("notification", jObjNotification);
		pushJobj.put("to", memberToken);
		pushJobj.put("click_action", "MAILDETAILACTIVITY");
		pushJobj.put("data", jObjData);
		
		String pushInfo = pushJobj.toString();
		System.out.println(pushInfo);
		
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
	        System.out.println("Post parameters : " + pushInfo);
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
		System.out.println("title "+title);
		for (Object keywordvo : keywordList) {
			String keyword = ((KeywordVO)keywordvo).getKeyword();
			if (title.contains(keyword)) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public Object getMemberInfo(String sender) {
		return mailDao.getMemberInfo(sender);
	}

	@Override
	public Object getMail(int mailseq) {
		MailVO mailVo = new MailVO();
		mailVo.setMailseq(mailseq);
		return mailDao.getMail(mailVo);
	}

}