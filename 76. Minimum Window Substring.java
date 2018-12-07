Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.




class Solution {
    public String minWindow(String s, String t) {
    
        //Creates a map that keeps track of the character frequency in the string we are looking for
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int toMatch = map.size();
        int start = 0;
        int minimum = Integer.MAX_VALUE;
        int resultStart = 0;
        
        
        //We iterate to find the end of the substring in S that contains all of T
        for(int end = 0; end < s.length(); end++){
            char c = s.charAt(end);
            
            //Updates map by subtracting 1 from the character frequency table
            if(map.containsKey(c)){
                int count = map.get(c);
                count--;
                map.put(c, count);
                
                //We have all the characters of c we need so we can subtract one from what we're looking for
                if(count == 0){
                    toMatch--;
                    
                    //This means our substring in S contains the entire string of T
                    //We try to find the minimum, and then we take the minimum, and then we 
                    //keep sliding to the right to try to decrease the window. 
                    while(toMatch == 0){
                        if(end - start < minimum){
                            minimum = end - start;
                            resultStart = start;
                        }
                        
                        c = s.charAt(start);
                        if(map.containsKey(c)){
                            count = map.get(c);
                            count++;
                            if(count == 1){
                                toMatch++;
                            }
                            map.put(c, count);
                        }

                        start++;
                    }
                }
            }
        }
        return minimum == Integer.MAX_VALUE ? "" : s.substring(resultStart, resultStart + minimum + 1);
    }
}
