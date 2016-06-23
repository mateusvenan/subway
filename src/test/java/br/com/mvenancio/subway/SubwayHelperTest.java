package br.com.mvenancio.subway;

import org.junit.Assert;
import org.junit.Test;

public class SubwayHelperTest {

	@Test
	public void isTurn() {
		Assert.assertTrue(SubwayHelper.isTurn(Command.L));
		Assert.assertTrue(SubwayHelper.isTurn(Command.R));
		Assert.assertFalse(SubwayHelper.isTurn(Command.D));
		Assert.assertFalse(SubwayHelper.isTurn(Command.U));
		Assert.assertFalse(SubwayHelper.isTurn(Command.M));
	}

	@Test
	public void rotateDirection() {
		Subway subway = new Subway();
		subway.setDirection(Direction.NORTH);

		SubwayHelper.rotateDirection(Command.L, subway);
		Assert.assertEquals(Direction.WEST, subway.getDirection());

		SubwayHelper.rotateDirection(Command.R, subway);
		SubwayHelper.rotateDirection(Command.R, subway);
		Assert.assertEquals(Direction.EAST, subway.getDirection());

		SubwayHelper.rotateDirection(Command.R, subway);
		SubwayHelper.rotateDirection(Command.R, subway);
		Assert.assertEquals(Direction.WEST, subway.getDirection());

		SubwayHelper.rotateDirection(Command.L, subway);
		Assert.assertEquals(Direction.SOUTH, subway.getDirection());

		SubwayHelper.rotateDirection(Command.L, subway);
		SubwayHelper.rotateDirection(Command.L, subway);
		Assert.assertEquals(Direction.NORTH, subway.getDirection());
	}

}
