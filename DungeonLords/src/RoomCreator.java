import java.util.ArrayList;


public class RoomCreator 
{
	private ArrayList<Attack> createAttacks()
	{
		ArrayList<Attack> aList = new ArrayList<Attack>();
		
		return aList;
	}
	private ArrayList<Monster> createMonsters()
	{
		ArrayList<Attack> aList = createAttacks();
		ArrayList<Monster> mList = new ArrayList<Monster>();
		mList.add(new Monster("Hound", "description", 40, item, aList.get(0));
		mList.add(new Monster("Archer", "description", 45, item, aList.get(0));
		mList.add(new Monster("Troll", "description", 50, item, aList.get(0));
		mList.add(new Monster("Skeleton", "description", 40, item, aList.get(0));
		mList.add(new Monster("Franken", "description", 50, item, aList.get(0));
		return mList;
	}
	
	public ArrayList<Room> createRooms()
	{
		ArrayList<Monster> mList = createMonsters();
		ArrayList<Room> rList = new ArrayList<Room>();
		
		return rList;
	}
}
