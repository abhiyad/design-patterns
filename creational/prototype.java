abstract class Shape implements Cloneable{
	private String id;
	protected String type;
	abstract void draw();
	public String getType(){return type;}
	public String getId(){return this.id;}
	public void setId(String id){this.id = id;}
	public Object clone(){
		Object clone = null;
		try{
			clone = super.clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
}
//////////
class Square extends Shape{
	public Square(){
		type = "SQUARE";
	} 
	@Override
	public void draw(){
		SOPLN("IN SQUARE DRAW");
	}

	//WE DONT OVERRIDE CLONE IF SUBCLASS DOESNT HAVE NEW MEMBER VARIABLE
}


class Circle extends Shape{
	public Square(){
		type = "CIRCLE";
	} 
	@Override
	public void draw(){
		SOPLN("IN CIRCLE DRAW");
	}

	//WE DONT OVERRIDE CLONE IF SUBCLASS DOESNT HAVE NEW MEMBER VARIABLE
}

//////

public class ShapeCache{
	private static Hashtable<String,Shape> shapeMap = new Hashtable<String,Shape>();
	public static Shape getShape(String id){
		Shape cachedShape = shapeMap.get(id);
		return (Shape) cachedShape.clone();
	}
	public static void loadCache(){
		Circle circle = new Circle();
		circle.setId("1");
		shapeMap.put(circle.getId(),circle);

		Square square = new Square();
		square.setId("2");
		shapeMap.put(square.getId(),square);
	}
}

//// 
public class Client{
	public static void main(){
		ShapeCache.loadCache();
		Shape clonedShape = (Shape) ShapeCache.getShape("1");
		SOPLN(clonedShape.getType());
	}
}