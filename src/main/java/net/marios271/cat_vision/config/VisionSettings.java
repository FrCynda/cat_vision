package net.marios271.cat_vision.config;

public class VisionSettings {
	public boolean auto_nv = true;

	public boolean nv_curve = false;
	public double nv_lit = 0.0;
	public double nv_dark = 1.0;
	public double nv_shape = 1.0;
	public int nv_lit_light = 12;
	public double nv_speed = 0.01;

	public enum Preset {
		SLOW,
		ADAPTIVE,
		ALWAYS,
		NEVER,
		CUSTOM;

		public void applyTo(VisionSettings settings) {
			VisionSettings defaults = new VisionSettings();
			switch (this) {
				case ALWAYS:
					settings.nv_curve = false;
					break;
				case NEVER:
					settings.nv_curve = true;
					settings.nv_lit = 0.0;
					settings.nv_dark = 0.0;
					break;
				case SLOW:
				case ADAPTIVE:
					settings.nv_curve = true;
					settings.nv_lit = defaults.nv_lit;
					settings.nv_dark = defaults.nv_dark;
					settings.nv_lit_light = defaults.nv_lit_light;
					settings.nv_shape = defaults.nv_shape;
					settings.nv_speed = this == SLOW ? defaults.nv_speed : 0.1;
					settings.auto_nv = defaults.auto_nv;
					break;
				default:
					break;
			}
		}

		public static Preset of(VisionSettings settings) {
			if (!settings.nv_curve)
				return ALWAYS;
			if (settings.nv_lit == 0.0 && settings.nv_dark == 0.0)
				return NEVER;
			for (Preset preset : new Preset[] { SLOW, ADAPTIVE }) {
				VisionSettings applied = settings.copy();
				preset.applyTo(applied);
				if (applied.sameAs(settings))
					return preset;
			}
			return CUSTOM;
		}
	}

	public double strengthFor(int light) {
		double darkness = (nv_lit_light - light) / (double) nv_lit_light;
		return clamp(nv_lit + (nv_dark - nv_lit) * Math.pow(darkness, nv_shape), 0.0, 1.0);
	}

	public boolean sameAs(VisionSettings other) {
		return auto_nv == other.auto_nv && sameCurveAs(other);
	}

	public boolean sameCurveAs(VisionSettings other) {
		return nv_curve == other.nv_curve
			&& nv_lit == other.nv_lit
			&& nv_dark == other.nv_dark
			&& nv_lit_light == other.nv_lit_light
			&& nv_shape == other.nv_shape
			&& nv_speed == other.nv_speed;
	}

	public VisionSettings copy() {
		VisionSettings copy = new VisionSettings();
		copy.copyFrom(this);
		return copy;
	}

	public void copyFrom(VisionSettings other) {
		auto_nv = other.auto_nv;
		nv_curve = other.nv_curve;
		nv_lit = other.nv_lit;
		nv_dark = other.nv_dark;
		nv_shape = other.nv_shape;
		nv_lit_light = other.nv_lit_light;
		nv_speed = other.nv_speed;
	}

	public static double clamp(double value, double min, double max) {
		return value < min ? min : Math.min(value, max);
	}
}
