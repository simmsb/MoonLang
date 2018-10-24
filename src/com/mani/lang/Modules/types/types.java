package com.mani.lang.Modules.types;

import java.util.List;

import com.mani.lang.Interpreter;
import com.mani.lang.ManiCallable;
import com.mani.lang.Modules.Module;

public final class types implements Module {

    @Override
    public void init(Interpreter interpreter) {
        interpreter.addSTD("isDigit", new ManiCallable(){
            @Override
            public int arity() {
                return 1;
            }

            @Override
            public Object call(Interpreter interpreter, List<Object> arguments) {
                return arguments.get(0).getClass().getSimpleName() == "Double";
            }
        });
        interpreter.addSTD("isChar", new ManiCallable(){
            @Override
            public int arity() {
                return 1;
            }

            @Override
            public Object call(Interpreter interpreter, List<Object> arguments) {
                return arguments.get(0).getClass().getSimpleName() == "Char";
            }
        });
        interpreter.addSTD("isString", new ManiCallable(){
            @Override
            public int arity() {
                return 1;
            }

            @Override
            public Object call(Interpreter interpreter, List<Object> arguments) {
                return arguments.get(0).getClass().getSimpleName() == "String";
            }
        });
        interpreter.addSTD("isBool", new ManiCallable(){
            @Override
            public int arity() {
                return 1;
            }

            @Override
            public Object call(Interpreter interpreter, List<Object> arguments) {
                return arguments.get(0).getClass().getSimpleName() == "Boolean";
            }
        });
        interpreter.addSTD("getType", new ManiCallable(){
        
            @Override
            public int arity() {
                return 1;
            }

            @Override
            public Object call(Interpreter interpreter, List<Object> arguments) {
                if (arguments.size() != 1) {
                    return "Please provide a single arguement of an object to check.";
                }
                switch (arguments.get(0).getClass().getSimpleName()) {
                case "String":
                    return "String";
                case "Double":
                    return "Number";
                case "ManiFunction":
                    return "Function";
                case "Boolean":
                    return "Boolean";
                }
                return arguments.get(0).getClass().getSimpleName();
            }
        });
	}

}