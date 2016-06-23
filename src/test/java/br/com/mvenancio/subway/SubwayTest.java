package br.com.mvenancio.subway;

import org.junit.Assert;
import org.junit.Test;

public class SubwayTest {
	Subway subway = new Subway();

	@Test
	public void isTurn() {
		Assert.assertTrue(subway.isTurn(Command.L));
		Assert.assertTrue(subway.isTurn(Command.R));
		Assert.assertFalse(subway.isTurn(Command.D));
		Assert.assertFalse(subway.isTurn(Command.U));
		Assert.assertFalse(subway.isTurn(Command.M));
	}

	@Test
	public void rotateDirection() {
		Assert.assertEquals(Direction.WEST, subway.rotateDirection(Command.L, Direction.NORTH));
		Assert.assertEquals(Direction.EAST, subway.rotateDirection(Command.R, Direction.NORTH));
		Assert.assertEquals(Direction.WEST, subway.rotateDirection(Command.R, Direction.SOUTH));
		Assert.assertEquals(Direction.SOUTH, subway.rotateDirection(Command.L, Direction.WEST));
		Assert.assertEquals(Direction.NORTH, subway.rotateDirection(Command.R, Direction.WEST));
	}

}
