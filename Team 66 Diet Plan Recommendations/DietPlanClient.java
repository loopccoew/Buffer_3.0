package client;
import java.util.*;
import java.util.Map.Entry;

public class DietPlanClient{
	private static String final_plan;

	
	public static void main(String[] args) {
		

		Map<DietPlan,String> map1 = new HashMap<>();
		DietPlan d1 = new DietPlan("18+","30-40");
		DietPlan d2 = new DietPlan("18+","40-50");
		DietPlan d3 = new DietPlan("18+","50-60");
		DietPlan d4 = new DietPlan("18+","60-70");
		DietPlan d5 = new DietPlan("18+","70-80");
		DietPlan d6 = new DietPlan("18+","80-above");
		DietPlan d7 = new DietPlan("30-40","30-40");
		DietPlan d8 = new DietPlan("30-40","40-50");
		DietPlan d9 = new DietPlan("30-40","50-60");
		DietPlan d10 = new DietPlan("30-40","60-70");
		DietPlan d11 = new DietPlan("30-40","70-80");
		DietPlan d12 = new DietPlan("30-40","80 Above");
		DietPlan d13 = new DietPlan("40-50","30-40");
		DietPlan d14 = new DietPlan("40-50","40-50");
		DietPlan d15 = new DietPlan("40-50","50-60");
		DietPlan d16 = new DietPlan("40-50","60-70");
		DietPlan d17 = new DietPlan("40-50","70-80");
		DietPlan d18 = new DietPlan("40-50","80 Above");
		DietPlan d19 = new DietPlan("50-60","30-40");
		DietPlan d20 = new DietPlan("50-60","40-50");
		DietPlan d21 = new DietPlan("50-60","50-60");
		DietPlan d22 = new DietPlan("50-60","60-70");
		DietPlan d23 = new DietPlan("50-60","70-80");
		DietPlan d24 = new DietPlan("50-60","80 Above");
		DietPlan d25 = new DietPlan("60-70","30-40");
		DietPlan d26 = new DietPlan("60-70","40-50");
		DietPlan d27 = new DietPlan("60-70","50-60");
		DietPlan d28 = new DietPlan("60-70","60-70");
		DietPlan d29 = new DietPlan("60-70","70-80");
		DietPlan d30 = new DietPlan("60-70","80 Above");
		DietPlan d31 = new DietPlan("70-above","30-40");
		DietPlan d32 = new DietPlan("70-above","40-50");
		DietPlan d33 = new DietPlan("70-above","50-60");
		DietPlan d34 = new DietPlan("70-above","60-70");
		DietPlan d35 = new DietPlan("70-above","70-80");
		DietPlan d36 = new DietPlan("70-above","80 Above");
		map1.put(d1, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with honey"
				+ "& 1 bowl of pomegranet/melons/citrus fruits etc."
				+ "\n\n Lunch \t\t 1 bowl of steamed sprout with salad"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream and sauteed vegetables+chapati");
		map1.put(d2, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with honey"
				+ "& 1 bowl of pomegranet/melons/citrus fruits etc."
				+ "\n\n Lunch \t\t 1 bowl of steamed sprout with salad"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream and sauteed vegetables+chapati");
		map1.put(d3, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with honey"
				+ "& 1 bowl of pomegranet/melons/citrus fruits,oats etc."
				+ "\n\n Lunch \t\t 1 bowl of steamed sprout with salad,green leafy vegetables"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream and sauteed vegetables+chapati");
		map1.put(d4, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with honey"
				+ "& 1 bowl of pomegranet/melons/citrus fruits,oats etc."
				+ "\n\n Lunch \t\t 1 bowl of steamed sprout with salad,green leafy vegetables"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream");
		map1.put(d5, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with honey"
				+ "& 1 bowl of pomegranet/melons/citrus fruits,1 toasted brown bread + 1/2 cup low fat milk (no sugar) etc."
				+ "\n\n Lunch \t\t 1 cup arhar dal + 1 chapatti + 1/2 cup low fat curd + salad"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream and sauteed vegetables");
		map1.put(d6, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with honey"
				+ "& 1 bowl of pomegranet/melons/citrus fruits, 1/2 cup low fat milk (no sugar) etc."
				+ "\n\n Lunch \t\t 1 cup arhar dal + 1 chapatti + 1/2 cup low fat curd + salad"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream and sauteed vegetables");
		map1.put(d7, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with honey"
				+ "& 3 egg whites + 1 toasted brown bread + 1/2 cup low fat milk (no sugar) etc."
				+ "\n\n Lunch \t\t 1 cup arhar dal + 1 chapatti + 1/2 cup low fat curd + salad"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream and sauteed vegetables+ 1 chapati");
		map1.put(d8, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with honey"
				+ "& 3 egg whites + 1 toasted brown bread + 1/2 cup low fat milk (no sugar) etc."
				+ "\n\n Lunch \t\t 1 cup arhar dal + 1 chapatti + 1/2 cup low fat curd + salad"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream and sauteed vegetables+ 1 chapati");
		map1.put(d9, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with honey"
				+ "& 3 egg whites + 1 toasted brown bread + 1/2 cup low fat milk (no sugar) etc."
				+ "\n\n Lunch \t\t 1 cup arhar dal + 1 chapatti + 1/2 cup low fat curd + salad"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream and sauteed vegetables+ 1 chapati");
		map1.put(d10, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with honey"
				+ "& 3 egg whites + 1 toasted brown bread + 1/2 cup low fat milk (no sugar) etc."
				+ "\n\n Lunch \t\t 1 cup arhar dal + 1 chapatti  + salad"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream and sauteed vegetables");
		map1.put(d11, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with honey"
				+ "& fruits + 1 toasted brown bread + 1/2 cup low fat milk (no sugar) etc."
				+ "\n\n Lunch \t\t 1 cup arhar dal + 1 chapatti + 1/2 cup low fat curd + salad"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream");
		map1.put(d12, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with honey"
				+ "& fruits,oats etc."
				+ "\n\n Lunch \t\t 1 cup arhar dal + 1 chapatti + 1/2 cup low fat curd + salad"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream and sauteed vegetables");
		map1.put(d13, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with honey"
				+ "& 2 egg brown bread sandwich + green chutney + 1 cup milk + 3 cashews + 4 almonds + 2 walnuts."
				+ "\n\n Lunch \t\t 1 cup arhar dal + 1 cup potato curry + 3 chapatti + 1/2 cup rice + 1/2 cup low fat curd + salad"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream and sauteed vegetables+ 1 chapati");
		map1.put(d14, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with honey"
				+ "& 2 egg brown bread sandwich + green chutney + 1 cup milk + 3 cashews + 4 almonds + 2 walnuts."
				+ "\n\n Lunch \t\t 1 cup arhar dal + 1 cup potato curry + 3 chapatti + 1/2 cup rice + 1/2 cup low fat curd + salad"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream and sauteed vegetables+ 1 chapati");
		map1.put(d15, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with honey"
				+ "& 2 egg brown bread sandwich + green chutney + 1 cup milk + 3 cashews + 4 almonds + 2 walnuts."
				+ "\n\n Lunch \t\t 1 cup arhar dal + 3 chapatti + 1/2 cup rice + 1/2 cup low fat curd + salad"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream and sauteed vegetables");
		map1.put(d16, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with honey"
				+ "& 2 egg brown bread sandwich + green chutney + 1 cup milk + 3 cashews + 4 almonds + 2 walnuts."
				+ "\n\n Lunch \t\t 1 cup arhar dal  + 2 chapatti + 1/2 cup rice + 1/2 cup low fat curd + salad"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream and sauteed vegetables");
		map1.put(d17, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with Lemon"
				+ "& 3 egg whites + 1 toasted brown bread + 1/2 cup low fat milk (no sugar)"
				+ "\n\n Lunch \t\t 1 cup arhar dal + 1 chapatti + 1/2 cup low fat curd + salad"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream and sauteed vegetables");
		map1.put(d18, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with Lemon"
				+ "& 3 egg whites + 1 toasted brown bread + 1/2 cup low fat milk (no sugar)"
				+ "\n\n Lunch \t\t 1 cup arhar dal + 1 chapatti  + salad"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream and sauteed vegetables");
		map1.put(d19, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with honey"
				+ "& 3 egg whites + 1 toasted brown bread + 1/2 cup low fat milk (no sugar) or fruits"
				+ "\n\n Lunch \t\t 1 cup arhar dal + 2 chapatti + 1/2 cup low fat curd + salad"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream and sauteed vegetables+ 1 chapati");
		map1.put(d20, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with honey"
				+ "& Oats + 1/2 cup low fat milk (no sugar) or fruits"
				+ "\n\n Lunch \t\t 1 cup arhar dal + 2 chapatti + 1/2 cup low fat curd + salad"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream and sauteed vegetables + 1 chapati");
		map1.put(d21, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with honey"
				+ "& Oats + 1/2 cup low fat milk (no sugar) or fruits"
				+ "\n\n Lunch \t\t 1 cup arhar dal + 2 chapatti + 1/2 cup low fat curd + salad"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream and sauteed vegetables + 1 chapati");
		map1.put(d22, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with Lemon"
				+ "& fruits  + 1/2 cup low fat milk (no sugar)"
				+ "\n\n Lunch \t\t 1 cup arhar dal + 1 chapatti + 1/2 cup low fat curd + salad"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream and sauteed vegetables + 1 chapati");
		map1.put(d23, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with Lemon"
				+ "& fruits  + 1/2 cup low fat milk (no sugar)"
				+ "\n\n Lunch \t\t 1 cup arhar dal + 2 chapatti + 1/2 cup low fat curd + salad + sprouts"
				+ "\n\n Dinner\t\t 1 bowl of vegetable soup+stream and sauteed vegetables");
		map1.put(d24, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with Lemon"
				+ "& fruits  + 1/2 cup low fat milk (no sugar)"
				+ "\n\n Lunch \t\t 1 cup arhar dal + 1 chapatti + 1/2 cup low fat curd + salad + sprouts "
				+ "\n\n Dinner\t\t daliyaa +stream and sauteed vegetables");
		map1.put(d25, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with Lemon"
				+ "& fruits + Smoothie with spinach, and yogurt"
				+ "\n\n Lunch \t\t tomato, avocado sandwich on whole-grain bread\r\n"
				+ "Quinoa with stir-fried vegetables "
				+ "\n\n Dinner\t\t 1 cup arhar dal + 1 chapatti + salad + sprouts ");
		map1.put(d26, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with Lemon"
				+ "& fruits + Smoothie with spinach, and yogurt"
				+ "\n\n Lunch \t\t tomato, avocado sandwich on whole-grain bread\r\n"
				+ "Quinoa with stir-fried vegetables "
				+ "\n\n Dinner\t\t 1 cup arhar dal + 1 chapatti + salad + sprouts ");
		map1.put(d27, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with Lemon"
				+ "& fruits + Smoothie with spinach, and yogurt"
				+ "\n\n Lunch \t\t tomato, avocado sandwich on whole-grain bread\r\n"
				+ "Quinoa with stir-fried vegetables "
				+ "\n\n Dinner\t\t 1 cup arhar dal + 1 chapatti + salad + sprouts ");
		map1.put(d28, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with Lemon"
				+ "& fruits + Smoothie with spinach, and yogurt"
				+ "\n\n Lunch \t\t tomato, green vegetables + 1 chapati\r\n"
				+ "Quinoa with stir-fried vegetables "
				+ "\n\n Dinner\t\t 1 cup arhar dal + 1 chapatti + salad + sprouts ");
		map1.put(d29, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with Lemon"
				+ "& fruits + Smoothie with spinach, and yogurt"
				+ "\n\n Lunch \t\t tomato, green vegetables + 1 chapati\r\n"
				+ "Quinoa with stir-fried vegetables "
				+ "\n\n Dinner\t\t 1 cup arhar dal + salad + sprouts ");
		map1.put(d30, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with Lemon"
				+ "& fruits + Smoothie with spinach, and yogurt"
				+ "\n\n Lunch \t\t tomato, green vegetables + 1 chapati\r\n"
				+ "Quinoa with stir-fried vegetables "
				+ "\n\n Dinner\t\t 1 cup arhar dal + salad + sprouts ");
		map1.put(d31, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with Lemon"
				+ "& fruits + Smoothie with spinach, and yogurt"
				+ "\n\n Lunch \t\t tomato + 1 chapati\r\n"
				+ "Quinoa with stir-fried vegetables "
				+ "\n\n Dinner\t\t 1 cup arhar dal + 1 chapatti + salad + sprouts ");
		map1.put(d32, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with Lemon"
				+ "& fruits + Smoothie with spinach, and yogurt"
				+ "\n\n Lunch \t\t tomato, green vegetables + 1 chapati\r\n"
				+ "Quinoa with stir-fried vegetables "
				+ "\n\n Dinner\t\t 1 cup arhar dal + 1 chapatti + salad + sprouts ");
		map1.put(d33, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with Lemon"
				+ "& fruits + Smoothie with spinach, and yogurt"
				+ "\n\n Lunch \t\t tomato + 1 chapati\r\n"
				+ "Quinoa with stir-fried vegetables "
				+ "\n\n Dinner\t\t 1 cup arhar dal + salad + sprouts ");
		map1.put(d34, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with Lemon"
				+ "& fruits + Smoothie with spinach, fruit, and yogurt"
				+ "\n\n Lunch \t\t tomato + 1 chapati\r\n"
				+ "Quinoa with stir-fried vegetables "
				+ "\n\n Dinner\t\t porridge + salad + sprouts ");
		map1.put(d35, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with Lemon"
				+ "& fruits + Smoothie with spinach, fruit, and yogurt"
				+ "\n\n Lunch \t\t tomato + 1 chapati\r\n"
				+ "Quinoa with stir-fried vegetables "
				+ "\n\n Dinner\t\t porridge + salad");
		map1.put(d36, "\n\nMeal type\t\t What to eat"
				+ "\n\nBreakfast \t\t 1 glass of warm water with Lemon"
				+ "& fruits + Smoothie with spinach, fruit, and yogurt"
				+ "\n\n Lunch \t\t tomato + 1 chapati\r\n"
				+ "Quinoa with stir-fried vegetables "
				+ "\n\n Dinner\t\t porridge + salad");
				
//		Map<String, List<String>> l = new HashMap<>();
		
		for(Entry<DietPlan, String> entry: map1.entrySet() )
		{
			String age = entry.getKey().getAge();
			String weight = entry.getKey().getWeight();
			String plan = entry.getValue();
			female_dp temp = new female_dp();
			String age1 = temp.getAge();
			String weight1 = temp.getWeight();
			//System.out.println(weight1);
			if(age.compareTo(age1)==0)
			{
				if(weight.compareTo(weight1)==0)
				{
					//System.out.println(plan);
					DietPlanClient d = new DietPlanClient();
					d.setPlan(plan);
					Dietplan_1 abc = new Dietplan_1();
					
					//System.out.println(final_plan);
					break;
				}
			}
		}
//		DietPlanClient d = new DietPlanClient();
//		d.getplan();
		
		
		
	}
	
	public void setPlan(String plan)
	{
		final_plan = plan;
	}
	public String getPlan()
	{
		return final_plan;
	}

}
