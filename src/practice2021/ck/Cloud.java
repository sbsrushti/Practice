package practice2021.ck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Cloud {

    public static void main(String[] args) {

        List<String> lines = new ArrayList<>(Arrays.asList("4", "DISH", "Spaghetti", "10.95", "2", "3", "", "1", "CATEGORY", "Pasta", "4", "5", "", "2", "OPTION", "Meatballs", "1.00", "",
                "3", "OPTION", "Chicken", "2.00", "", "5", "DISH", "Lasagna", "12.00", "", "6", "DISH", "Caesar Salad", "9.75", "3", ""));


        Menu menu = new Menu();
        menu.updateMenu(lines);

        System.out.println(menu.getDish(4));

        MenuStreamIteratorImpl menuStreamIterator = new MenuStreamIteratorImpl();

        String line = menuStreamIterator.getNext();
        while (line != null) {
            System.out.println(line);
            line = menuStreamIterator.getNext();
        }

    }
}

interface MenuStreamIterator {

    public String getNext();
}

class MenuStreamIteratorImpl implements MenuStreamIterator {

    List<String> lines = new ArrayList<>(Arrays.asList("4", "DISH", "Spaghetti", "10.95", "2", "3", "", "1", "CATEGORY", "Pasta", "4", "5", "", "2", "OPTION", "Meatballs", "1.00", "",
            "3", "OPTION", "Chicken", "2.00", "", "5", "DISH", "Lasagna", "12.00", "", "6", "DISH", "Caesar Salad", "9.75", "3", ""));

    Iterator<String> iterator = lines.iterator();

    int index = 0;

    @Override
    public String getNext() {
        return iterator.next();
    }
}
class Menu {

    Map<Integer, Dish> dishes;
    Map<Integer, Category> categories;
    Map<Integer, Option> options;

    Menu() {
        this.dishes = new HashMap<>();
        this.categories = new HashMap<>();
        this.options = new HashMap<>();
    }

    // update the maps!
    public void updateMenu(List<String> lines) {

        int i = 0;

        while (i < lines.size()) {

            int id = Integer.parseInt(lines.get(i++));
            Type type = Type.valueOf(lines.get(i++));

            if (type == Type.DISH) {
                String name = lines.get(i++);
                double price = Double.parseDouble(lines.get(i++));

                List<Integer> items = new ArrayList<>();
                while (i < lines.size() && !lines.get(i).equals("")) {
                    items.add(Integer.parseInt(lines.get(i++)));
                }
                dishes.put(id, new Dish(id, name, price, items));
            }

            else if (type == Type.CATEGORY) {
                String name = lines.get(i++);

                List<Integer> items = new ArrayList<>();
                while (i < lines.size() && !lines.get(i).equals("")) {
                    items.add(Integer.parseInt(lines.get(i++)));
                }
                categories.put(id, new Category(id, name, items));
            }

            else if (type == Type.OPTION) {
                String name = lines.get(i++);
                double price = Double.parseDouble(lines.get(i++));
                options.put(id, new Option(id, name, price));
            }

            if (lines.get(i).equals("")) i++;
        }
    }

    public String getDish(int dishId) {

        if (!dishes.containsKey(dishId)) {
            throw new IllegalArgumentException("Dish ID does not exist!");
        }

        Dish dish = dishes.get(dishId);

        StringBuilder sb = new StringBuilder();
        sb.append(dish.name).append(": \n");
        sb.append("Price: ").append(dish.price).append("\n");
        sb.append("Type: ").append(dish.type).append("\n");
        sb.append("Options:").append("\n");

        for (Integer optionId: dish.optionItems) {
            sb.append(getOption(optionId)).append("\n");
        }

        return sb.toString();
    }

    public String getCategory(int categoryId) {

        if (!categories.containsKey(categoryId)) {
            throw new IllegalArgumentException("Category ID does not exist!");
        }

        Category category = categories.get(categoryId);

        StringBuilder sb = new StringBuilder();
        sb.append(category.name).append(": \n");
        sb.append("Type: ").append(category.type).append("\n");
        sb.append("Items:").append("\n");

        for (Integer itemId: category.items) {
            sb.append(getDish(itemId)).append("\n");
        }

        return sb.toString();
    }

    private String getOption(int optionId) {

        if (!options.containsKey(optionId)) {
            throw new IllegalArgumentException("Option ID does not exist!");
        }

        Option option = options.get(optionId);

        StringBuilder sb = new StringBuilder();
        sb.append(option.name).append(": \n");
        sb.append("Price: ").append(option.price).append("\n");
        sb.append("Type: ").append(option.type).append("\n");

        return sb.toString();
    }
}

enum Type {
    DISH,
    CATEGORY,
    OPTION
}

abstract class Item {
    int id;
    String name;
    Type type;

    Item(int id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
}

class Dish extends Item {

    double price;
    List<Integer> optionItems;

    Dish(int id, String name, double price, List<Integer> optionItems) {
        super(id, name, Type.DISH);
        this.price = price;
        this.optionItems = optionItems;
    }
}

class Category extends Item {
    List<Integer> items;

    Category(int id, String name, List<Integer> items) {
        super(id, name, Type.CATEGORY);
        this.items = items;
    }
}

class Option extends Item {
    double price;

    Option(int id, String name, double price) {
        super(id, name, Type.OPTION);
        this.price = price;
    }
}

