package cofh.thermal.dynamics.client.gui.logistics;

import cofh.core.client.gui.ContainerScreenCoFH;
import cofh.core.client.gui.element.ElementButton;
import cofh.core.client.gui.element.SimpleTooltip;
import cofh.lib.util.helpers.StringHelper;
import cofh.thermal.dynamics.inventory.container.logistics.LogisticsItemBufferContainer;
import cofh.thermal.dynamics.tileentity.logistics.LogisticsItemBufferTile;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import static cofh.core.util.helpers.GuiHelper.generatePanelInfo;
import static cofh.lib.util.constants.Constants.ID_COFH_CORE;
import static cofh.lib.util.constants.Constants.ID_THERMAL;
import static cofh.lib.util.helpers.SoundHelper.playClickSound;

public class LogisticsItemBufferScreen extends ContainerScreenCoFH<LogisticsItemBufferContainer> {

    public static final String TEX_PATH = ID_THERMAL + ":textures/gui/logistics/item_buffer.png";
    public static final ResourceLocation TEXTURE = new ResourceLocation(TEX_PATH);

    public static final String TEX_MODE_LATCH_OFF = ID_COFH_CORE + ":textures/gui/filters/filter_deny_list.png";
    public static final String TEX_MODE_LATCH_ON = ID_COFH_CORE + ":textures/gui/filters/filter_allow_list.png";

    public static final String TEX_IGNORE_NBT = ID_COFH_CORE + ":textures/gui/filters/filter_ignore_nbt.png";
    public static final String TEX_USE_NBT = ID_COFH_CORE + ":textures/gui/filters/filter_use_nbt.png";

    protected LogisticsItemBufferTile tile;

    public LogisticsItemBufferScreen(LogisticsItemBufferContainer container, PlayerInventory inv, ITextComponent titleIn) {

        super(container, inv, StringHelper.getTextComponent("block.thermal.logistics_item_buffer"));
        tile = container.tile;
        texture = TEXTURE;
        info = generatePanelInfo("info.thermal.logistics_item_buffer");
        ySize = 178;
    }

    @Override
    public void init() {

        super.init();

        addButtons();
    }

    // region ELEMENTS
    protected void addButtons() {

        addElement(new ElementButton(this, 78, 27) {

            @Override
            public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {

                tile.setLatchMode(true);
                playClickSound(0.7F);
                return true;
            }
        }
                .setSize(20, 20)
                .setTexture(TEX_MODE_LATCH_OFF, 40, 20)
                .setTooltipFactory(new SimpleTooltip(new TranslationTextComponent("info.thermal.logistics_item_buffer.mode.0")))
                .setVisible(() -> !tile.getLatchMode()));

        addElement(new ElementButton(this, 78, 27) {

            @Override
            public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {

                tile.setLatchMode(false);
                playClickSound(0.4F);
                return true;
            }
        }
                .setSize(20, 20)
                .setTexture(TEX_MODE_LATCH_ON, 40, 20)
                .setTooltipFactory(new SimpleTooltip(new TranslationTextComponent("info.thermal.logistics_item_buffer.mode.1")))
                .setVisible(() -> tile.getLatchMode()));

        addElement(new ElementButton(this, 78, 51) {

            @Override
            public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {

                tile.setCheckNBT(true);
                playClickSound(0.7F);
                return true;
            }
        }
                .setSize(20, 20)
                .setTexture(TEX_IGNORE_NBT, 40, 20)
                .setTooltipFactory(new SimpleTooltip(new TranslationTextComponent("info.cofh.filter.checkNBT.0")))
                .setVisible(() -> !tile.getCheckNBT()));

        addElement(new ElementButton(this, 78, 51) {

            @Override
            public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {

                tile.setCheckNBT(false);
                playClickSound(0.4F);
                return true;
            }
        }
                .setSize(20, 20)
                .setTexture(TEX_USE_NBT, 40, 20)
                .setTooltipFactory(new SimpleTooltip(new TranslationTextComponent("info.cofh.filter.checkNBT.1")))
                .setVisible(() -> tile.getCheckNBT()));
    }
    // endregion
}