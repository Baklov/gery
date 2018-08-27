package JPMorgan;
import java.util.ArrayList;

public class JPMorganMain {
	public static void main(String[] args) {
		String message1 ="apple at 10p";
		String message2 ="20 sales of apples at 10p each";
		String message3 ="Add 20p apples";
		ArrayList messages = new ArrayList<>();
		messages.add((new JPMessageType1(new JPProduct("apple",10))));
		messages.add((new JPMessageType2(new JPProduct("apple",10),1)));
		messages.add((new JPMessageType3(new JPProduct("apple",5),JPTypeOfOperation.SUB)));
		messages.add((new JPMessageType1(new JPProduct("cherry",10))));
		messages.add((new JPMessageType2(new JPProduct("cherry",10),20)));
		messages.add((new JPMessageType3(new JPProduct("cherry",5),JPTypeOfOperation.SUB)));
		messages.add((new JPMessageType1(new JPProduct("peach",10))));
		messages.add((new JPMessageType2(new JPProduct("peach",10),20)));
		messages.add((new JPMessageType3(new JPProduct("peach",50),JPTypeOfOperation.ADD)));
		messages.add((new JPMessageType1(new JPProduct("milk",10))));
		messages.add((new JPMessageType2(new JPProduct("milk",10),20)));
		messages.add((new JPMessageType3(new JPProduct("milk",2),JPTypeOfOperation.MUL)));
		messages.add((new JPMessageType1(new JPProduct("bread",10))));
		messages.add((new JPMessageType2(new JPProduct("bread",10),20)));
		messages.add((new JPMessageType3(new JPProduct("bread",10),JPTypeOfOperation.SUB)));
	
		messages.add((new JPMessageType1(new JPProduct("meat1",10))));
		messages.add((new JPMessageType2(new JPProduct("meat1",10),20)));
		messages.add((new JPMessageType3(new JPProduct("meat1",10),JPTypeOfOperation.SUB)));
		messages.add((new JPMessageType1(new JPProduct("pork1",10))));
		messages.add((new JPMessageType2(new JPProduct("pork1",10),20)));
		messages.add((new JPMessageType3(new JPProduct("pork1",10),JPTypeOfOperation.SUB)));
		messages.add((new JPMessageType1(new JPProduct("mineral water1",10))));
		messages.add((new JPMessageType2(new JPProduct("mineral water1",10),20)));
		messages.add((new JPMessageType3(new JPProduct("mineral water1",10),JPTypeOfOperation.SUB)));
		messages.add((new JPMessageType1(new JPProduct("coca cola1",10))));
		messages.add((new JPMessageType2(new JPProduct("coca cola1",10),20)));
		messages.add((new JPMessageType3(new JPProduct("coca cola1",10),JPTypeOfOperation.SUB)));
		messages.add((new JPMessageType1(new JPProduct("milk chocolade1",10))));
		messages.add((new JPMessageType2(new JPProduct("milk chokolade1",10),20)));
		messages.add((new JPMessageType3(new JPProduct("milk chokolade1",10),JPTypeOfOperation.SUB)));

		messages.add((new JPMessageType1(new JPProduct("meat",10))));
		messages.add((new JPMessageType2(new JPProduct("meat",10),20)));
		messages.add((new JPMessageType3(new JPProduct("meat",10),JPTypeOfOperation.ADD)));
		messages.add((new JPMessageType1(new JPProduct("pork",10))));
		messages.add((new JPMessageType2(new JPProduct("pork",10),20)));
		messages.add((new JPMessageType3(new JPProduct("pork",10),JPTypeOfOperation.ADD)));
		messages.add((new JPMessageType1(new JPProduct("mineral water",10))));
		messages.add((new JPMessageType2(new JPProduct("mineral water",10),20)));
		messages.add((new JPMessageType3(new JPProduct("mineral water",10),JPTypeOfOperation.ADD)));
		messages.add((new JPMessageType1(new JPProduct("coca cola",10))));
		messages.add((new JPMessageType2(new JPProduct("coca cola",10),20)));
		messages.add((new JPMessageType3(new JPProduct("coca cola",10),JPTypeOfOperation.ADD)));
		messages.add((new JPMessageType1(new JPProduct("milk chocolade",10))));
		messages.add((new JPMessageType2(new JPProduct("milk chokolade",10),20)));
		messages.add((new JPMessageType3(new JPProduct("milk chokolade",10),JPTypeOfOperation.ADD)));

		messages.add((new JPMessageType1(new JPProduct("sugar",10))));
		messages.add((new JPMessageType2(new JPProduct("sugar",10),20)));
		messages.add((new JPMessageType3(new JPProduct("sugar",10),JPTypeOfOperation.SUB)));
		messages.add((new JPMessageType1(new JPProduct("brown sugar",10))));
		messages.add((new JPMessageType2(new JPProduct("brown sugar",10),20)));
		messages.add((new JPMessageType3(new JPProduct("brown sugar",10),JPTypeOfOperation.SUB)));
		messages.add((new JPMessageType1(new JPProduct("gum",10))));
		messages.add((new JPMessageType2(new JPProduct("gum",10),20)));
		messages.add((new JPMessageType3(new JPProduct("gum",10),JPTypeOfOperation.SUB)));
		messages.add((new JPMessageType1(new JPProduct("dark chocolade",10))));
		messages.add((new JPMessageType2(new JPProduct("dark chocolade",10),20)));
		messages.add((new JPMessageType3(new JPProduct("dark chocolade",10),JPTypeOfOperation.SUB)));
		messages.add((new JPMessageType1(new JPProduct("bean",10))));
		messages.add((new JPMessageType2(new JPProduct("bean",10),20)));
		messages.add((new JPMessageType3(new JPProduct("bean",10),JPTypeOfOperation.SUB)));
		
		messages.add((new JPMessageType1(new JPProduct("grape",10))));
		messages.add((new JPMessageType2(new JPProduct("grape",10),20)));
		messages.add((new JPMessageType3(new JPProduct("grape",10),JPTypeOfOperation.MUL)));
		messages.add((new JPMessageType1(new JPProduct("beef",10))));
		messages.add((new JPMessageType2(new JPProduct("beef",10),20)));
		messages.add((new JPMessageType3(new JPProduct("beef",10),JPTypeOfOperation.MUL)));
		messages.add((new JPMessageType1(new JPProduct("chicken",10))));
		messages.add((new JPMessageType2(new JPProduct("chicken",10),20)));
		messages.add((new JPMessageType3(new JPProduct("chicken",10),JPTypeOfOperation.MUL)));
		messages.add((new JPMessageType1(new JPProduct("rum",10))));
		messages.add((new JPMessageType2(new JPProduct("rum",10),20)));
		messages.add((new JPMessageType3(new JPProduct("rum",10),JPTypeOfOperation.MUL)));
		messages.add((new JPMessageType1(new JPProduct("beer",10))));
		messages.add((new JPMessageType2(new JPProduct("beer",10),20)));
		messages.add((new JPMessageType3(new JPProduct("beer",10),JPTypeOfOperation.MUL)));

		JPWorkWithMessages work = new JPWorkWithMessages();
		work.doMessages(messages);
	}

}
