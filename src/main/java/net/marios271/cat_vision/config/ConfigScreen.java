package net.marios271.cat_vision.config;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screens.Screen;
//? < 1.19 {
/*import net.minecraft.network.chat.TranslatableComponent;
*///?} >= 1.19 {
import net.minecraft.network.chat.Component;
//?}

public class ConfigScreen {
    public static Screen create(Screen parent, ConfigData config) {
        ConfigBuilder builder = ConfigBuilder.create()
            .setParentScreen(parent)
            .setTitle(
				//? < 1.19 {
				/*new TranslatableComponent("text.cat_vision.config.title")
				*///?} >= 1.19 {
				Component.translatable("text.cat_vision.config.title")
				//?}
			);

        ConfigCategory category = builder.getOrCreateCategory(
			//? < 1.19 {
			/*new TranslatableComponent("text.cat_vision.config.category")
			*///?} >= 1.19 {
			Component.translatable("text.cat_vision.config.category")
			//?}
		);
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        category.addEntry(entryBuilder.startBooleanToggle(
			//? < 1.19 {
			/*new TranslatableComponent("text.cat_vision.config.option.remember_nv"),
			*///?} >= 1.19 {
			Component.translatable("text.cat_vision.config.option.remember_nv"),
			//?}
			config.remember_nv
		)
            .setDefaultValue(true)
            .setSaveConsumer(v -> config.remember_nv = v)
            .build());

		category.addEntry(entryBuilder.startBooleanToggle(
			//? < 1.19 {
			/*new TranslatableComponent("text.cat_vision.config.option.auto_nv"),
			 *///?} >= 1.19 {
			Component.translatable("text.cat_vision.config.option.auto_nv"),
			//?}
			config.auto_nv
		)
            .setDefaultValue(true)
            .setSaveConsumer(v -> config.auto_nv = v)
            .build());

        category.addEntry(entryBuilder.startBooleanToggle(
			//? < 1.19 {
			/*new TranslatableComponent("text.cat_vision.config.option.blindness_immunity"),
			*///?} >= 1.19 {
			Component.translatable("text.cat_vision.config.option.blindness_immunity"),
			//?}
			config.blindness_immunity
		)
            .setDefaultValue(true)
            .setSaveConsumer(v -> config.blindness_immunity = v)
            .setTooltip(
				//? < 1.19 {
                /*new TranslatableComponent("text.cat_vision.config.tooltip.blindness_disclaimer.1"),
                new TranslatableComponent("text.cat_vision.config.tooltip.blindness_disclaimer.2"),
                new TranslatableComponent("text.cat_vision.config.tooltip.blindness_disclaimer.3"),
                new TranslatableComponent("text.cat_vision.config.tooltip.blindness_disclaimer.4")
				*///?} >= 1.19 {
				Component.translatable("text.cat_vision.config.tooltip.blindness_disclaimer.1"),
				Component.translatable("text.cat_vision.config.tooltip.blindness_disclaimer.2"),
				Component.translatable("text.cat_vision.config.tooltip.blindness_disclaimer.3"),
				Component.translatable("text.cat_vision.config.tooltip.blindness_disclaimer.4")
				//?}
            )
            .build());

        category.addEntry(entryBuilder.startBooleanToggle(
			//? < 1.19 {
			/*new TranslatableComponent("text.cat_vision.config.option.nausea_immunity"),
			*///?} >= 1.19 {
			Component.translatable("text.cat_vision.config.option.nausea_immunity"),
			//?}
			config.nausea_immunity
		)
            .setDefaultValue(true)
            .setSaveConsumer(v -> config.nausea_immunity = v)
            .build());

		//? >= 1.19 {
		category.addEntry(entryBuilder.startBooleanToggle(Component.translatable("text.cat_vision.config.option.darkness_immunity"), config.darkness_immunity)
			.setDefaultValue(true)
			.setSaveConsumer(v -> config.darkness_immunity = v)
			.build());
		//?}

        builder.setSavingRunnable(config::save);

        return builder.build();
    }
}
