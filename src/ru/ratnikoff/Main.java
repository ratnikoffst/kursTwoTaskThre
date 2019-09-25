package ru.ratnikoff;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.Enum.valueOf;
import static javafx.scene.input.KeyCode.X;
import static javafx.scene.input.KeyCode.Y;

public class Main {


    //  2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
    //  В этот телефонный справочник с помощью метода add() можно добавлять записи.
    //  С помощью метода get() искать номер телефона по фамилии.
    //  Следует учесть, что под одной фамилией может быть несколько телефонов, тогда при запросе такой фамилии должны выводиться все телефоны.
    //  Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять еще дополнительные
    //  поля (имя, отчество, адрес), делать взаимодействие с пользователем через консоль и т.д.). Консоль желательно не использовать
    //  (в том числе Scanner), тестировать просто из метода main(), прописывая add() и get().
    static ArrayList<String> mArray = new ArrayList<>();

    static String[] mArrayString = new String[]{"Жизнь", "Взгляд", "Глаза", "Улыбка", "Смех", "Друзья", "Игра", "Радость", "Успех", "Ученье",
            "Жизнь", "Взгляд", "Глаза", "Улыбка", "Игра", "Радость", "Успех", "Ученье", "Школа", "Раздраженье"
    };
    static String[][] listPhones = new String[][]{{"Петручелло", "827326467347"},
            {"Тарас", "56546357657"},
            {"Теймураз", "375735757357"},
            {"Тимофей", "542454565687097"},
            {"Тимур", "545456367637"},
            {"Тихон", "753637657635"},
            {"Тристан", "765365375637"},
            {"Трифон", "746565476547"},
            {"Трофим", "7646765477654"},
            {"Тимофей", "47565474648764879"},
            {"Тимур", "64878746864"},
            {"Тихон", "48787687478467"}};


    static ArrayList<ListPhone> listPhone = new ArrayList<ListPhone>();
//    static ArrayList<String, Integer> mPhoneList = new ArrayList<>(){{"Дунь",123}};

    public static void main(String[] args) {
        //  1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
        //  Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        //  Посчитать, сколько раз встречается каждое слово.

        mArray.addAll(Arrays.asList(mArrayString));
        Map<String, Long> result = mArray.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        result.forEach((x, y) -> {
            if (y == 1) System.out.println(x);
        });
        result.forEach((x, y) -> System.out.println(x + "-" + y));


        //  2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
        //  В этот телефонный справочник с помощью метода add() можно добавлять записи.
        //  С помощью метода get() искать номер телефона по фамилии.
        //  Следует учесть, что под одной фамилией может быть несколько телефонов, тогда при запросе такой фамилии должны выводиться все телефоны.
        //  Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять еще дополнительные
        //  поля (имя, отчество, адрес), делать взаимодействие с пользователем через консоль и т.д.). Консоль желательно не использовать
        //  (в том числе Scanner), тестировать просто из метода main(), прописывая add() и get().
        String nameSearch = "Тимофей";
        for (int i = 0; i < listPhones.length; i++) {
            listPhone.add(new ListPhone(listPhones[i][0], listPhones[i][1]));
        }

        listPhone.forEach((name) -> {
            if (nameSearch.equals(name.getmName())) System.out.println(name.getmName() + "  " + name.getmTelephone());
        });
    }

    public static class ListPhone {
        private String mName = "";
        String mTelephone = "";

        public ListPhone(String name, String Phone) {
            mName = name;
            mTelephone = Phone;
        }

        public String getmName() {
            return mName;
        }

        public String getmTelephone() {
            return mTelephone;
        }
    }
}

