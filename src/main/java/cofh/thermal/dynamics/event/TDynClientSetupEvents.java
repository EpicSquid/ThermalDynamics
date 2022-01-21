package cofh.thermal.dynamics.event;

import cofh.thermal.dynamics.client.model.DuctModelLoader;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static cofh.lib.util.constants.Constants.ID_THERMAL_DYNAMICS;

@Mod.EventBusSubscriber (value = Dist.CLIENT, modid = ID_THERMAL_DYNAMICS, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TDynClientSetupEvents {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {

        ModelLoaderRegistry.registerLoader(new ResourceLocation(ID_THERMAL_DYNAMICS, "duct"), new DuctModelLoader());
    }

}
