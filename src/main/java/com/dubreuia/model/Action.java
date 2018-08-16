package com.dubreuia.model;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public enum Action {

    // Activation

    activate("Activate save actions on save (before saving each file, performs the configured actions below)", true),

    activateOnShortcut("Activate save actions on shortcut (default \"CTRL + SHIFT + S\")", false),

    noActionIfCompileErrors("No action if compile errors", false),

    // Global

    organizeImports("Optimize imports", true),

    reformat("Reformat file", true),

    reformatChangedCode("Reformat only changed code (only if VCS configured)", false),

    rearrange("Rearrange fields and methods (configured in \"Editor > Code Style > (...) > Arrangement\")", false),

    // Build

    compile("Compile file", false),

    // Java fixes

    fieldCanBeFinal("Add final modifier to field", false),

    localCanBeFinal("Add final modifier to local variable or parameter", false),

    methodMayBeStatic("Add static modifier to methods", false),

    unqualifiedFieldAccess("Add this to field access", false),

    unqualifiedMethodAccess("Add this to method access", false),

    unqualifiedStaticMemberAccess("Add class qualifier to static member access", false),

    customUnqualifiedStaticMemberAccess("Add class qualifier to static member access outside declaring class only", false),

    missingOverrideAnnotation("Add missing @Override annotations", false),

    useBlocks("Add blocks to if/while/for statements", false),

    generateSerialVersionUID("Add a serialVersionUID field for Serializable classes", false),

    unnecessaryThis("Remove unnecessary this to field and method", false),

    finalPrivateMethod("Remove final from private method", false),

    unnecessaryFinalOnLocalVariableOrParameter("Remove unnecessary final to local variable or parameter", false),

    explicitTypeCanBeDiamond("Remove explicit generic type for diamond", false),

    suppressAnnotation("Remove unused suppress warning annotation", false),

    unnecessarySemicolon("Remove unnecessary semicolon", false),

    accessCanBeTightened("Change visibility of field or method to lower access", false),

    //
    ;

    private final String text;

    private final boolean defaultValue;

    Action(String text, boolean defaultValue) {
        this.text = text;
        this.defaultValue = defaultValue;
    }

    public boolean isDefaultValue() {
        return defaultValue;
    }

    public String getText() {
        return text;
    }

    public static Set<Action> getDefaults() {
        return Arrays.stream(Action.values())
                .filter(Action::isDefaultValue)
                .collect(toSet());
    }

    public static Stream<Action> stream() {
        return Arrays.stream(values());
    }

}