# CatVision

> **This is a fork of [MarioS271/cat_vision](https://github.com/MarioS271/cat_vision).**
> The mod is his work. Everything this fork adds is marked in green below.
> The download links are his official releases and do **not** include those additions.
> This fork is not published anywhere and has to be built from source.

A minecraft mod which gives you Night Vision, even if you aren't a server operator. Inspired by CatEyes by Tee6! :)

With this mod, you can give yourself night vision with the click of a button.
The mod also has options to automatically enable night vision.
And the best part: you don't need any permission, just use it anywhere!
(And don't tell anyone, but you can even suppress effects like Blindness or Nausea!)

This is a rewrite of CatVision 2.0, now known as CatVision Architectury, in order to expand compatibility to as many versions as possible, starting at 1.16.5.
The new mod supports Fabric (all versions), Forge (up to 1.20.1) and NeoForge (starting at 1.20.4).
To view the old mod, visit [Curseforge](https://www.curseforge.com/minecraft/mc-mods/catvision-architectury).

> **DISCLAIMER: I do not endorse anyone to use this mod in order to gain an advantage against others, especially in competitive settings. Please follow the rules of the server, realm or similar you are playing on! I am not responsible for any consequences of this mod being misused.**

---

### Current Features (v3.0):

```diff
  Smart Client-Side Night Vision
  Darkness/Blindness/Nausea Immunity
+ Night Vision presets: Slow adaptation, Adaptive, Always, Never, or your own Custom curve
+ Automatic Night Vision Curve, fading night vision in as it gets darker around you
+ Per-dimension settings, so night vision can be on in the Nether and off in the Overworld
+ Reset all settings, per-dimension overrides included
```

> Green lines are added by this fork, the rest is the original mod. Nothing about the original behaviour changes: a fresh config reads as the *Always* preset, which is how the mod worked before. On Forge the buildscripts also had to be taught to generate a mixin refmap, without which the curve's mixin cannot find its target.

> Note: Blindness Suppression is disabled in LAN and multiplayer worlds, as suppressing the blindness effect allows the player to sprint, which should not be possible while having the blindness effect.

### Languages:

```diff
  English
  German
  German (Austrian)
+ French
```

> The German and Austrian strings for the green features above were also written by this fork, not by the original author.

### Download here:
- [Modrinth](https://modrinth.com/mod/catvision)
- [Curseforge](https://curseforge.com/minecraft/mc-mods/catvision)

---

This project is licensed under the **GNU General Public License v3.0**. See the [LICENSE](LICENSE) file for details.
