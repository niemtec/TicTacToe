import java.util.Objects;

/**
 * This class contains all validation rules which determine the current state and/or result of the game.
 */

public class  Validation {
	//Method used to validate each move, checking if the winning condition is met, it announces win otherwise it checks for draw
	public static void checkMove(String lastIcon) {
		if (checkWin(lastIcon)) {
			//Indicate the game winner
			GameWindow.setIndicatorLabel(lastIcon + " won the game!");
			GameWindow.winnerDetectedMessage(lastIcon);
		} else {
			Validation.checkDraw();
			Main.movementCount++;
			GameWindow.updateTurnIndicatorLabel();
		}
	}

	//Method which checks for a win from the passed value (either X or O), if 3 in a row are found then a win is returned
	public static boolean checkWin(String value) {
		boolean winDetected;
		//Check all possible winning conditions and return true if a win is detected
		winDetected = (Main.gameGrid[0].contains(value) && Main.gameGrid[1].contains(value) && Main.gameGrid[2].contains(value))
				  || (Main.gameGrid[3].contains(value) && Main.gameGrid[4].contains(value) && Main.gameGrid[5].contains(value))
				  || (Main.gameGrid[6].contains(value) && Main.gameGrid[7].contains(value) && Main.gameGrid[8].contains(value))
				  || (Main.gameGrid[0].contains(value) && Main.gameGrid[3].contains(value) && Main.gameGrid[6].contains(value))
				  || (Main.gameGrid[1].contains(value) && Main.gameGrid[4].contains(value) && Main.gameGrid[7].contains(value))
				  || (Main.gameGrid[2].contains(value) && Main.gameGrid[5].contains(value) && Main.gameGrid[8].contains(value))
				  || (Main.gameGrid[6].contains(value) && Main.gameGrid[7].contains(value) && Main.gameGrid[8].contains(value))
				  || (Main.gameGrid[0].contains(value) && Main.gameGrid[4].contains(value) && Main.gameGrid[8].contains(value))
				  || (Main.gameGrid[2].contains(value) && Main.gameGrid[4].contains(value) && Main.gameGrid[6].contains(value));
		return(winDetected);
	}

	//Method which checks for a draw scenario based on the game array contents
	public static void checkDraw() {
		//Check if all boxes are filled and no win is present
		int filledIndexCount = 0;
		for (int i = 0; i < Main.gameGrid.length; i++) {
			if (!Objects.equals(Main.gameGrid[i], ".")) {
				filledIndexCount++;
			}
			if (filledIndexCount == 9) {
				GameWindow.drawDetectedMessage();
			}
		}
	}
}