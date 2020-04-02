package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTests {

		@Setter(onMethod_ = {@Autowired})
		private BoardService service;
		
		@Test
		public void testExist() {
			
			assertNotNull(service);
		}
		
		@Test
		public void testRegister() {
			
			BoardVO board = new BoardVO();
			
			board.setTitle("ss");
			board.setContent("dd");
			board.setWriter("dd");
			service.register(board);
		}
		
		@Test
		public void testGetList() {
		}
		
		@Test
		public void testGet() {
			
		}
		
		@Test
		public void testDelete() {
			
		}
		
		@Test
		public void testUpdate() {
			
			BoardVO board = service.get(1L);
			
			if(board == null) {
				return;
			}
			
			board.setTitle("gdgd");
		}
		
		
}
