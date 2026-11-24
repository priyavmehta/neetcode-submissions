class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Character, Map<Character, HashSet<Integer>>> map = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') continue;

                if (!map.containsKey(board[i][j])) {
                    map.put(board[i][j], new HashMap<>());
                    map.get(board[i][j]).put('r', new HashSet<>());
                    map.get(board[i][j]).put('c', new HashSet<>());
                } else {
                    if (map.get(board[i][j]).get('r').contains(i)) {
                        System.out.println("Returning False from if");
                        return false;
                    }
                    if (map.get(board[i][j]).get('c').contains(j)) {
                        System.out.println("Returning False from if");
                        return false;
                    }
                    
                    int r = 0, c = 0;
                    if (i >= 6) r = 6;
                    else if (i >= 3) r = 3;
                    else r = 0;

                    if (j >= 6) c = 6;
                    else if (j >= 3) c = 3;
                    else c = 0;

                    for (int k = 0; k < 3; k++) {
                        for (int m = 0; m < 3; m++) {
                            if (board[r+k][c+m] == board[i][j] && r + k != i && c + m != j) {
                                return false;
                            }
                        }
                    }
                }

                map.get(board[i][j]).get('r').add(i);
                map.get(board[i][j]).get('c').add(j);
            }
        }

        return true;
    }
}
