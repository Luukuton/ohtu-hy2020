package ohtu.kivipaperisakset;

public class BetterAI {
  private final String[] memory;
  private int freeMemIndex;

  public BetterAI(int memSize) {
    memory = new String[memSize];
    freeMemIndex = 0;
  }

  public void setMove(String move) {
    if (freeMemIndex == memory.length) {
      if (memory.length - 1 >= 0) System.arraycopy(memory, 1, memory, 0, memory.length - 1);

      freeMemIndex--;
    }

    memory[freeMemIndex] = move;
    freeMemIndex++;
  }


  public String giveMove() {
    if (freeMemIndex == 0 || freeMemIndex == 1) {
      return "k";
    }

    String latestMove = memory[freeMemIndex - 1];
    int k = 0;
    int p = 0;
    int s = 0;

    for (int i = 0; i < freeMemIndex - 1; i++) {
      if (latestMove.equals(memory[i])) {
        String next = memory[i+1];

        if ("k".equals(next)) {
          k++;
        } else if ("p".equals(next)) {
          p++;
        } else {
          s++;
        }
      }
    }

    if (k > p && k > s) {
      return "p";
    }
    else if (p > k && p > s) {
      return "s";
    }
    else {
      return "k";
    }
  }
}
