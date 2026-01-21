class Solution {

    String[] map = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;

        backtrack(0, digits, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int index, String digits,
                           StringBuilder current,
                           List<String> result) {

        // base case
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = map[digit];

        for (char ch : letters.toCharArray()) {
            current.append(ch);           // choose
            backtrack(index + 1, digits, current, result);
            current.deleteCharAt(current.length() - 1); // undo
        }
    }
}
