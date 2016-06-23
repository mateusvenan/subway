package br.com.mvenancio.subway;

import java.util.HashMap;
import java.util.Map;

public class SubwayHelper {

	private static Map<Integer, Direction> directions = new HashMap<>();

	static {
		for (Direction direction : Direction.values()) {
			directions.put(direction.ordinal(), direction);
		}
	}

	public String getActualPosition() {
		return null;
	}

	static boolean isTurn(Command command) {
		return Command.L == command || Command.R == command;
	}

	static void move(Command command, Subway subway) {
		rotateDirection(command, subway);
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

	static void rotateDirection(Command command, Subway subway) {
		if (!isTurn(command)) {
			return;
		}
		int index = subway.getDirection().ordinal();
		if (Command.R == command) {
			index++;
			index = index == 4 ? 0 : index;
		} else {
			index--;
			index = index == -1 ? 3 : index;
		}
		subway.setDirection(directions.get(index));
	}

}
