package mvf314.realisticoreprocessing;

import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;

public class CustomBlockStateProperties {
	public static final BooleanProperty HAS_CHARCOAL = BooleanProperty.create("has_charcoal");
	public static final BooleanProperty HAS_IRON = BooleanProperty.create("has_iron");

	public static final IntegerProperty LEVEL_0_6 = IntegerProperty.create("level", 0, 6);
}
