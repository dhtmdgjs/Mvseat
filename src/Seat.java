class Seat {
    private int row;
    private int col;
    private boolean selected;

    public Seat(int row, int col) {
        this.row = row;
        this.col = col;
        this.selected = false;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}