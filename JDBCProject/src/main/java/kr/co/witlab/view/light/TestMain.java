package kr.co.witlab.view.light;

import java.util.List;

import kr.co.witlab.test.biz.light.LightDAO;
import kr.co.witlab.test.biz.light.LightVO;

public class TestMain {

	public static void main(String[] args) {
		
		LightDAO lightDAO = new LightDAO();
		
		LightVO vo = new LightVO();
		vo.setTime("2016-02-01 12:00");
		vo.setLux(1000.0);
		vo.setCct(1000.0);
		vo.setX(0.5);
		vo.setY(0.5);
		
		lightDAO.updateLight(vo);
		
		
		
//		LightVO vo = new LightVO(); // 비어있는 상태
//		vo.setTime("2016-02-01 13:00");
//		vo.setLux(200.0);
//		vo.setCct(200.0);
//		vo.setX(0.2);
//		vo.setY(0.2);
//		
//		lightDAO.insertLight(vo);
	}

}
