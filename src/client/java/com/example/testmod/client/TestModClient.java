package com.example.testmod.client;

import com.example.testmod.TestMod;
import net.fabricmc.api.ClientModInitializer;

public class TestModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        TestMod.LOGGER.info("[TestMod] Client initialized!");
    }
}
