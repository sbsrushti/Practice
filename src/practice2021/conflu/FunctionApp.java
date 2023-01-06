package practice2021.conflu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class FunctionApp {

    public static void main(String[] args) {
        JUnitCore.main(args);
    }

    @Test
    public void test() {

        FunctionLibrary library = new FunctionLibrary();
        Set<Function> functionSet = new HashSet<>();

        functionSet.add(new Function("FuncA", Arrays.asList("String", "Integer", "Integer"), false));
        functionSet.add(new Function("FuncB", Arrays.asList("String", "Integer"), true));
        //functionSet.add(new Function("FuncA", Arrays.asList("", ""), false));
        //functionSet.add(new Function("FuncA", Arrays.asList("", ""), false));

        library.register(functionSet);

        List<Function> result = library.findMatches(Arrays.asList("String", "Integer", "Integer"));
        List<String> resultNames = new ArrayList<>();

        for (Function function: result) {
            resultNames.add(function.name);
        }

        Assert.assertEquals(Arrays.asList("a", "b"), resultNames);
    }
}

interface IntNAme {

}

class Function implements IntNAme {
    String name;
    List<String> argumentTypes;
    boolean isVariadic;

    Function(String name, List<String> argumentTypes, boolean isVariadic) {
        this.name = name;
        this.argumentTypes = argumentTypes;
        this.isVariadic = isVariadic;
    }
}

class FunctionNode {
    String name;
    Map<String, FunctionNode> functionMapping;
    List<Function> funcWithVary;
    List<Function> funcWithoutVary;

    FunctionNode(String name) {
        this.name = name;
        this.functionMapping = new HashMap<>();
        this.funcWithVary = new ArrayList<>();
        this.funcWithoutVary = new ArrayList<>();
    }
}

class FunctionLibrary implements IntNAme {

    FunctionNode rootFunctionNode;

    FunctionLibrary() {
        this.rootFunctionNode = new FunctionNode("");
    }

    public void register(Set<Function> functionSet)  {
        // implement this method.
        for (Function function: functionSet) {
            addFunctionNode(function);
        }
    }

    private void addFunctionNode(Function function) {

        List<String> argumentTypes = function.argumentTypes;

        FunctionNode node = this.rootFunctionNode;

        for (String argumentType: argumentTypes) {

            if (node.functionMapping.containsKey(argumentType)) {
                node = node.functionMapping.get(argumentType);
            } else {
                FunctionNode newNode = new FunctionNode(argumentType);
                node.functionMapping.put(argumentType, newNode);
                node = newNode;
            }
        }

        if (function.isVariadic) {
            node.funcWithVary.add(function);
        } else {
            node.funcWithoutVary.add(function);
        }
    }

    public List<Function> findMatches(List<String> argumentTypes) {
        // implement this method.

        List<Function> result = new ArrayList<>();

        FunctionNode node = this.rootFunctionNode;

        int diffIdx = findIdx(argumentTypes);

        for (int i = 0; i < argumentTypes.size(); i++) {

            if (!node.functionMapping.containsKey(argumentTypes.get(i)))
                return result;

            node = node.functionMapping.get(argumentTypes.get(i));

            if (i < argumentTypes.size()-1) {

                if (diffIdx == i) {
                    result.addAll(node.funcWithVary);
                }

            } else {
                result.addAll(node.funcWithVary);
                result.addAll(node.funcWithoutVary);
            }
        }

        return result;
    }

    private int findIdx(List<String> argumentTypes) {

        String arg = argumentTypes.get(argumentTypes.size()-1);

        for (int i = argumentTypes.size()-2; i >= 0; i--) {
            if (!argumentTypes.get(i).equals(arg)) {
                return i + 1;
            }
        }

        return -1;
    }
}
