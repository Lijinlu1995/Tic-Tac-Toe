/* Main class which controls everything
   How to run:  javac Oxo.java
                java Oxo
   How to test: javac Oxo.java
                java Oxo test
*/
class Oxo {

    private Board board;
    private Display display;
    int count = 0;
    public static void main (String[] args) {
        Oxo game = new Oxo();
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if ("test".equals(args[i])) game.test();
            }
        }
        else {
            game.initialise();
            game.run();
        }
    }

    // Initialise the board & display objects
    private void initialise() {
        board = new Board();
        display = new Display();
    }

    // Repeat the main game loop turn by turn until the game is finished
    private void run() {
        String move;
        display.gameStart();

        while (board.getGameOver() == false && count < 9) {
            display.displayBoard(board.getBoard());
            move = display.getMove(count);
            board.playerTurn(move);
            count ++;
            if(count == 9)  break;

        }
        display.displayBoard(board.getBoard());
        display.gameEnd(board.getPlayer());
    }

    void test()
    {
        Board b = new Board();
        Display d = new Display();
        b.test();
        d.test();
    }
}