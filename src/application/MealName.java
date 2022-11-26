package application;

import java.util.ArrayList;
import java.util.Collections;

public class MealName {
	private String breakfastName;
	private String lunchName;
	private String dinnerName;
	private String snack1Name;
	private String snack2Name;
	

	public MealName(String breakfast, String lunch, String dinner, String snack1, String snack2) {
		String encapsulationBreakFast = new String();
		String encapsulationLunch = new String();
		String encapsulationDinner = new String();
		String encapsulationSnack1 = new String();
		String encapsulationSnack2 = new String();
		
		encapsulationBreakFast = breakfast;
		encapsulationLunch = lunch;
		encapsulationDinner = dinner;
		encapsulationSnack1 = snack1;
		encapsulationSnack2 = snack2;
		
		breakfastName = encapsulationBreakFast;
		lunchName = encapsulationLunch;
		dinnerName = encapsulationDinner;
		snack1Name = encapsulationSnack1;
		snack2Name = encapsulationSnack2;
	}
	
	public String[] getNameList() {
		String[] nameList = new String[5];
		
		nameList[0] = breakfastName;
		nameList[1] = lunchName;
		nameList[2] = dinnerName;
		nameList[3] = snack1Name;
		nameList[4] = snack2Name;
		
		return nameList;
	}
	
	public String mostCommonMeal(String[] mealNames) {
		int index1 = 0;
		int index2 = 0;
		int index3 = 0;
		
		int occurrences0 = 0;
		int occurrences1 = 0;
		int occurrences2 = 0;
		int occurrences3 = 0;
		int occurrences4 = 0;
		
		ArrayList<String> names = new ArrayList<String>();
		
		
		while (index3 < mealNames.length) {
			names.add(mealNames[index3].toUpperCase());
			index3++;
		}
		while (index2 < mealNames.length) {
			while (index1 < mealNames.length) {
				if (mealNames[index2].toUpperCase().contains(mealNames[index1].toUpperCase()) && index2 == 0){
					occurrences0 = Collections.frequency(names, mealNames[index2].toUpperCase());
				}
				if (mealNames[index2].toUpperCase().contains(mealNames[index1].toUpperCase()) && index2 == 1){
					occurrences1 = Collections.frequency(names, mealNames[index2].toUpperCase());
				}
				if (mealNames[index2].toUpperCase().contains(mealNames[index1].toUpperCase()) && index2 == 2){
					occurrences2 = Collections.frequency(names, mealNames[index2].toUpperCase());
				}
				if (mealNames[index2].toUpperCase().contains(mealNames[index1].toUpperCase()) && index2 == 3){
					occurrences3 = Collections.frequency(names, mealNames[index2].toUpperCase());
				}
				if (mealNames[index2].toUpperCase().contains(mealNames[index1].toUpperCase()) && index2 == 4){
					occurrences4 = Collections.frequency(names, mealNames[index2].toUpperCase());
				}
				index1++;
			}
			index1 = 0;
			index2++;
		}
		int[] mealOccurrences = new int[5];
		
		mealOccurrences[0] = occurrences0;
		mealOccurrences[1] = occurrences1;
		mealOccurrences[2] = occurrences2;
		mealOccurrences[3] = occurrences3;
		mealOccurrences[4] = occurrences4;
		
		int largest = 0;
		for (int i = 1; i < mealOccurrences.length; i++) {
			if (mealOccurrences[i] > largest) largest = i;
		}
				
		
		return mealNames[largest];
	}

}
