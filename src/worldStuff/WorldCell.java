package worldStuff;

public class WorldCell {

	public String name;
	public int height, width;
	public Layout layout = new Layout();
	private boolean isInterior;
	private int cellNum, ownedBy; // For now, OwnedBy - 0 = player. 1 = everyone.
	private int[] exitNodes;
	private String[] description;
	public String[] stringLayout;
	public char[][] charLayout;
	
	public WorldCell(String name) {
		this.name = name;
		setInterior(true); setOwnedBy(0);
		this.exitNodes = new int[]{1};
		stringLayout = layout.makeGenericLayout(isInterior, exitNodes, 5);
		char[] charWidth = stringLayout[0].toCharArray();
		width = charWidth.length;
		height = stringLayout.length;
		charLayout = layout.getLayoutC(stringLayout, width);
	}
	
	public WorldCell(String name, boolean isInterior) {
		this.name = name;
		this.isInterior = isInterior;
		if (isInterior) setOwnedBy(0);
		this.exitNodes = new int []{1};
		stringLayout = layout.makeGenericLayout(isInterior, exitNodes, 5);
		char[] charWidth = stringLayout[0].toCharArray();
		width = charWidth.length;
		height = stringLayout.length;
		charLayout = layout.getLayoutC(stringLayout, width);
	}

	public WorldCell(String name, boolean isInterior, int[] exitNodes) {
		this.name = name;
		this.isInterior = isInterior;
		if (isInterior) setOwnedBy(0);
		this.exitNodes = exitNodes;
		stringLayout = layout.makeGenericLayout(isInterior, exitNodes, 5);
		char[] charWidth = stringLayout[0].toCharArray();
		width = charWidth.length;
		height = stringLayout.length;
		charLayout = layout.getLayoutC(stringLayout, width);
	}
	
	public WorldCell(int cellNum, String name, boolean isInterior, int[] exitNodes) {
		this.setCellNum(cellNum);
		this.name = name;
		this.isInterior = isInterior;
		if (isInterior) setOwnedBy(0);
		this.exitNodes = exitNodes;
		stringLayout = layout.makeGenericLayout(isInterior, exitNodes, 5);
		char[] charWidth = stringLayout[0].toCharArray();
		width = charWidth.length;
		height = stringLayout.length;
		charLayout = layout.getLayoutC(stringLayout, width);
	}

	public boolean isInterior() {
		return isInterior;
	}

	public void setInterior(boolean isInterior) {
		this.isInterior = isInterior;
	}

	public int[] getExitNodes() {
		return exitNodes;
	}

	public void setExitNodes(int[] exitNodes) {
		this.exitNodes = exitNodes;
	}

	public String[] getDescription() {
		return description;
	}

	public void setDecription(String[] description) {
		this.description = description;
	}
	
	public void setLayoutC(char[][] l) {
		charLayout = l;
	}
	
	public void setLayoutS(String[] s) {
		stringLayout = s;
	}
	
	public char[][] getLayoutC() {
		return charLayout;
	}
	
	public String[] getLayoutS() {
		return stringLayout;
	}

	public int getCellNum() {
		return cellNum;
	}

	public void setCellNum(int cellNum) {
		this.cellNum = cellNum;
	}

	public int getOwnedBy() {
		return ownedBy;
	}

	public void setOwnedBy(int ownedBy) {
		this.ownedBy = ownedBy;
	}

}
