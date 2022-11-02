public class TreasureMap {
    private final int col, row;
    private final boolean [][] tMap;

    public TreasureMap() {
        this.col = 1;
        this.row = 1;
        tMap = new boolean[row][col];
    }
    public TreasureMap(int col, int row) {
        this.col = col;
        this.row = row;
        tMap = new boolean[row][col];
    }

    public boolean hasTreasure(int row, int col) {
        if(row > this.row || col > this.col) {
            return  false;
        }
        return tMap[row][col];
    }

    public int numAdjacent(int row, int col) {
        int count = 0;
        if(row > this.row || col > this.col) {
            return  count;
        }
        if(!(row + 1 < this.row)){
            if(tMap[row+1][col])
                count += 1;
        }
        if(!(row - 1 < 0)) {
            if(tMap[row-1][col])
                count += 1;
        }
        if(!(col + 1 < this.row)){
            if(tMap[row][col+1])
                count += 1;
        }
        if(!(col - 1 < 0))
            if(tMap[row+1][col-1])
                count += 1;
            else{
             System.out.println("out");
            }
        return count;
    }

    public int getNumCols() {
        return col;
    }

    public int getNumRows() {
        return row;
    }
}
