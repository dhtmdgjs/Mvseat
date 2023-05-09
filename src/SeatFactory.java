public class SeatFactory {
    public static Seat createSeat(int row, int col) {
        return new Seat(row, col);
    }
}
