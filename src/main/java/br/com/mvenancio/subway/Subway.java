package br.com.mvenancio.subway;

public class Subway {

	private int x = 0;
	private int y = 0;
	private int z = 0;
	private Direction direction = Direction.NORTH;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public void incrementX() {
		x++;
	}

	public void decrementX() {
		x--;
	}

	public void incrementY() {
		y++;
	}

	public void decrementY() {
		y--;
	}

	public void incrementZ() {
		z++;
	}

	public void decrementZ() {
		z--;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}
