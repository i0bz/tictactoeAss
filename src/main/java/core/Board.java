package core;

import java.util.ArrayList;
import java.util.Optional;

public class Board {
    private final int ROWS = 3;
    private final int COLS = 3;

    private int filled = 0;
    public Player currentPlayer = Player.ONE;

    ArrayList<ArrayList<Optional<Player>>> playingBoard = new ArrayList<>(ROWS);


    public Board() {
        initializeBoard();
    }

    public ActionResult move(int row, int col) {
        if (playingBoard.get(row).get(col).isPresent())
            return ActionResult.CELL_OCCUPIED;
        playingBoard.get(row).set(col, Optional.of(currentPlayer));
        filled++;
        swapPlayer();

        if(filled > 4) {
            Optional<Player> winner = checkWinnerRows();
            if (winner.isPresent()) return getWinningPlayer(winner.get());

            winner = checkWinnerCols();
            if (winner.isPresent()) return getWinningPlayer(winner.get());

            winner = checkWinnerDiag();
            if (winner.isPresent()) return getWinningPlayer(winner.get());
        }



        if(isFull()) return ActionResult.DRAW;
        return ActionResult.SUCCESS;
    }

    private ActionResult getWinningPlayer(Player player) {
        if (player == Player.ONE) return ActionResult.PLAYER_ONE_WIN;
        else return ActionResult.PLAYER_TWO_WIN;
    }

    private Optional<Player> checkWinnerRows() {
        for (int i = 0; i < ROWS; i++) {
            if (isCellEmpty(i, 0)) continue;
            if (isCellEmpty(i, 1)) continue;
            if (isCellEmpty(i, 2)) continue;


            else if (playingBoard.get(i).get(0).get() == playingBoard.get(i).get(1).get() &&
                    playingBoard.get(i).get(0).get() == playingBoard.get(i).get(2).get()) return playingBoard.get(i).get(0);
        }

        return Optional.empty();
    }

    private Optional<Player> checkWinnerCols() {
        for (int i = 0; i < COLS; i++) {
            if (isCellEmpty(0, i)) continue;
            if (isCellEmpty(1, i)) continue;
            if (isCellEmpty(2, i)) continue;

            else if (playingBoard.get(0).get(i).get() == playingBoard.get(1).get(i).get() &&
                        playingBoard.get(0).get(i).get() == playingBoard.get(2).get(i).get()) return playingBoard.get(0).get(i);
        }

        return Optional.empty();
    }

    private Optional<Player> checkWinnerDiag() {

        if (isCellEmpty(0,0)) return Optional.empty();
        if (isCellEmpty(2,2)) return Optional.empty();
        if (isCellEmpty(2,0)) return Optional.empty();
        if (isCellEmpty(0,2)) return Optional.empty();
        if (isCellEmpty(1,1)) return Optional.empty();


        if (playingBoard.get(0).get(0).get() == playingBoard.get(1).get(1).get() &&
                playingBoard.get(2).get(2).get() == playingBoard.get(0).get(0).get()) return playingBoard.get(1).get(1);
        if (playingBoard.get(0).get(2).get() == playingBoard.get(1).get(1).get() &&
                playingBoard.get(2).get(0).get() == playingBoard.get(0).get(2).get()) return playingBoard.get(1).get(1);

        return Optional.empty();
    }

    private boolean isCellEmpty(int row, int col) {
        return playingBoard.get(row).get(col).isEmpty();
    }

    private boolean isFull() {
        return filled >= (ROWS * COLS);
    }

    private void swapPlayer() {
        if (currentPlayer == Player.ONE) currentPlayer = Player.TWO;
        else currentPlayer = Player.ONE;
    }


    private void initializeBoard() {
        for (int i = 0; i < ROWS;  i++) {
            ArrayList<Optional<Player>> row = new ArrayList<>(COLS);
            for (int j = 0; j < COLS; j++) {
                row.add(Optional.empty());
            }
            playingBoard.add(row);
        }
    }



    public void reset() {
        currentPlayer = Player.ONE;
        filled = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                playingBoard.get(i).set(j, Optional.empty());
            }
        }
    }



}
