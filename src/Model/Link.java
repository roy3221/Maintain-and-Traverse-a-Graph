/*
 * A class to present links between each pair of nodes.
 * override hashCode() and equals() method, so that we can check any two objects are
 * equal or not in constant time, when use HashSet's method contains().
 */

package Model;

public class Link {
	String link;
	public Link(int node1, int node2) {
		link = "";
		link +=node1;
		link +=node2;
	}
	
	public String getLink(){
		return link;
	}
	
	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((link == null) ? 0 : link.hashCode());
	    return result;
	}
	
	 @Override
	 public boolean equals(Object obj) {
	     if (this == obj)
	         return true;
	     if (obj == null)
	         return false;
	     if (!(obj instanceof Link))
	         return false;
	     Link other = (Link) obj;
	     if (link == null) {
	         if (other.link != null)
	             return false;
	     } else if (!link.equals(other.link))
	         return false;
	     return true;
	 }
	

}
