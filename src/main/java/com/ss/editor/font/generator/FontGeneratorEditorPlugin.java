package com.ss.editor.font.generator;

import com.ss.editor.annotation.FromAnyThread;
import com.ss.editor.font.generator.creator.BitmapFontFileCreator;
import com.ss.editor.manager.FileIconManager;
import com.ss.editor.plugin.EditorPlugin;
import com.ss.editor.ui.component.creator.FileCreatorRegistry;
import com.ss.rlib.plugin.PluginContainer;
import com.ss.rlib.plugin.annotation.PluginDescription;
import com.ss.rlib.util.Utils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.URL;

/**
 * The implementation of an editor plugin.
 *
 * @author JavaSaBr
 */
@PluginDescription(
        id = "com.ss.editor.font.generator",
        version = "1.0.6",
        minAppVersion = "1.6.0",
        name = "jME Font Generator",
        description = "Providers a new file wizard to generate native jME fonts based on system fonts."
)
public class FontGeneratorEditorPlugin extends EditorPlugin {

    @NotNull
    public static final String FONT_EXTENSION = "fnt";

    public FontGeneratorEditorPlugin(@NotNull final PluginContainer pluginContainer) {
        super(pluginContainer);
    }

    @Override
    @FromAnyThread
    public void register(@NotNull final FileCreatorRegistry registry) {
        super.register(registry);
        registry.register(BitmapFontFileCreator.DESCRIPTION);
    }

    @Override
    @FromAnyThread
    public void register(@NotNull final FileIconManager iconManager) {
        iconManager.register((path, extension) -> {

            if (FONT_EXTENSION.equals(extension)) {
                return "com/ss/editor/font/generator/icons/text.svg";
            }

            return null;
        });
    }

    @Override
    @FromAnyThread
    public @Nullable URL getHomePageUrl() {
        return Utils.get("https://github.com/JavaSaBr/jmb-font-generator", URL::new);
    }
}
