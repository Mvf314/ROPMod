package mvf314.realisticoreprocessing.datagen;

import mvf314.mvflib.datagen.BaseRecipeProvider;
import mvf314.realisticoreprocessing.ModItems;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Items;

import java.util.function.Consumer;

public class Recipes extends BaseRecipeProvider {
	public Recipes(DataGenerator gen, String modid) {
		super(gen, modid);
	}

	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		addShapelessRecipe(ModItems.WROUGHT_IRON_CARBON_COMPOUND)
				.addIngredient(Items.CHARCOAL, 2)
				.addIngredient(ModItems.WROUGHT_IRON_INGOT)
				.addCriterion("hasCharcoal", InventoryChangeTrigger.Instance.forItems(Items.CHARCOAL))
				.addCriterion("hasWrought", InventoryChangeTrigger.Instance.forItems(ModItems.WROUGHT_IRON_INGOT))
				.build(consumer);
	}

	@Override
	public String getName() {
		return "Realistic Ore Processing Recipes";
	}
}
