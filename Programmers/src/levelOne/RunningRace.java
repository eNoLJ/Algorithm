package levelOne;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class RunningRace {

    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<Integer, String> rankPlayerMap = new HashMap<>();
        Map<String, Integer> playerRankMap = new HashMap<>();
        int rank;
        String frontPlayer;


        for (int i = 0; i < players.length; i++){
            rankPlayerMap.put(i, players[i]);
            playerRankMap.put(players[i], i);
        }

        for (String player : callings) {
            rank = playerRankMap.get(player);
            frontPlayer = rankPlayerMap.get(rank - 1);

            rankPlayerMap.put(rank - 1, player);
            rankPlayerMap.put(rank, frontPlayer);

            playerRankMap.put(player, rank - 1);
            playerRankMap.put(frontPlayer, rank);
        }

        for(int i = 0; i < players.length; i++) {
            answer[i] = rankPlayerMap.get(i);
        }

        return answer;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"}))
                .isEqualTo(new String[]{"mumu", "kai", "mine", "soe", "poe"});
        softly.assertAll();
    }
}
