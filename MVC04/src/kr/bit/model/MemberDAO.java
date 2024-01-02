package kr.bit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//JDBC-> myBatis, JPA (db 커넥터)
public class MemberDAO {
	// 데이터베이스를 연결할 객체 Connection
	private Connection conn;
	// 데이베이스를 전송할 객체  PreparedStatement
	private PreparedStatement ps;
	// PreparedStatement 객체에서 가져온 결과 집합을 보관할 객체 ResultSet
	private ResultSet rs;
	
	//데이터베이스 연결객체 생성
	public void getConnect() {
		String URL="jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTImeZone=UTC";
		String user = "root";
		String password = "admin12345";
		// Mysql Driver Loading
		
		try {
			//메모리 동적로딩(실행지점에서 객체를 생성하는 방법)
			//drier="com.mysql.jdbc.Driver"
			//위와 같이 변수값에 할당하여 class.forname 형식의 동적로딩하면
			//driver의 DB가 변동되더라도 실행지점에서 객체를 생성하기 때문에 다른 DB로 전환이 쉽다. 
			Class.forName("com.mysql.jdbc.Driver");
			// Driver driver = new com.mysql.jdbc.Driver();
			// conn =dirver.getConnection(URL, user, password);
			
			conn=DriverManager.getConnection(URL,user,password);
			
		} catch (Exception e) {
			//
			e.printStackTrace();
		}
	}
		//회원저장 동작
		public int memberInsert(MemberVO vo) {
			// ?(파라메터)
			String SQL = "insert into member(id, pass, name, age, email, phone) values(?,?,?,?,?,?)";
			getConnect();
			
			int cnt = -1;
			//SQL문장을 전송하는 객체 생성
			try {
				ps=conn.prepareStatement(SQL); // 미리 컴파일을 시킨다.(속도가 빠름)
				ps.setString(1,  vo.getId());
				ps.setString(2,  vo.getPass());
				ps.setString(3,  vo.getName());
				ps.setInt(4,  vo.getAge());
				ps.setString(5,  vo.getEmail());
				ps.setString(6,  vo.getPhone());
				
			    //성공하면 1, 실패하면 0으로 리턴
				cnt = ps.executeUpdate(); //전송(실행)
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				dbClose();
			}
			return cnt;
			
			
	}

	//회원(VO) 전체 리스트(ArrayList) 가져오기
	public ArrayList<MemberVO> memberList() {
		String SQL="select * from member";
		getConnect();
		ArrayList<MemberVO> list=new ArrayList<MemberVO>();
		try {
			ps=conn.prepareStatement(SQL);
			rs =ps.executeQuery(); 
			// rs -> 처음에는 컬럼명을 커서로 카리킨다. 
			// netx() -> next 함수로 다음 데이터로 이동하여 데이터가 없다면 멈춘다.
			while(rs.next()) {
				int num=rs.getInt("num");
				String id= rs.getString("id");
				String pass= rs.getString("pass");
				String name = rs.getString("name");
				int age= rs.getInt("age");
				String email= rs.getString("email");
				String phone= rs.getString("phone");
				//묶고 -> 담고
				
				MemberVO vo = new MemberVO(num, id, pass, name, age, email, phone);
				
				list.add(vo);
				
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			dbClose();
		}
		return list;
	}
	
	//meberDelete
	public int memberDelete(int num) {
		String SQL = "delete from member where num=?";
		getConnect();
		int cnt = 1;
		try {
			ps=conn.prepareStatement(SQL);
			ps.setInt(1,  num);
			cnt=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	//MemberContent
	
	public MemberVO memberContent(int num) {
		String SQL = "select * from member where num =?";
		getConnect();
		int cnt = -1;
		MemberVO vo = null;
		try {
			ps=conn.prepareStatement(SQL);
			ps.setInt(1,  num);
			rs=ps.executeQuery();
			if (rs.next()) {
				//해당 데이터를 찾았다면 VO로 묶는다.
				num=rs.getInt("num");
				String id= rs.getString("id");
				String pass= rs.getString("pass");
				String name = rs.getString("name");
				int age= rs.getInt("age");
				String email= rs.getString("email");
				String phone= rs.getString("phone");
				vo = new MemberVO(num, id, pass, name, age, email, phone);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return vo;
		
	
		
	}
	// 데이터베이스 업데이트
	public int memberUpdate(MemberVO vo) {
		String SQL = "update member set age=?, email=?, phone=? where num=?";
		getConnect();
		int cnt = -1;
		try {
			ps=conn.prepareStatement(SQL);
			ps.setInt(1,  vo.getAge());
			ps.setString(2,  vo.getEmail());
			ps.setString(3,  vo.getPhone());
			ps.setInt(4,  vo.getNum());
			cnt = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	

	
	// 데이터 베이스 연결 끊기 리소스 축소
	public void dbClose() {
		try {
		if(rs!=null) rs.close();
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
