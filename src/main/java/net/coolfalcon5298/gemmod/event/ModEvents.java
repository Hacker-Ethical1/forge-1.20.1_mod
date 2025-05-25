package net.coolfalcon5298.gemmod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.coolfalcon5298.gemmod.GemMod;
import net.coolfalcon5298.gemmod.block.ModBlocks;
import net.coolfalcon5298.gemmod.item.ModItems;
import net.coolfalcon5298.gemmod.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = GemMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // Level 1 Trade
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.STRAWBERRY.get(), 5),
                    12, 8, 0.02f));

            // Level 2 Trade
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(ModItems.STRAWBERRY_SEEDS.get(), 2),
                    12, 8, 0.02f));

        }

        if(event.getType() == VillagerProfession.LIBRARIAN) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack enchantedBook = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(Enchantments.THORNS, 2));

            // Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    enchantedBook,
                    2, 8, 0.02f));
        }

        if(event.getType() == ModVillagers.MOD_MASTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack enchantedPickaxe = new ItemStack(ModItems.SAPPHIRE_PICKAXE.get(), 1);
            ItemStack enchantedSword = new ItemStack(ModItems.SAPPHIRE_SWORD.get(), 1);
            enchantedPickaxe.enchant(Enchantments.BLOCK_FORTUNE, 1);
            enchantedPickaxe.enchant(Enchantments.BLOCK_EFFICIENCY, 2);
            enchantedSword.enchant(Enchantments.UNBREAKING, 2);
            enchantedSword.enchant(Enchantments.MOB_LOOTING, 1);
            enchantedSword.enchant(Enchantments.SHARPNESS, 1);

            // Level 1 Trades
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.PINE_CONE.get(), 64),
                    new ItemStack(Items.EMERALD, 12),
                    11, 8, 0.02f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(ModItems.SAPPHIRE.get(), 2),
                    10, 7, 0.042f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 15),
                    new ItemStack(ModItems.SAPPHIRE_CHESTPLATE.get(), 1),
                    1, 8, 0.034f));

            // Level 2 Trades
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 30),
                    new ItemStack(ModBlocks.SOUND_BLOCK.get(), 2),
                    8, 6, 0.034f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.SAPPHIRE_AXE.get(), 1),
                    new ItemStack(Items.EMERALD, 10),
                    4, 7, 0.053f));

            // Level 3 Trades
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.METAL_DETECTOR.get(), 1),
                    new ItemStack(Items.EMERALD, 30),
                    4, 9, 0.034f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 25),
                    new ItemStack(ModItems.CORN_SEEDS.get(), 1),
                    8, 9, 0.062f));

            // Level 4 Trades
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 35),
                    new ItemStack(ModItems.METAL_DETECTOR.get(), 1),
                    4, 8, 0.034f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    enchantedPickaxe,
                    4, 9, 0.041f));

            // Level 5 Trades
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 64),
                    new ItemStack(ModItems.SAPPHIRE_STAFF.get(), 1),
                    1, 10, 0.053f));
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 64),
                    enchantedSword,
                    1, 10, 0.053f));
        }
    }

    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 12),
                new ItemStack(ModItems.SAPPHIRE.get(), 3),
                10, 2, 0.2f));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 32),
                new ItemStack(ModItems.METAL_DETECTOR.get(), 1),
                1, 6, 0.35f));
        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 48),
                new ItemStack(ModItems.RHINO_SPAWN_EGG.get(), 1),
                1, 6, 0.35f));
    }

}
