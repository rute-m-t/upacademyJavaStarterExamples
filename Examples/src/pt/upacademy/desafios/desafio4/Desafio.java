package pt.upacademy.desafios.desafio4;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Desafio {

	public static int[] ints(String string) {
		if(string == "") {
			return new int[]{};
		}
		String[] arr = string.split(" ");
		List<String> list = Arrays.asList(arr);
		return list.stream().filter(s -> s.matches("\\d")).mapToInt(s -> Integer.parseInt(s)).toArray();
//		List<Integer> list = new ArrayList<Integer>();
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i].matches("\\d")) {
//				list.add(Integer.parseInt(arr[i]));
//			}
//		}
//		int[] result = new int[list.size()];
//		for(int i = 0;i < result.length;i++)
//		   result[i] = list.get(i);
//		return result;
	}

}
