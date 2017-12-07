package worldStuff;

public class InventoryItem {
	
	private String name;
	private double weight, bulk;
	private boolean isWearable, isWorn, isEquippable, isEquipped, isContainer, isContained, isConsumable;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getBulk() {
		return bulk;
	}
	public void setBulk(double bulk) {
		this.bulk = bulk;
	}
	public boolean isWearable() {
		return isWearable;
	}
	public void setWearable(boolean isWearable) {
		this.isWearable = isWearable;
	}
	public boolean isWorn() {
		return isWorn;
	}
	public void setWorn(boolean isWorn) {
		this.isWorn = isWorn;
	}
	public boolean isEquippable() {
		return isEquippable;
	}
	public void setEquippable(boolean isEquippable) {
		this.isEquippable = isEquippable;
	}
	public boolean isEquipped() {
		return isEquipped;
	}
	public void setEquipped(boolean isEquipped) {
		this.isEquipped = isEquipped;
	}
	public boolean isContainer() {
		return isContainer;
	}
	public void setContainer(boolean isContainer) {
		this.isContainer = isContainer;
	}
	public boolean isContained() {
		return isContained;
	}
	public void setContained(boolean isContained) {
		this.isContained = isContained;
	}
	public boolean isConsumable() {
		return isConsumable;
	}
	public void setConsumable(boolean isConsumable) {
		this.isConsumable = isConsumable;
	}

	

}
