package avlTree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author :xie
 * Email: 1487471733@qq.com
 * Date: 2019/7/17
 * Time: 0:02
 * Describe:
 */
public class demo {

    public static void main(String[] args) {
        String s = "10771034948754277771578";
        String[] split = s.split("|");
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            if (hashMap.get(Integer.parseInt(split[i]))==null){
                hashMap.put(Integer.parseInt(split[i]),1);
            }else {
                hashMap.put(Integer.parseInt(split[i]),(hashMap.get(Integer.parseInt(split[i]))+1));
            }
        }

        Map<Integer, Integer> integerIntegerMap = sortMapByKey(hashMap);
        System.out.println(integerIntegerMap);

    }

    private static java.util.Map<Integer, Integer> sortMapByKey(java.util.Map<Integer, Integer> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<Integer, Integer> sortMap = new TreeMap<Integer, Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer str1, Integer str2) {
                return str1.compareTo(str2);
            }
        });
        sortMap.putAll(map);
        return sortMap;
    }



}
