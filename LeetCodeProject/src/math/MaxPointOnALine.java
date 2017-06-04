package math;


/**
 * 
 * @author jfqiao
 *
 */

public class MaxPointOnALine {
	/*
	 * 84,250],[0,0],[1,0],[0,-70],[0,-70],[1,-1],[21,10],[42,90],[-42,-230
	 */
	public static void main(String[] args) {
		System.out.println(65536L * -65536L);
		MaxPointOnALine mpo = new MaxPointOnALine();
		Point[] points = new Point[9];
		points[0] = new Point(84, 250);
		points[1] = new Point(84, 250);
		points[2] = new Point(84, 250);
		points[3] = new Point(84, 250);
		points[4] = new Point(84, 250);
		points[5] = new Point(84, 250);
		points[6] = new Point(84, 250);
		points[7] = new Point(42, 90);
		points[8] = new Point(-42, -230);
		System.out.println(mpo.maxPointOnALine(points));
	}
	
	public int maxPointOnALine(Point[] points) {
		int count = 0;
		int result = 0;
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				//if points i, j are the same, then skip
				if (points[i].x == points[j].x &&
					points[i].y == points[j].y)
					continue;
				count = 0;
				for (int k = 0; k < points.length; k++) {
					if (k == i || k == j )
						continue;
					// if points k is the same with i or j, increment count.
					if (isOnLine(points[i], points[j], points[k])
							|| points[i].x == points[k].x &&
							   points[i].y == points[k].y
							|| points[k].x == points[j].x &&
							   points[k].y == points[j].y)
						count++;
				}
				if (result < count + 2)
					result = count + 2;
			}
		}
		//if all points are the same
		if (result == 0)
			result = points.length;
		return result;
	}
	
	private boolean isOnLine(Point a, Point b, Point p) {
		long l1 = ((long)a.x - (long)p.x) * ((long)b.y - (long)p.y); 
		long l2 = ((long)b.x - (long)p.x) * ((long)a.y - (long)p.y);
		return l1 == l2;
	}
}

class Point {
	int x;
	int y;
	
	Point() {
		x = 0;
		y = 0;
	}
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
