// http://1point3acres.com/bbs/forum.php?mod=viewthread&tid=200061&extra=page%3D4&mobile=2

import java.util.*;

public class pretty_json{
	public static void pretty(String s){
		if(s == null || s.length() == 0 ){
			return;
		}

		int indent = 0;
		boolean isLastLineBreak = false; //If the last char results in linebreak

		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == ' ') continue;

			boolean isEnd = s.charAt(i) == ']' || s.charAt(i) == '}';
			boolean isBegin = s.charAt(i) == '[' || s.charAt(i) == '{';
			boolean isComma = s.charAt(i) == ',';

			if(isEnd){ // "]" "}" should always be preceded by linebreak
				indent -= 2;
				System.out.println("");
				isLastLineBreak = true;
			}

			if(isLastLineBreak){ // If a new line begins, indent it.
				for(int j = 0; j < indent; j++){
					System.out.print(" ");
				}
			}

			if(isBegin){
				indent += 2;
			}
			isLastLineBreak = isBegin || isComma;
			System.out.print(s.charAt(i));
			if (isLastLineBreak) System.out.println();
		}
	}

	public static void main(String[] args){
		pretty("[1,2,3, {\"id\": 1, \"name\": \"wang\", \"tag\":[1,\"home\",2], \"price\":234}]");
	}
}