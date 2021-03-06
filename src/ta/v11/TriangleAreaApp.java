package ta.v11;

import java.util.Scanner;

public class TriangleAreaApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double equilateral_area_sum = 0.0;
		int num_equilateral = 0;
		double isosceles_area_sum = 0.0;
		int num_isosceles = 0;
		double scalene_area_sum = 0.0;
		int num_scalene = 0;
		
		String smallest_id = null;
		double smallest_area = 0.0;
		
		while (sc.hasNext()) {
			String id = sc.next();
			if (id.equals("end")) {
				break;
			}
			double ax = sc.nextDouble();
			double ay = sc.nextDouble();
			double bx = sc.nextDouble();
			double by = sc.nextDouble();
			double cx = sc.nextDouble();
			double cy = sc.nextDouble();

			/*
			System.out.println("Triangle: " + id);
			System.out.println("A: (" + ax + ", " + ay + ")");
			System.out.println("B: (" + bx + ", " + by + ")");
			System.out.println("C: (" + cx + ", " + cy + ")");
			System.out.println("----");
			*/
			
			Triangle t = new Triangle(new Point(ax, ay), 
					                  new Point(bx, by), 
					                  new Point(cx, cy));
			
			String category = t.category();

			System.out.println("Triangle " + id + " is " + category);
			
			double area = t.area();

			if (smallest_id == null) {
				smallest_area = area;
				smallest_id = id;
			} else if (area < smallest_area) {
				smallest_area = area;
				smallest_id = id;
			}
			
			if (category.equals("equilateral")) {
				num_equilateral++;
				equilateral_area_sum += area;
			} else if (category.equals("isosceles")) {
				num_isosceles++;
				isosceles_area_sum += area;
			} else {
				num_scalene++;
				scalene_area_sum += area;
			}			
		}
		
		sc.close();
		
		if (num_equilateral > 0) {
			System.out.println("Avg. equilateral area: " + (equilateral_area_sum/num_equilateral));			
		} else {
			System.out.println("No equilateral triangles");
		}
		
		if (num_isosceles > 0) {
			System.out.println("Avg. isosceles area: " + (isosceles_area_sum/num_isosceles));			
		} else {
			System.out.println("No isosceles triangles");
		}

		if (num_scalene > 0) {
			System.out.println("Avg. scalene area: " + (scalene_area_sum/num_scalene));			
		} else {
			System.out.println("No scalene triangles");
		}
		
		System.out.println(smallest_id + " was the smallest with an area of " + smallest_area);
		
	}

	
}
