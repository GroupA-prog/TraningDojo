package jp.co.example.util;

import java.util.Comparator;

import jp.co.example.dto.entity.Ranking;

public class RankingComparator implements Comparator<Ranking> {

    //比較メソッド（データクラスを比較して-1, 0, 1を返すように記述する）
    public int compare(Ranking a, Ranking b) {
        Double no1 = a.getScore();
        Double no2 = b.getScore();

        //こうするとスコアの降順でソートされる
        if (no1 < no2) {
            return 1;

        } else if (no1 == no2) {
            return 0;

        } else {
            return -1;

        }
    }

}