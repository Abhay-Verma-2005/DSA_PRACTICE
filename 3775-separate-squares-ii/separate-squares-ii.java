import java.util.Arrays;

class Solution {
    public double separateSquares(int[][] squares) {
        int n = squares.length;
        
        // Coordinate Compression for X-axis
        double[] xCoords = new double[2 * n];
        for (int i = 0; i < n; i++) {
            xCoords[2 * i] = squares[i][0];
            xCoords[2 * i + 1] = (double) squares[i][0] + squares[i][2];
        }
        Arrays.sort(xCoords);
        
        int m = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (i == 0 || xCoords[i] != xCoords[i - 1]) {
                xCoords[m++] = xCoords[i];
            }
        }

        Event[] events = new Event[2 * n];
        for (int i = 0; i < n; i++) {
            double y1 = squares[i][1];
            double y2 = (double) squares[i][1] + squares[i][2];
            int x1 = Arrays.binarySearch(xCoords, 0, m, (double) squares[i][0]);
            int x2 = Arrays.binarySearch(xCoords, 0, m, (double) squares[i][0] + squares[i][2]);
            events[2 * i] = new Event(y1, x1, x2, 1);
            events[2 * i + 1] = new Event(y2, x1, x2, -1);
        }
        Arrays.sort(events);

        int[] count = new int[4 * m];
        double[] len = new double[4 * m];

        double[] hY = new double[2 * n];
        double[] hW = new double[2 * n];
        int hCount = 0;

        double totalArea = 0;
        double prevY = events[0].y;

        for (Event e : events) {
            if (e.y > prevY) {
                double w = len[0];
                double h = e.y - prevY;
                totalArea += w * h;

                hY[hCount] = e.y;
                hW[hCount] = w;
                hCount++;

                prevY = e.y;
            }
            update(0, 0, m - 1, e.x1, e.x2, e.val, count, len, xCoords);
        }

        double target = totalArea / 2.0;
        double currArea = 0;
        double currY = events[0].y;

        for (int i = 0; i < hCount; i++) {
            double h = hY[i] - currY;
            double w = hW[i];
            double chunk = h * w;

            if (currArea + chunk >= target) {
                return currY + (target - currArea) / w;
            }
            currArea += chunk;
            currY = hY[i];
        }
        return currY;
    }

    private void update(int node, int start, int end, int l, int r, int val,
                        int[] count, double[] len, double[] xCoords) {
        if (l >= end || r <= start) return;

        if (l <= start && end <= r) {
            count[node] += val;
        } else {
            int mid = (start + end) / 2;
            update(2 * node + 1, start, mid, l, r, val, count, len, xCoords);
            update(2 * node + 2, mid, end, l, r, val, count, len, xCoords);
        }

        if (count[node] > 0) {
            len[node] = xCoords[end] - xCoords[start];
        } else if (end - start == 1) {
            len[node] = 0;
        } else {
            len[node] = len[2 * node + 1] + len[2 * node + 2];
        }
    }

    static class Event implements Comparable<Event> {
        double y;
        int x1, x2, val;
        Event(double y, int x1, int x2, int val) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.val = val;
        }
        public int compareTo(Event o) {
            return Double.compare(this.y, o.y);
        }
    }
}