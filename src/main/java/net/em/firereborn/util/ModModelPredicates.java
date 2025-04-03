package net.em.firereborn.util;

import net.em.firereborn.FireReborn;
import net.em.firereborn.component.ModDataComponentTypes;
import net.em.firereborn.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicates {
    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.BURNER, Identifier.of(FireReborn.MOD_ID, "used"),
                (stack, world, entity, seed) -> stack.get(ModDataComponentTypes.COORDINATES) != null ? 1f : 0f);
    }
}
