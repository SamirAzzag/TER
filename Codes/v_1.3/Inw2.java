import java.util.ArrayList;
import java.util.List;


public class Inw2 extends Inw1 {

	List<ArcShape> matching2; /* bottom Arcs */

	Inw2(String word, List<ArcShape> matching, List<ArcShape> matching2) {
		super(word, matching);
		this.matching2 = matching2;
	}

	Inw2(){
		super();
	}

	/* definition 3 */
	public boolean isMatching() {

		if(matching == null || matching.isEmpty()) {  /* no error */
			System.out.println("No Arcs to check in word number 1.");
			return true;
		}

		if(matching2 == null || matching2.isEmpty()) {  /* no error */
			System.out.println("No Arcs to check in word number 2.");
			return true;
		}


		List<ArcShape> temp = new ArrayList<ArcShape>();
		boolean flag  = true; /* flag is matching */

		for(ArcShape as2 : matching2) {
			temp.clear();
			for(ArcShape as : matching) {
				if(as.getX() == as2.getX() || as.getY() == as2.getY() || as.getY() == as2.getX() || as.getX() == as2.getY()) {
					temp.add(as);
				}
			}

			/* at the end we need to have two arcs in M1 for one arc in M2 */
			if(temp == null || temp.size() != 2) {
				flag = false;
				System.out.println("Arc Error : Definition 3 is not matching.");
			} 
			/* 
			 * (x,y) In M2 we have :
			 * 
			 *  1) (x, x0) (y0, y) <=> (y0, y) (x, x0)  => condition 1.
			 *  
			 *  2) (x0, y) (y, y0) <=> (y, y0) (x0, x)  => condition 2.
			 *  
			 *  then
			 *  
			 *  ! ((condition 1) XOR (condition 2)) => error 
			 * */
			else if(
					!(
						(
								//(condition 1)
									(as2.getX() == temp.get(0).getX() && as2.getY() == temp.get(1).getY() && temp.get(0).getY() != temp.get(1).getX())
								||	
									(as2.getY() == temp.get(0).getY() && as2.getX() == temp.get(1).getX() && temp.get(0).getX() != temp.get(1).getY())
						)
					^ 
						(		
								//(condition 2)
									(as2.getX() == temp.get(0).getY() && as2.getY() == temp.get(1).getX() && temp.get(0).getX() != temp.get(1).getY())
								||  
									(as2.getY() == temp.get(0).getX() && as2.getX() == temp.get(1).getY() && temp.get(0).getY() != temp.get(1).getX())
						)
					)
			) {
				flag = false;
				System.out.println("Arc Error : Definition 3 is not matching.");
				System.out.println("as2 : " + as2.getX() + " " + as2.getY());
				for(ArcShape s : temp) {
					System.out.println(" TEMP : " + s.getX() + " " + s.getY() + " " + temp.size());
				}
			}
		}

		return flag;
	}

	public List<ComponentShape> generateGraphicsComponent() {
		List<ComponentShape> l = new ArrayList<ComponentShape>();

		l.addAll(super.generateGraphicsComponent());
		l.addAll(matching2);

		return l;
	}
}
