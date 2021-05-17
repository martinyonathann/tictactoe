package tictactoe.models;

public enum PlayerState {
    IN_PROGRESS,
    WIN,
    LOS,
    DRAW;

    public boolean isInProgress(){
        return this == IN_PROGRESS;
    }
    public boolean isWin(){
        return this == WIN;
    }
    public boolean isLos(){
        return this == LOS;
    }
    public boolean isDraw(){
        return this == DRAW;
    }
    public boolean isGameOver(){
        return this == WIN || this == LOS || this == DRAW;
    }
}
