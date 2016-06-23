package br.com.mvenancio.subway;

import java.util.HashMap;
import java.util.Map;

public class Subway {
	
	private int x = 0;
	private int y = 0;
	private int z = 0;
	private Direction direction = Direction.NORTH;
	

	Map<Integer, Direction> directions = new HashMap<>();

	public Subway() {
		for (Direction direction : Direction.values()) {
			directions.put(direction.ordinal(), direction);
		}
	}

	public String getActualPosition() {

		return null;
	}

	private void move(int x, int y, int z, Command command) {
		
		switch (command) {
		case U:
			break;
		case D:
			break;
		case M:
			break;
		default:
			break;
		}
	}

	Direction rotateDirection(Command command, Direction direction) {
		if (!isTurn(command)) {
			return direction;
		}
		int index = direction.ordinal();
		if (Command.R == command) {
			index++;
			index = index == 4 ? 0 : index;
		} else {
			index--;
			index = index == -1 ? 3 : index;
		}
		return directions.get(index);

	}

	boolean isTurn(Command command) {
		return Command.L == command || Command.R == command;
	}
}
