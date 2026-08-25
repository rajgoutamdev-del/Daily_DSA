function solveNQueens(n: number): string[][] {
    let ans: string[][] = [];
    let board: boolean[][] = Array.from({ length: n }, () => new Array(n).fill(false));
    let cols: boolean[] = new Array(n).fill(false);
    fillboard(board, cols, 0, ans);
    return ans;
}

function fillboard(board: boolean[][], col: boolean[], row: number, ans: string[][]) {
    if (row === col.length) {
        fill(board, ans);
        return;
    }

    for (let i = 0; i < col.length; i++) {
        if (!col[i]) {
            if (checkboard(board, row, i)) {
                col[i] = true;
                board[row][i] = true;
                fillboard(board, col, row + 1, ans);
                col[i] = false;
                board[row][i] = false;
            }
        }
    }
}

function checkboard(board: boolean[][], row: number, col: number): boolean {
    // left top diagonal
    let i = row - 1;
    let j = col - 1;
    while (i >= 0 && j >= 0) {
        if (board[i][j]) return false;
        i--;
        j--;
    }
    // right top diagonal
    i = row - 1;
    j = col + 1;
    while (i >= 0 && j < board.length) {
        if (board[i][j]) return false;
        i--;
        j++;
    }
    return true;
}

function fill(board: boolean[][], ans: string[][]) {
    let ls: string[] = [];
    let n = board.length;

    for (let i = 0; i < n; i++) {
        let row = "";
        for (let j = 0; j < n; j++) {
            row += board[i][j] ? "Q" : ".";
        }
        ls.push(row);
    }
    ans.push(ls);
}
