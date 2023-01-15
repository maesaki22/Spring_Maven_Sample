package com.springtest.study.mboard.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springtest.study.mboard.board.model.Board;
import com.springtest.study.mboard.board.model.BoardSearch;
import com.springtest.study.mboard.board.service.IBoardService;

@Controller
public class MainController {
	
	@Autowired
	IBoardService iBoardService;
	
	//private Logger logger = LoggerFactory.getLogger(MainController.class);
	
	// Dao를 최종적으론 Service에서 관리하기위해서 controller에선 지운다.
	//@Autowired
	//IBoardDao iBoardDao;
	
	//   mainIndex(@RequestParam(defaultValue="subject") String  searchType,  해당 @ 사용방식은 post방식에선 권장하지 않습니다.
//	@RequestMapping("/index")
//	public String mainIndex(@RequestParam(name="searchType",required=true, defaultValue="subject") String searchType,
//			@RequestParam(name="searchCondition",required=true, defaultValue="equal") String searchCondition,
//			@RequestParam(name="searchKeyword",required=true, defaultValue="") String searchKeyword,
//			HttpServletRequest request , Model model) {
	// 위의 RequestParam의 3가지 값( searchType , searchCondition , searchKeyword ) 는 모두 BoardSearch Model의 값이다
	// 즉 , 간단하게 BoardSearch를 파라미터로 받으면 자동으로 매핑이 된다.
	@RequestMapping("/index")
	public String mainIndex(BoardSearch boardSearch , HttpServletRequest request , Model model) {		
		String searchType = boardSearch.getSearchType();
		if (searchType.isEmpty()) {
			boardSearch.setSearchType("subject");
		}
		String searchCondition = boardSearch.getSearchCondition();
		if (searchCondition.isEmpty()) {
			boardSearch.setSearchCondition("equal");
		}
		String searchKeyword = boardSearch.getSearchKeyword();
		
		boardSearch.setSearchKeyword(searchKeyword.trim());		
		List<Board>  boardList = iBoardService.selectBoardList(boardSearch);
		System.out.println("boardSearch after : " + boardSearch.getPagenation().getRecordTotalCount());
		model.addAttribute("boardSearch", boardSearch);
		model.addAttribute("boardList", boardList);
		return "main";
	}
	 
	
	@RequestMapping("/default")
	public String defaultIndex(HttpServletRequest request, Model model) {
		
		// MariaDB JDBC Driver 로드 테스트 하기
		try {
			Class<?> dbDriver = Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("마리아디비 드라이버(" + dbDriver.toString() + ")가 로딩됨");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("마리아디비 드라이버가 로딩되지 않음");
		}
		
		
//		// MariaDB 접속 테스트 하기  
//		Connection Oconnection = null;
//		String databaseConn = "jdbc:mariadb://localhost:3306/mboard";
//		
//		try {
//			Oconnection =  DriverManager.getConnection(databaseConn, "root", "1234");
//			System.out.println("마리아디비에 연결됨");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("마리아디비에 연결하지 못함");
//		} finally {
//			if (null != Oconnection) {
//				try {
//					Oconnection.close();
//					System.out.println("마리아디비에서 연결을 종료함");
//				} catch (SQLException e) { 
//					e.printStackTrace();
//					System.out.println("마리아디비에서 연결을 종료하지 못함");
//				}
//			}
//		}	
//		
//		//DataSource 테스트 하기 ( xml에 설정해둔 db를 사용하기위한 테스트코드)
//		Connection connection = null;
//		try {
//			connection = dataSource.getConnection();
//			System.out.println("DataSource 마리아디비에 연결됨");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("DataSource 마리아디비 드라이버가 로딩되지 않음");
//		} finally {
//			if (null != connection) {
//				try {
//					connection.close();
//					System.out.println("DataSource 마리아디비에서 연결을 종료함");
//				} catch (SQLException e) {
//					e.printStackTrace();
//					System.out.println("DataSource 마리아디비에서 연결을 종료하지 못함");
//				}
//			}
//		}		
//		
		List<String> sList = new ArrayList<String>();
		sList.add("spring maven project sample start");
		sList.add("spring framework / servlet");
		sList.add("jstl(taglibs) / sitemesh");
		sList.add("mariaDB / spring JDBC / mybatis / mybatis-spring");
		model.addAttribute("boardList", sList);
		return "main";
	}
}
