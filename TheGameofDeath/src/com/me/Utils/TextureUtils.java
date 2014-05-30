package com.me.Utils;

import com.badlogic.gdx.tools.imagepacker.TexturePacker2;

public class TextureUtils {

	public static void main(String[] args) {

		TexturePacker2.process("./Skins/",
				"./after/", "textures");
	}
}
