package levelOne;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class GetReportResults {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> reportedUserAndCount = new HashMap<>();
        Map<String, Set<String>> reportedUserRecord = new HashMap<>();

        for (String user : id_list) {
            reportedUserAndCount.put(user, 0);
            reportedUserRecord.put(user, new HashSet<>());
        }

        for (String record : report) {
            String[] recordArray = record.split(" ");
            if (!reportedUserRecord.get(recordArray[0]).contains(recordArray[1])) {
                reportedUserAndCount.put(recordArray[1], reportedUserAndCount.get(recordArray[1]) + 1);
            }
            reportedUserRecord.get(recordArray[0]).add(recordArray[1]);
        }

        for (int i = 0; i < id_list.length; i++) {
            Set<String> users = reportedUserRecord.get(id_list[i]);
            for (String targetUser : users) {
                if (reportedUserAndCount.get(targetUser) >= k) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
                2))
                .isEqualTo(new int[]{2, 1, 1, 0});
        softly.assertThat(solution(new String[]{"con", "ryan"},
                new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
                3))
                .isEqualTo(new int[]{0, 0});
        softly.assertAll();
    }
}
