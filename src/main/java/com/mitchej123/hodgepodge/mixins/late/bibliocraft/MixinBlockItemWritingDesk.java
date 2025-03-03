package com.mitchej123.hodgepodge.mixins.late.bibliocraft;

import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import jds.bibliocraft.blocks.BlockItemWritingDesk;

@Mixin(BlockItemWritingDesk.class)
public class MixinBlockItemWritingDesk {

    @Final
    @Shadow
    private static String[] subName;

    @Inject(method = "getUnlocalizedName", at = @At("HEAD"), cancellable = true)
    private void hodgepodge$getUnlocalizedName(ItemStack itemstack, CallbackInfoReturnable<String> cir) {
        if (itemstack.getItemDamage() > subName.length) cir.setReturnValue("invalidWritingDesk");
    }

}
