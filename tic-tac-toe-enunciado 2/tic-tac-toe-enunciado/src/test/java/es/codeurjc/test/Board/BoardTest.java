package es.codeurjc.test.Board;



import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import es.codeurjc.ais.tictactoe.TicTacToeGame;

import es.codeurjc.ais.tictactoe.Board;


public class BoardTest {
	
	private Board board;
	
	  @BeforeEach
	  public void setUp() {
	    board = new Board();
	    
	  }
	  
	  @Test
	  public void CeldasHabilitadas() {
		  
		  board.enableAll();
		  
		  boolean res= false;
		  
		  for (int id= 0; id<9;id++){
			res= board.setActive(id, true);
		  }
		  
		  assertTrue(res);
		  
		  
	  }
	  @Test
	  public void CeldasDeshabilitadas() {
		  
		  board.disableAll();;
		  
		  boolean res= false;
		  
		  for (int id= 0; id<9;id++){
			res= board.setActive(id, false);
		  }
		  
		  assertFalse(res);
		  
		  
	  }
	
	@Test
	public void BoardTestEmpate() {
		//CASO DE QUE HAYA EMPATE
		//GIVEN
		String jugador1 = "X";
		String jugador2= "O";
		
		for (int i= 0; i<8; i++){
			board.setValue(i, jugador1);
			board.setValue(i+1, jugador2);
		}
		//WHEN
		boolean res= board.checkDraw();
		
		//THEN
		assertTrue(res);
	}

	@Test
	public void BoardTestGanaX() {
		
		//CASO DE QUE GANE EL JUGADOR 1
		
		//GIVEN
		String jugador1 = "X";
		String jugador2= "O";
		board.setValue(0, jugador1);
		board.setValue(1, jugador2);
		board.setValue(2, jugador1);
		board.setValue(4, jugador2);
		board.setValue(3, jugador1);
		board.setValue(5, jugador2);
		board.setValue(6, jugador1);
		
		//WHEN
		boolean res= board.checkDraw();
		
		//THEN
		assertFalse(res);
		
	}
	
public void BoardTestNoEmpate() {
		
		//CASO DE QUE NO HAYA EMPATE
		
		//GIVEN
		String jugador1 = "X";
		String jugador2= "O";
		board.setValue(0, jugador1);
		board.setValue(1, jugador2);
		board.setValue(2, jugador1);
		board.setValue(4, jugador2);
		board.setValue(3, jugador1);
		board.setValue(7, jugador2);
		
		
		//WHEN
		boolean res= board.checkDraw();
		
		//THEN
		assertFalse(res);
		
	}
	
	@Test
	public void BoardTestCellsWinner() {
		
		//CASO DE QUE HAYA GANADO JUGADOR 1 PERDIDO JUGADOR 2 
		
		//GIVEN
		String jugador1 = "X";
		String jugador2= "O";
		board.setValue(0, jugador1);
		board.setValue(3, jugador2);
		board.setValue(1, jugador1);
		board.setValue(4, jugador2);
		board.setValue(2, jugador1);
		
		//WHEN
		int [] expected1 = { 0, 1, 2 };
		
		int [] res1= board.getCellsIfWinner(jugador1);
		int [] res2= board.getCellsIfWinner(jugador2);
		boolean empate= board.checkDraw();
		//THEN
		
			assertArrayEquals(res1,expected1);
			assertNull(res2);
			
			assertFalse(empate);
			
	}
	
	@Test
public void BoardTestNotCellsWinner() {
		
		//CASO DE QUE HAYA GANADO JUGADOR 2 Y PERDIDO JUGADOR 1
		
		//GIVEN
		String jugador1 = "X";
		String jugador2= "O";
		board.setValue(1, jugador1);
		board.setValue(0, jugador2);
		board.setValue(4, jugador1);
		board.setValue(3, jugador2);
		board.setValue(5, jugador1);
		board.setValue(6, jugador2);
		
		
		//WHEN     //THEN
			int [] expected2= {0,3,6};
			
			int [] res1= board.getCellsIfWinner(jugador1);
			int [] res2= board.getCellsIfWinner(jugador2);
			
			boolean empate= board.checkDraw();
		
			assertNull(res1);
			assertArrayEquals(res2,expected2);
			
			assertFalse(empate);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
