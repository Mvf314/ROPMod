package mvf314.realisticoreprocessing.datagen;

import mvf314.mvflib.datagen.BaseRecipeProvider;
import mvf314.realisticoreprocessing.ModBlocks;
import mvf314.realisticoreprocessing.ModItems;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.block.Blocks;
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
				.addIngredient(ModItems.WROUGHT_IRON_CHUNK)
				.addCriterion("hasCharcoal", InventoryChangeTrigger.Instance.forItems(Items.CHARCOAL))
				.addCriterion("hasWrought", InventoryChangeTrigger.Instance.forItems(ModItems.WROUGHT_IRON_CHUNK))
				.build(consumer);

		addShapedRecipe(ModItems.PIPE,
				" s ","s s"," s ")
				.key('s', Blocks.STONE)
				.addCriterion("stone", InventoryChangeTrigger.Instance.forItems(Blocks.STONE))
				.build(consumer);

		addShapedRecipe(ModBlocks.BLOOMERY,
				" b ", "b b", "psb")
				.key('b', Items.BRICK)
				.key('p', ModItems.PIPE)
				.key('s', Items.STONE_SLAB)
				.addCriterion("brick", InventoryChangeTrigger.Instance.forItems(Items.BRICK))
				.addCriterion("pipe", InventoryChangeTrigger.Instance.forItems(ModItems.PIPE))
				.addCriterion("stoneSlab", InventoryChangeTrigger.Instance.forItems(Blocks.STONE_SLAB))
				.build(consumer);

		addShapedRecipe(ModBlocks.BELLOWS,
				"www", "l l", "wwp")
				.key('w', Items.OAK_SLAB)
				.key('l', Items.LEATHER)
				.key('p', ModItems.PIPE)
				.addCriterion("wood", InventoryChangeTrigger.Instance.forItems(Blocks.OAK_SLAB))
				.addCriterion("leather", InventoryChangeTrigger.Instance.forItems(Items.LEATHER))
				.addCriterion("pipe", InventoryChangeTrigger.Instance.forItems(ModItems.PIPE))
				.build(consumer);
	}

	@Override
	public String getName() {
		return "Realistic Ore Processing Recipes";
	}
}
