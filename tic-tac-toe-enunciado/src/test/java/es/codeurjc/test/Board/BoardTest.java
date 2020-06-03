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
	  
	 /* @Test
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
		  
		  
	  }*/
	
	@Test
	public void BoardTest_CheckDraw_And_GetCellsIfWinner_Empate() {
		//CASO DE QUE HAYA EMPATE
		//GIVEN
		String jugador1 = "X";
		String jugador2= "O";
		
		int[] posJugador1= {0,2,5,6,7};
		int[] posJugador2= {1,3,4,8};
		board.setValue(posJugador1,jugador1);
		board.setValue(posJugador2,jugador2);
		
		//WHEN
		boolean empate= board.checkDraw();
		int [] res2 = board.getCellsIfWinner(jugador1);
		int [] res3= board.getCellsIfWinner(jugador2);
		
		assertNull(res3);
		assertNull(res2);
		assertTrue(empate);
	}

	@Test
	public void BoardTest_CheckDraw_And_GetCellsIfWinner_GanaX() {
		
		//CASO DE QUE GANE EL JUGADOR 1
		
		//GIVEN
		String jugador1 = "X";
		String jugador2= "O";
		int[] posJugador1= {0,1,3,2};
		int[] posJugador2= {8,4,5};
		board.setValue(posJugador1,jugador1);
		board.setValue(posJugador2,jugador2);
		
		/*board.setValue(0, jugador1);
		board.setValue(1, jugador2);
		board.setValue(2, jugador1);
		board.setValue(4, jugador2);
		board.setValue(3, jugador1);
		board.setValue(5, jugador2);
		board.setValue(6, jugador1);*/
		
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
	
public void BoardTest_CheckDraw_And_GetCellsIfWinner_GanaO() {
		
		//CASO DE QUE NO HAYA EMPATE
		
		//GIVEN
		String jugador1 = "X";
		String jugador2= "O";
		
		int[] posJugador1= {0,2,6};
		int[] posJugador2= {3,4,5};
		board.setValue(posJugador1,jugador1);
		board.setValue(posJugador2,jugador2);
		
		/*board.setValue(0, jugador1);
		board.setValue(3, jugador2);
		board.setValue(2, jugador1);
		board.setValue(4, jugador2);
		board.setValue(6, jugador1);
		board.setValue(5, jugador2);*/
		
		
		//WHEN
		int [] expected2= {0,3,6};
		int [] res1= board.getCellsIfWinner(jugador1);
		int [] res2= board.getCellsIfWinner(jugador2);
		boolean empate= board.checkDraw();
	
		assertNull(res1);
		assertArrayEquals(res2,expected2);
		assertFalse(empate);
	}
	
	@Test
	public void BoardTestCellsWinnerGanaX() {
		
		//CASO DE QUE HAYA GANADO JUGADOR 1 PERDIDO JUGADOR 2 
		
		//GIVEN
		String jugador1 = "X";
		String jugador2= "O";
		
		int[] posJugador1= {0,1,2};
		int[] posJugador2= {3,4};
		board.setValue(posJugador1,jugador1);
		board.setValue(posJugador2,jugador2);
		
		/*board.setValue(0, jugador1);
		board.setValue(3, jugador2);
		board.setValue(1, jugador1);
		board.setValue(4, jugador2);
		board.setValue(2, jugador1);*/
		
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
public void BoardTestCellsWinnerGana0() {
		
		//CASO DE QUE HAYA GANADO JUGADOR 2 Y PERDIDO JUGADOR 1
		
		//GIVEN
		String jugador1 = "X";
		String jugador2= "O";
		
		int[] posJugador1= {1,4,5};
		int[] posJugador2= {0,3,6};
		board.setValue(posJugador1,jugador1);
		board.setValue(posJugador2,jugador2);
		
		/*board.setValue(1, jugador1);
		board.setValue(0, jugador2);
		board.setValue(4, jugador1);
		board.setValue(3, jugador2);
		board.setValue(5, jugador1);
		board.setValue(6, jugador2);*/
		
		
		//WHEN     //THEN
			int [] expected2= {0,3,6};
			
			int [] res1= board.getCellsIfWinner(jugador1);
			int [] res2= board.getCellsIfWinner(jugador2);
			
			boolean empate= board.checkDraw();
		
			assertNull(res1);
			assertArrayEquals(res2,expected2);
			
			assertFalse(empate);
	}
	
	@Test
	public void BoardTestCellsEmpate() {
		String jugador1 = "X";
		String jugador2= "O";

		int[] posJugador1= {0,2,5,6,7};
		int[] posJugador2= {1,3,4,8};
		board.setValue(posJugador1,jugador1);
		board.setValue(posJugador2,jugador2);
		
		int [] res = board.getCellsIfWinner(jugador1);
		int [] res2 = board.getCellsIfWinner(jugador2);
		
		assertNull(res);
		assertNull(res2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
