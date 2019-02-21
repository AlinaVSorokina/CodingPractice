package preparation;

import java.util.*;

public class Week2 {

    public static void main(String[] args) {
        List<List<Integer>> ui = new ArrayList<>();
        List<Integer> ui1 = new ArrayList<>();
        ui1.add(1);
        ui1.add(12);
        List<Integer> ui2 = new ArrayList<>();
        ui2.add(2);
        ui2.add(13);
        List<Integer> ui3 = new ArrayList<>();
        ui3.add(3);
        ui3.add(6);
        ui.add(ui1);
        ui.add(ui2);
        ui.add(ui3);

        List<List<Integer>> back = new ArrayList<>();
        List<Integer> back1 = new ArrayList<>();
        back1.add(1);
        back1.add(5);
        List<Integer> back2 = new ArrayList<>();
        back2.add(2);
        back2.add(10);
        List<Integer> back3 = new ArrayList<>();
        back3.add(3);
        back3.add(14);
        back.add(back1);
        back.add(back2);
        back.add(back3);

        List<List<Integer>> res = optimalUtilization(20, ui, back);


    }



    public static List<List<Integer>> optimalUtilization(
            int deviceCapacity,
            List<List<Integer>> foregroundAppList,
            List<List<Integer>> backgroundAppList)
    {
        Map<Integer, List<Integer>> uiRest = new HashMap<>();
        for (List<Integer> fApp : foregroundAppList) {
            int fSize = fApp.get(1);
            if (fSize < deviceCapacity) {
                if (uiRest.containsKey(fSize)) {
                    uiRest.get(fSize).add(fApp.get(0));
                } else {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(fApp.get(0));
                    uiRest.put(fSize, newList);
                }
            }
        }

        Map<Integer, List<Integer>> back = new HashMap<>();
        for (List<Integer> bApp : backgroundAppList) {
            int bSize = bApp.get(1);
            if (bSize < deviceCapacity) {
                if (back.containsKey(bSize)) {
                    back.get(bSize).add(bApp.get(0));
                } else {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(bApp.get(0));
                    back.put(bSize, newList);
                }
            }
        }

        TreeMap<Integer, List<List<Integer>>> pairs = new TreeMap<>();
        for (Integer uiKey : uiRest.keySet()) {
            for (Integer backKey : back.keySet()) {
                int sumSize = uiKey + backKey;
                if (sumSize <= deviceCapacity) {
                    List<List<Integer>> ps = new ArrayList<>();
                    List<Integer> uis = uiRest.get(uiKey);
                    List<Integer> backs = back.get(backKey);
                    for (Integer ui : uis) {
                        for (Integer b : backs) {
                            List<Integer> p = new ArrayList<>();
                            p.add(ui);
                            p.add(b);
                            ps.add(p);
                        }
                    }
                    if (pairs.containsKey(sumSize)) {
                        pairs.get(sumSize).addAll(ps);
                    } else {
                        pairs.put(sumSize, ps);
                    }
                }
            }
        }
        if (pairs.size() > 0) {
            Integer resKey = pairs.lastKey();
            return pairs.get(resKey);
        } else {
            List<List<Integer>> ps = new ArrayList<>();
            return ps;
        }

    }
}
