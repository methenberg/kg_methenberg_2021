import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class stringMap {
    public static void main(String[] args) {
        String s1, s2=null;
        stringMap test = new stringMap();
//        System.out.println(test.strMap("abcdd","taaac"));
        ArrayList<Integer> a1 = new ArrayList<>() {{
            add(7);
            add(4);
            add(2);
            add(2);
            add(4);
        }};
        ArrayList<Integer> a2 = new ArrayList<>() {{
            add(8);
            add(9);
            add(2);
        }};
        System.out.println(test.arrayCompare(a1,a2));
    }
    public boolean strMap(String s1, String s2){
        if(s1.length()!=s2.length()){ // one to one map size constrain
            return false;
        }
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();     //the map is to record the character in string and the times they occur
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i=0;i<ch1.length;i++){
            if(map1.containsKey(ch1[i])){
                map1.put(ch1[i], map1.get(ch1[i])+1);
            }else{ map1.put(ch1[i],1); }
            if(map2.containsKey(ch2[i])){
                map2.put(ch2[i], map2.get(ch2[i])+1);
            }else{map2.put(ch2[i],1);}
        }
        ArrayList<Integer> ar1 = new ArrayList<>();
        ArrayList<Integer> ar2 = new ArrayList<>();
        for(Character c:map1.keySet()){
            ar1.add(map1.get(c));
        }
        for(Character c:map2.keySet()){
            ar2.add(map2.get(c));
        }
        return true;
    }
    public boolean arrayCompare(ArrayList<Integer> a1, ArrayList<Integer> a2){
        if(a1.size()==0&&a2.size()==0){
            return true;
        }
        for(int i=0;i<a1.size();i++){
            ArrayList<Integer> temp1=new ArrayList<>(a1);
            ArrayList<Integer> temp2=new ArrayList<>(a2);
            if(a1.get(i)<a2.get(0)){
                temp2.set(0,temp2.get(0)-temp1.get(i));
                temp1.remove(i);
                if(arrayCompare(temp1,temp2)){
                    return true;
                }
            }else if(a1.get(i)==a2.get(0)){
                temp1.remove(i);
                temp2.remove(0);
                if(arrayCompare(temp1,temp2)){
                    return true;
                }
            }else {

            }
        }
        return false;
    }
//    public ArrayList<Integer> rmov(ArrayList<Integer> a, int i){
//        a.remove(i);
//        return a;
//    }
}
