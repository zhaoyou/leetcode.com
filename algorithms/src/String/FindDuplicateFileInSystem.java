package String;

import org.junit.Test;

import java.util.*;

public class FindDuplicateFileInSystem {


    @Test
    public void test() {
        String [] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        System.out.println(findDuplicate(paths));
    }

    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String path: paths) {
            String[] files = path.split(" ");
            String root = files[0];

            for(int i = 1; i < files.length; i++) {
                String[] arr = files[i].split("\\(|\\)");
                String fileName = arr[0];
                String content = arr[1];

                String finalFileName = root + "/" + fileName;

                map.putIfAbsent(content, new ArrayList<>());

                map.get(content).add(finalFileName);

            }
        }

        for(List<String> subList: map.values()) {
            if (subList.size() > 1) list.add(subList);
        }

        return list;
    }

    public static void main(String[] args) {
        String a = "1.txt(abcd)";
        System.out.println(a.split("\\(|\\)")[0] + " " + a.split("\\(|\\)")[1]);
    }
}
