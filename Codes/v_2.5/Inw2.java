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

		if(matching1 == null || matching1.isEmpty()) {  /* no error */
			System.out.println("No Arcs to check in matching number 1.");
			return true;
		}

		if(matching2 == null || matching2.isEmpty()) {  /* no error */
			System.out.println("No Arcs to check in matching number 2.");
			return true;
		}


		List<ArcShape> temp = new ArrayList<ArcShape>();
		boolean flag  = true; /* flag is matching */

		for(ArcShape as2 : matching2) {
			temp.clear();
			
			for(ArcShape as : matching1) {
				if(as.getCallPosition() == as2.getCallPosition() 
						|| as.getReturnPosition() == as2.getReturnPosition() 
						|| as.getReturnPosition() == as2.getCallPosition() 
						|| as.getCallPosition() == as2.getReturnPosition()) {
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
							(as2.getCallPosition() == temp.get(0).getCallPosition() && as2.getReturnPosition() == temp.get(1).getReturnPosition() && temp.get(0).getReturnPosition() != temp.get(1).getCallPosition())
							||
							(as2.getReturnPosition() == temp.get(0).getReturnPosition() && as2.getCallPosition() == temp.get(1).getCallPosition() && temp.get(0).getCallPosition() != temp.get(1).getReturnPosition())
						)
					^ 
						(		
							//(condition 2)
							(as2.getCallPosition() == temp.get(0).getReturnPosition() && as2.getReturnPosition() == temp.get(1).getCallPosition() && temp.get(0).getCallPosition() != temp.get(1).getReturnPosition())
							||  
							(as2.getReturnPosition() == temp.get(0).getCallPosition() && as2.getCallPosition() == temp.get(1).getReturnPosition() && temp.get(0).getReturnPosition() != temp.get(1).getCallPosition())
						)
					)
			) {
				flag = false;
				System.out.println("Arc Error : Definition 3 is not matching.");
				System.out.println("as2 : " + as2.getCallPosition() + " " + as2.getReturnPosition());
				for(ArcShape s : temp) {
					System.out.println(" TEMP : " + s.getCallPosition() + " " + s.getReturnPosition() + " " + temp.size());
				}
			}
		}

		return flag;
	}

	/*public List<ComponentShape> generateGraphicsComponent() {
		List<ComponentShape> l = new ArrayList<ComponentShape>();

		l.addAll(super.generateGraphicsComponent());
		l.addAll(matching2);

		return l;
	}*/
	
	public List<ArcShape> getMatching2() {
		return matching2;
	}

	public void setMatching2(List<ArcShape> matching) {
		this.matching2 = matching;
	}
}
