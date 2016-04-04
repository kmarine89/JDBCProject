package kr.co.witlab.test.biz.light;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.witlab.test.biz.common.MysqlUtil;

public class LightDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	// SQL 관련 변수 선언
	private String LIGHT_INSERT = "insert into light(time, lux, cct, x, y) "
			+ "values (?, ?, ?, ?, ?)";
	private String LIGHT_UPDATE = "update light set lux=?, cct=? where time=?";
	private String LIGHT_DELETE = "delete light where time = ?";
	private String LIGHT_GET = "select * from light where time=?";
	private String LIGHT_LIST = "select * from light order by time";

	// CRUD 기능 구현 : 총 4개 메서드
	
	// (create) 데이터 삽입
	public void insertLight(LightVO vo) {
		try {
			conn = MysqlUtil.getConnection();
			stmt = conn.prepareStatement(LIGHT_INSERT);
			stmt.setString(1, vo.getTime());
			stmt.setDouble(2, vo.getLux());
			stmt.setDouble(3, vo.getCct());
			stmt.setDouble(4, vo.getX());
			stmt.setDouble(5, vo.getY());
			
			int cnt = stmt.executeUpdate();
			System.out.println(cnt + "데이터 삽입 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MysqlUtil.close(stmt, conn);
		}
	}
	
	// (read) 데이터 단일 검색
	public LightVO getLight(LightVO vo) {
		LightVO light = null;
		try {
			conn = MysqlUtil.getConnection();
			stmt = conn.prepareStatement(LIGHT_GET);
			stmt.setString(1, vo.getTime());
			rs = stmt.executeQuery();
			if(rs.next()) {
				light = new LightVO();
				light.setTime(rs.getString("DATE"));
				light.setLux(rs.getDouble("LUX"));
				light.setCct(rs.getDouble("CCT"));
				light.setX(rs.getDouble("X"));
				light.setY(rs.getDouble("Y"));
			}
			System.out.println("데이터 검색 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MysqlUtil.close(rs, stmt, conn);
		}
		return light;
	}

	// (read) 데이터 리스트 검색
	public List<LightVO> getLightList(LightVO vo) {
		List<LightVO> lightList = new ArrayList<LightVO>();
		try {
			conn = MysqlUtil.getConnection();
			stmt = conn.prepareStatement(LIGHT_LIST);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				LightVO light = new LightVO();
				light.setTime(rs.getString("TIME"));
				light.setLux(rs.getDouble("LUX"));
				light.setCct(rs.getDouble("CCT"));
				light.setX(rs.getDouble("X"));
				light.setY(rs.getDouble("Y"));
				lightList.add(light);
			}
			System.out.println(lightList.size() + " 데이터 검색 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MysqlUtil.close(rs, stmt, conn);
		}
		return lightList;
	}
	
	// (update) 데이터 수정
	public void updateLight(LightVO vo) {
		try {
			conn = MysqlUtil.getConnection();
			stmt = conn.prepareStatement(LIGHT_UPDATE);
			stmt.setDouble(1, vo.getLux());
			stmt.setDouble(2, vo.getCct());
			stmt.setString(3, vo.getTime());
			
			int cnt = stmt.executeUpdate();
			System.out.println(cnt + " 데이터 수정 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MysqlUtil.close(stmt, conn);
		}
	}
	
	// (delete) 데이터 삭제
	public void deleteLight(LightVO vo) {
		try {
			conn = MysqlUtil.getConnection();
			stmt = conn.prepareStatement(LIGHT_DELETE);
			stmt.setString(1, vo.getTime());
			
			int cnt = stmt.executeUpdate();
			System.out.println(cnt + " 데이터 삭제 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MysqlUtil.close(stmt, conn);
		}
	}
	
}
