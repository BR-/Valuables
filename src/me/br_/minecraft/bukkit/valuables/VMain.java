package me.br_.minecraft.bukkit.valuables;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import net.minecraft.server.Block;
import net.minecraft.server.CraftingManager;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.ShapedRecipes;

import org.bukkit.plugin.java.JavaPlugin;

public class VMain extends JavaPlugin {
	public void onEnable() {
		Set<Integer> forbidden = new HashSet<Integer>();
		forbidden.add(264);
		forbidden.add(265);
		forbidden.add(266);
		forbidden.add(351);
		forbidden.add(22);
		forbidden.add(41);
		forbidden.add(42);
		forbidden.add(57);
		Iterator<?> itr = CraftingManager.a().b().iterator();
		while (itr.hasNext()) {
			Object o = itr.next();
			if (o instanceof ShapedRecipes) {
				if (forbidden.contains(((ShapedRecipes) o).a)) {
					itr.remove();
				}
			}
		}
		Object[][] a = {
				{ Block.GOLD_BLOCK, new ItemStack(Item.GOLD_INGOT, 4) },
				{ Block.IRON_BLOCK, new ItemStack(Item.IRON_INGOT, 4) },
				{ Block.DIAMOND_BLOCK, new ItemStack(Item.DIAMOND, 4) },
				{ Block.LAPIS_BLOCK, new ItemStack(Item.INK_SACK, 4, 4) } };
		for (int i = 0; i < a.length; i++) {
			Block localBlock = (Block) a[i][0];
			ItemStack localItemStack = (ItemStack) a[i][1];
			CraftingManager
					.a()
					.b()
					.add(new ShapedRecipes(2, 2, new ItemStack[] {
							localItemStack, localItemStack, localItemStack,
							localItemStack }, new ItemStack(localBlock)));
			CraftingManager.a().a(localItemStack,
					new Object[] { "#", Character.valueOf('#'), localBlock });
		}
		System.out.println("[Valuables] Finished changing recipes.");
	}

	public void onDisable() {
	}
}
