class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Character, Map<Character, HashSet<Integer>>> map = new HashMap<>();
        Map<Character, HashSet<String>> sq = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') continue;
                String key = i / 3 + "," + j / 3;

                if (!map.containsKey(board[i][j])) {
                    map.put(board[i][j], new HashMap<>());
                    sq.put(board[i][j], new HashSet<>());
                    map.get(board[i][j]).put('r', new HashSet<>());
                    map.get(board[i][j]).put('c', new HashSet<>());
                } else {
                    if (map.get(board[i][j]).get('r').contains(i)) {
                        return false;
                    }
                    if (map.get(board[i][j]).get('c').contains(j)) {
                        return false;
                    }
                    
                    if (sq.get(board[i][j]).contains(key)) {
                        return false;
                    }
                }

                map.get(board[i][j]).get('r').add(i);
                map.get(board[i][j]).get('c').add(j);
                sq.get(board[i][j]).add(key);
            }
        }

        return true;
    }
}
