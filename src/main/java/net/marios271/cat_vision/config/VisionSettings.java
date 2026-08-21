package net.marios271.cat_vision.config;

public class VisionSettings {
	public boolean nv_curve = false;
	public double nv_lit = 0.0;
	public double nv_dark = 1.0;
	public double nv_shape = 1.0;
	public int nv_lit_light = 12;
	public double nv_speed = 0.01;

	public double strengthFor(int light) {
		double darkness = (nv_lit_light - light) / (double) nv_lit_light;
		return clamp(nv_lit + (nv_dark - nv_lit) * Math.pow(darkness, nv_shape), 0.0, 1.0);
	}

	public static double clamp(double value, double min, double max) {
		return value < min ? min : Math.min(value, max);
	}
}
