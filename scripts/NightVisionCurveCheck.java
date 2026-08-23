import net.marios271.cat_vision.config.VisionSettings;

// javac -d build/nv-check src/main/java/net/marios271/cat_vision/config/VisionSettings.java scripts/NightVisionCurveCheck.java
// java -ea -cp build/nv-check NightVisionCurveCheck

public class NightVisionCurveCheck {
	public static void main(String[] args) {
		VisionSettings settings = new VisionSettings();

		assert settings.strengthFor(0) == settings.nv_dark : "pitch black should use full night vision";
		assert settings.strengthFor(settings.nv_lit_light) == settings.nv_lit : "lit should use the lit strength";
		assert settings.strengthFor(15) == settings.nv_lit : "above the threshold stays at the lit strength";

		for (int light = 1; light <= 15; light++)
			assert settings.strengthFor(light) <= settings.strengthFor(light - 1) : "strength must not rise with light";

		VisionSettings early = settings.copy();
		early.nv_shape = 0.5;
		VisionSettings late = settings.copy();
		late.nv_shape = 2.0;
		assert early.strengthFor(6) > late.strengthFor(6) : "a lower exponent must brighten earlier";

		VisionSettings edited = settings.copy();
		edited.nv_shape = 0.0;
		assert edited.strengthFor(15) == edited.nv_lit : "a curve shape of 0 must not brighten daylight";
		edited.nv_shape = -1.0;
		assert edited.strengthFor(15) == edited.nv_lit : "a negative curve shape must not brighten daylight";
		edited.nv_shape = 1.0;
		edited.nv_lit_light = 40;
		assert edited.strengthFor(15) == edited.nv_lit : "the lit strength must be reachable at light 15";

		VisionSettings tweaked = new VisionSettings();
		tweaked.auto_nv = false;
		tweaked.nv_curve = true;
		tweaked.nv_lit = 0.25;
		tweaked.nv_dark = 0.75;
		tweaked.nv_shape = 2.5;
		tweaked.nv_lit_light = 7;
		tweaked.nv_speed = 0.5;
		VisionSettings restored = tweaked.copy();
		restored.copyFrom(new VisionSettings());
		for (java.lang.reflect.Field field : VisionSettings.class.getFields()) {
			try {
				assert field.get(restored).equals(field.get(new VisionSettings()))
					: field.getName() + " was not reset";
			} catch (IllegalAccessException exception) {
				throw new RuntimeException(exception);
			}
		}

		for (VisionSettings.Preset preset : VisionSettings.Preset.values()) {
			if (preset == VisionSettings.Preset.CUSTOM)
				continue;
			VisionSettings applied = tweaked.copy();
			preset.applyTo(applied);
			assert VisionSettings.Preset.of(applied) == preset : preset + " did not read back";
		}

		assert VisionSettings.Preset.of(new VisionSettings()) == VisionSettings.Preset.ALWAYS
			: "the defaults must read as always";

		VisionSettings slow = new VisionSettings();
		VisionSettings.Preset.SLOW.applyTo(slow);
		slow.nv_shape = 2.0;
		assert VisionSettings.Preset.of(slow) == VisionSettings.Preset.CUSTOM
			: "a moved slider must read as custom";

		VisionSettings never = tweaked.copy();
		VisionSettings.Preset.NEVER.applyTo(never);
		for (int light = 0; light <= 15; light++)
			assert never.strengthFor(light) == 0.0 : "never must show nothing at light " + light;

		VisionSettings kept = new VisionSettings();
		kept.auto_nv = false;
		VisionSettings.Preset.SLOW.applyTo(kept);
		assert !kept.auto_nv : "a preset must not change auto_nv";

		System.out.println("night vision curve ok");
	}
}
