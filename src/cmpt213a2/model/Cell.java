//Granton Lo
//ID:301360495
//Email: grantonl@sfu.ca

//Lucas Park
//Email: lpa24@sfu.ca
//ID: 301362079
package cmpt213a2.model;

public class Cell {
    private String type;
    private int xCoord;
    private int yCoord;
    private boolean revealed;
    private boolean checked;
    private final int index;

    public Cell(String type, int xCoord, int yCoord, boolean revealed, int index) {
        this.type = type;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.revealed = revealed;
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getIndex() {
        return index;
    }
}

