package br.com.mvenancio.subway;

import org.junit.Assert;
import org.junit.Test;

public class SubwayHelperTest {

	@Test
	public void getActualPositionByExample() {
		Subway subway = SubwayHelper.getActualPosition("RMMLMMMDDLL");

		Assert.assertEquals(2, subway.getX());
		Assert.assertEquals(3, subway.getY());
		Assert.assertEquals(-2, subway.getZ());
		Assert.assertEquals(Direction.SOUTH, subway.getDirection());
	}

	@Test
	public void getActualPosition() {
		Subway subway = SubwayHelper.getActualPosition("LMRDDMMUU");

		Assert.assertEquals(-1, subway.getX());
		Assert.assertEquals(2, subway.getY());
		Assert.assertEquals(0, subway.getZ());
		Assert.assertEquals(Direction.NORTH, subway.getDirection());
	}

	@Test
	public void moveXYWhenDirectionIsNorth() {
		Subway subway = new Subway();

		SubwayHelper.moveXY(subway);
		SubwayHelper.moveXY(subway);

		Assert.assertEquals(2, subway.getY());
		Assert.assertEquals(0, subway.getX());
	}

	@Test
	public void moveXYWhenDirectionIsSouth() {
		Subway subway = new Subway();
		subway.setDirection(Direction.SOUTH);

		SubwayHelper.moveXY(subway);
		SubwayHelper.moveXY(subway);

		Assert.assertEquals(-2, subway.getY());
		Assert.assertEquals(0, subway.getX());
	}

	@Test
	public void moveXYWhenDirectionIsEast() {
		Subway subway = new Subway();
		subway.setDirection(Direction.EAST);

		SubwayHelper.moveXY(subway);
		SubwayHelper.moveXY(subway);

		Assert.assertEquals(2, subway.getX());
		Assert.assertEquals(0, subway.getY());
	}

	@Test
	public void moveXYWhenDirectionIsWest() {
		Subway subway = new Subway();
		subway.setDirection(Direction.WEST);

		SubwayHelper.moveXY(subway);
		SubwayHelper.moveXY(subway);

		Assert.assertEquals(-2, subway.getX());
		Assert.assertEquals(0, subway.getY());
	}

	@Test
	public void moveWhenCommandToTurnLeft() {
		Subway subway = new Subway();
		Direction initialDirection = subway.getDirection();

		SubwayHelper.move(Command.L, subway);

		Assert.assertEquals(0, subway.getX());
		Assert.assertEquals(0, subway.getY());
		Assert.assertEquals(0, subway.getZ());
		Assert.assertNotEquals(initialDirection, subway.getDirection());
	}

	@Test
	public void moveWhenCommandToTurnRight() {
		Subway subway = new Subway();
		Direction initialDirection = subway.getDirection();

		SubwayHelper.move(Command.R, subway);

		Assert.assertEquals(0, subway.getX());
		Assert.assertEquals(0, subway.getY());
		Assert.assertEquals(0, subway.getZ());
		Assert.assertNotEquals(initialDirection, subway.getDirection());
	}

	@Test
	public void moveWhenCommandIsMoveUp() {
		Subway subway = new Subway();
		Direction initialDirection = subway.getDirection();

		SubwayHelper.move(Command.U, subway);

		Assert.assertEquals(0, subway.getX());
		Assert.assertEquals(0, subway.getY());
		Assert.assertEquals(1, subway.getZ());
		Assert.assertEquals(initialDirection, subway.getDirection());
	}

	@Test
	public void moveWhenCommandIsMoveDown() {
		Subway subway = new Subway();
		Direction initialDirection = subway.getDirection();

		SubwayHelper.move(Command.D, subway);

		Assert.assertEquals(0, subway.getX());
		Assert.assertEquals(0, subway.getY());
		Assert.assertEquals(-1, subway.getZ());
		Assert.assertEquals(initialDirection, subway.getDirection());
	}

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
