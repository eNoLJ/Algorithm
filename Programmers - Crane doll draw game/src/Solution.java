import java.util.LinkedList;

class Solution {

    public static int solution(int[][] board, int[] moves) {
        LinkedList<Integer> basket = new LinkedList<>();

        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                int doll = board[j][move - 1];
                if (doll != 0) {
                    basket.add(doll);
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }

        int answer = 0;
        boolean check = true;

        while (check && basket.size() > 1) {
            int i;
            int bLength = basket.size();

            for (i = 0; i < bLength - 1; i++) {
                if (basket.get(i).equals(basket.get(i + 1))) {
                    basket.remove(i + 1);
                    basket.remove(i);
                    answer += 2;
                    break;
                }
            }

            if (i == bLength - 1) {
                check = false;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board, moves));
    }
}

