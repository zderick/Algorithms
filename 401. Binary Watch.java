/*
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.

For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
*/

public List<String> readBinaryWatch(int num) {
    List<String> result = new ArrayList<>();
    boolean[] array = new boolean[10];
    helper(0, num, array, result);
    return result;
}

public void helper(int cur, int count, boolean[] array, List<String> result){
    if(count == 0){
        String s = isValidAndTranslate(array);
        if(!s.equals("")){
            result.add(s);
        }
        return;
    }
    
    if(cur == array.length){
        return;
    }
    
    helper(cur + 1, count, array, result);
    array[cur] = true;
    helper(cur + 1, count - 1, array, result);
    array[cur] = false;
}

public String isValidAndTranslate(boolean[] array){
    int hours = 0;
    int min = 0;
    hours += array[0] ? 8 : 0;
    hours += array[1] ? 4 : 0;
    hours += array[2] ? 2 : 0;
    hours += array[3] ? 1 : 0;
    min += array[4] ? 32 : 0;
    min += array[5] ? 16 : 0;
    min += array[6] ? 8 : 0;
    min += array[7] ? 4 : 0;
    min += array[8] ? 2 : 0;
    min += array[9] ? 1 : 0;
    
    if(hours >= 12 || min >= 60) return ""; 
    String s = hours + ":";
    if(min < 10){
        s += "0";
    }

    s += min;
    return s;
}