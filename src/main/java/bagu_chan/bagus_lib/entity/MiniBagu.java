package bagu_chan.bagus_lib.entity;

import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.armortrim.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

//example Entity
public class MiniBagu extends PathfinderMob {
    public MiniBagu(EntityType<? extends PathfinderMob> p_21683_, Level p_21684_) {
        super(p_21683_, p_21684_);
    }

    public static AttributeSupplier.Builder createAttributeMap() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double) 0.3F).add(Attributes.MAX_HEALTH, 24.0D).add(Attributes.FOLLOW_RANGE, 24.0D).add(Attributes.ATTACK_DAMAGE, 2.0F);
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_21434_, DifficultyInstance p_21435_, MobSpawnType p_21436_, @Nullable SpawnGroupData p_21437_, @Nullable CompoundTag p_21438_) {
        ItemStack stack = new ItemStack(Items.IRON_HELMET);
        Optional<Holder.Reference<TrimMaterial>> optional1 = TrimMaterials.getFromIngredient(p_21434_.registryAccess(), new ItemStack(Items.LAPIS_LAZULI));
        Optional<Holder.Reference<TrimPattern>> optional2 = TrimPatterns.getFromTemplate(p_21434_.registryAccess(), new ItemStack(Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE));
        if (optional1.isPresent() && optional2.isPresent()) {
            ArmorTrim.setTrim(p_21434_.registryAccess(), stack, new ArmorTrim(optional1.get(), optional2.get()));
            this.setItemSlot(EquipmentSlot.HEAD, stack);
        }
        return super.finalizeSpawn(p_21434_, p_21435_, p_21436_, p_21437_, p_21438_);
    }
}
