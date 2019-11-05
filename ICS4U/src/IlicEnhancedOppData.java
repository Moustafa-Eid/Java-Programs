
public class IlicEnhancedOppData extends OppData {
	
	private double form;
	private int defence;
	private int id;

	public IlicEnhancedOppData(int id, int a, int s, int health, int defence, double form) {
		super(id, a, s, health);
		// TODO Auto-generated constructor stub
		this.defence = defence;
		this.form = form;
		
	}
	
	public int getDefence() {
		return this.defence;
		
	}
	
	public void setDefence (int defence) {
		this.defence = defence;
	}
	
	public double getFormula() {
		return this.form;
		
	}
	
	public void setFormula (double form) {
		this.form = form;
	}

	public void setID(int id) {
		// TODO Auto-generated method stub
		this.id=id;
		
	}
	
	

}
