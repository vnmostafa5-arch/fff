package com.example.testmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {

    public static final String MOD_ID = "testmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // كل تيك = 1/20 ثانية، في الدقيقة 1200 تيك، في الساعة 72000 تيك
    private static final long TICKS_PER_MINUTE = 1200L;
    private static final long TICKS_PER_HOUR   = 72000L;

    @Override
    public void onInitialize() {
        LOGGER.info("[TestMod] تم التحميل بنجاح على Minecraft 26.1.2!");

        // كل ما يبدأ العالم، نسجل الوقت الحالي
        ServerTickEvents.END_SERVER_TICK.register(this::onServerTick);
    }

    private void onServerTick(MinecraftServer server) {
        // نشغل الحساب كل دقيقة واحدة (1200 تيك) فقط لتجنب الإغراق
        long ticks = server.getTickCount();

        if (ticks % TICKS_PER_MINUTE != 0) return;

        long totalMinutes = ticks / TICKS_PER_MINUTE;
        long hours   = totalMinutes / 60;
        long minutes = totalMinutes % 60;

        LOGGER.info("[TestMod] الوقت منذ بدء العالم: {} ساعة و {} دقيقة (إجمالي {} تيك)",
                hours, minutes, ticks);

        // أيضاً نبث رسالة لكل اللاعبين كل ساعة
        if (ticks % TICKS_PER_HOUR == 0 && ticks > 0) {
            String message = String.format("§6[TestMod] §fمضى على هذا العالم: §e%d ساعة§f!", hours);
            server.getPlayerManager().getPlayerList().forEach(player ->
                    player.sendMessage(net.minecraft.text.Text.literal(message))
            );
        }
    }
}
