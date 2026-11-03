package dev.xiaoyu.xiaoxiang_cultivation_world_expand;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(XiaoxiangCultivationWorldExpand.MOD_ID)
public class XiaoxiangCultivationWorldExpand {
    public static final String MOD_ID = "xiaoxiang_cultivation_world_expand";
    public static final String MODID = MOD_ID;
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public XiaoxiangCultivationWorldExpand() {
        var modBus = FMLJavaModLoadingContext.get().getModEventBus();
        var modCtx = ModLoadingContext.get();
    }
}